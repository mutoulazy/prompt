package prompt.streamstudy;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import prompt.streamstudy.Dish.Type;

public class StreamCollectorTest {
  public enum CaloricLevel { DIET, NORMAL, FAT };
  public static List<Dish> list = Arrays.asList(
      new Dish("pork", false, 800, Dish.Type.MEAT),
      new Dish("beef", false, 700, Dish.Type.MEAT),
      new Dish("chicken", false, 400, Dish.Type.MEAT),
      new Dish("french fries", true, 530, Dish.Type.OTHER),
      new Dish("rice", true, 350, Dish.Type.OTHER),
      new Dish("season fruit", true, 120, Dish.Type.OTHER),
      new Dish("pizza", true, 550, Dish.Type.OTHER),
      new Dish("prawns", false, 300, Dish.Type.FISH),
      new Dish("salmon", false, 450, Dish.Type.FISH) );

  public static void main(String[] args) {
    // maxOrMixTest();
    // summingTest();
    // joinTest();
    groupingByTest();
  }

  /**
   * 最大最小值
   */
  public static void maxOrMixTest() {
    list.stream()
        .collect(maxBy(Comparator.comparingInt(Dish::getCalories)))
        .ifPresent(System.out::println);

    list.stream()
        .collect(minBy(Comparator.comparingInt(Dish::getCalories)))
        .ifPresent(System.out::print);
  }

  /**
   * 统计
   */
  public static void summingTest() {
    System.out.println(list.stream()
        .collect(summarizingInt(Dish::getCalories)));

    System.out.println(list.stream().collect(averagingInt(Dish::getCalories)));
  }

  /**
   * 拼接
   */
  public static void joinTest() {
    System.out.println(list.stream().map(Dish::getName).collect(joining(", ")));
  }

  /**
   * Collectors.reducing方法可以实现求和，最大值最小值筛选，拼接等操作。
   */
  public static void reducingTest() {
    System.out.println(list.stream().collect(reducing(0, Dish::getCalories, Integer::max)));
    System.out.println(list.stream().map(Dish::getCalories).collect(reducing(0, Integer::max)));
  }

  /**
   * Collectors.groupingBy方法可以完成分组操作。
   */
  public static void groupingByTest() {
    // 普通用法
    Map<Type, List<Dish>> dishesByType = list.stream().collect(groupingBy(Dish::getType));
    System.out.println(dishesByType);

    // 自定义分组条件
    Map<CaloricLevel, List<Dish>> dishesByCalories = list.stream().collect(
        groupingBy(d -> {
          if (d.getCalories() <= 400) return CaloricLevel.DIET;
          else if (d.getCalories() <= 700) return CaloricLevel.NORMAL;
          else return CaloricLevel.FAT;
        })
    );
    System.out.println(dishesByCalories);

    // 多级分组
    Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesGroup = list.stream().collect(
        groupingBy(Dish::getType, groupingBy(d -> {
              if (d.getCalories() <= 400) return CaloricLevel.DIET;
              else if (d.getCalories() <= 700) return CaloricLevel.NORMAL;
              else return CaloricLevel.FAT;
            })
        ));
    System.out.println(dishesGroup);

    // 分组同时统计数量
    Map<Dish.Type, Long> dishesCountByType = list.stream().collect(groupingBy(Dish::getType,counting()));
    System.out.println(dishesCountByType);

    //对食材按照类型分，然后选出卡路里最高的食物
    Map<Dish.Type, Optional<Dish>> map = list.stream().collect(groupingBy(
        Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))
    ));
    System.out.println(map);
    Map<Dish.Type, Dish> map2 = list.stream().collect(groupingBy(
        Dish::getType, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)
    ));
  }

  /**
   * 分区类似于分组，只不过分区最多两种结果。
   */
  public static void partitioningByTest() {
    Map<Boolean, List<Dish>> map1 = list.stream().collect(partitioningBy(Dish::isVegetarian));
    System.out.println(map1);

    Map<Boolean, Map<Dish.Type, List<Dish>>> map2 = list.stream().collect(
        partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
    System.out.println(map2);

    Map<Boolean, Dish> map3 = list.stream().collect(
        partitioningBy(Dish::isVegetarian, collectingAndThen(
            minBy(Comparator.comparing(Dish::getCalories)), Optional::get
        )));
    System.out.println(map3);
  }
}
