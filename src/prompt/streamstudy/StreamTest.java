package prompt.streamstudy;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream的基本用法 参考 https://mrbird.cc/java8stream1.html
 */
public class StreamTest {

  public static List<String> list = Arrays
      .asList("Java", "JavaScript", "python", "PHP", "C#", "Golang", "Swift");

  public static void main(String[] args) {
    // oldHandle();
    // streamHandle();
    // filterTest();
    // distinctTest();
    // skipTest();
    // limitTest();
    // mapTest();
    // flatMapTest();
    reduceTest();
  }


  public static void streamHandle() {
    list.stream()
        .filter(s -> s.startsWith("J"))
        .map(String::toUpperCase)
        .forEach(System.out::println);
  }

  // 中间操作

  /**
   * 对集合进行筛选，返回所有满足的元素
   */
  public static void filterTest() {
    list.stream()
        .filter(s -> s.contains("#"))
        .forEach(System.out::println);
  }

  /**
   * distinct方法用于排除流中重复的元素
   */
  public static void distinctTest() {
    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    numbers.stream()
        .filter(i -> i % 2 == 0)
        .distinct()
        .forEach(System.out::println);
  }

  /**
   * 跳过流中的前n个元素，如果集合元素小于n，则返回空流
   */
  public static void skipTest() {
    list.stream()
        .filter(s -> s.startsWith("J"))
        .skip(1)
        .forEach(System.out::print);
  }

  /**
   * 返回一个长度不超过n的流
   */
  public static void limitTest() {
    list.stream()
        .limit(3)
        .forEach(System.out::println);
  }

  /**
   * map方法接收一个函数作为参数。这个函数会被应用到每个元素上，并将其映射成一个新的元素
   */
  public static void mapTest() {
    list.stream()
        .map(String::length)
        .forEach(System.out::println);

    // map 还可以把 stream 转化为传统的 InputStream DoubleStream 等
    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    IntStream intStream = numbers.stream().mapToInt(a -> a);
    System.out.println(intStream.sum());

    // InputStream 也可以转化为 Stream
    Stream<Integer> s = intStream.boxed();
  }

  /**
   * flatMap用于将多个流合并成一个流，俗称流的扁平化。
   */
  public static void flatMapTest() {
    list.stream()
        .map(s -> s.split(""))
        .flatMap(Arrays::stream)
        .distinct()
        .forEach(s -> System.out.print(s + " "));

    // 和map类似，flatMap方法也有相应的原始类型特化方法，如flatMapToInt等。
  }

  // 终端操作

  /**
   * anyMatch方法用于判断流中是否有符合判断条件的元素，返回值为boolean类型。
   */
  public static void anyMatchTest() {
    list.stream()
        .anyMatch(s -> "SQL".equals(s));
  }

  /**
   * allMatch方法用于判断流中是否所有元素都满足给定的判断条件，返回值为boolean类型。
   */
  public static void allMatchTest() {
    list.stream()
        .allMatch(s -> s.length() <= 10);
  }

  /**
   * noneMatch方法用于判断流中是否所有元素都不满足给定的判断条件，返回值为boolean类型。
   */
  public static void noneMatchTest() {
    list.stream()
        .noneMatch(s -> s.length() > 10);
  }

  /**
   * findAny方法用于返回流中的任意元素的Optional类型
   */
  public static void findAnyTest() {
    list.stream()
        .filter(s -> s.startsWith("J"))
        .findAny()
        .ifPresent(System.out::println);
  }

  /**
   * findFirst方法用于返回流中的第一个元素的Optional类型
   */
  public static void findFirstTest() {
    list.stream()
        .filter(s -> s.length() > 5)
        .findFirst()
        .ifPresent(System.out::print);
  }

  /**
   * reduce函数从字面上来看就是压缩，缩减的意思，它可以用于数字类型的流的求和，求最大值和最小值。
   */
  public static void reduceTest() {
    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    numbers.stream()
        .reduce(Integer::sum)
        .ifPresent(System.out::println);

    numbers.stream()
        .reduce(Integer::max)
        .ifPresent(System.out::println);

    numbers.stream()
        .reduce(Integer::min)
        .ifPresent(System.out::println);
  }

  /**
   * collect方法用于收集流中的元素，并放到不同类型的结果中
   */
  public static void collectTest() {
    List<String> filterList = list.stream()
        .filter(s -> s.startsWith("J")).collect(Collectors.toList());
  }

  /**
   * 流的通常构造方法
   */
  public void buildStream() {
    IntStream.rangeClosed(1, 100).sum();

    Stream<String> s = Stream.of("Java", "JavaScript", "C++", "Ruby");
    Stream<Object> emptyStream = Stream.empty();

    int[] arr = {1, 2, 3, 4, 5};
    IntStream intStream = Arrays.stream(arr);

    long wordCout = 0L;
    try (Stream<String> lines = Files.lines(Paths.get("file.txt"), Charset.defaultCharset())) {
      wordCout = lines.map(l -> l.split(""))
          .flatMap(Arrays::stream)
          .count();
    } catch (Exception ignore) {
    }

    Stream.iterate(0, n -> n + 2)
        .limit(10).forEach(System.out::println);

    Stream.generate(Math::random)
        .limit(5)
        .forEach(System.out::println);
  }

  public static void oldHandle() {
    List<String> filterList = new ArrayList<>();
    for (String str : list) {
      if (str.startsWith("J")) {
        filterList.add(str.toUpperCase());
      }
    }
    for (String str : filterList) {
      System.out.println(str);
    }
  }
}
