package prompt.guava;

import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SetUtilsDemo {

  /**
   * 不可变集合
   */
  public static void immutableSetTest() {
    // 使用builder创建
    Set<String> immutableNamedColors = ImmutableSet.<String>builder()
        .add("red", "green", "black", "white", "grey")
        .build();

    // 使用of静态方法创建
    ImmutableSet.of("red", "green", "black", "white", "grey");

    // 使用of静态方法创建
    ImmutableSet.copyOf(new String[]{"red", "green", "black", "white", "grey"});

    // immutableNamedColors.add("abc"); // 不可变集合是无法进行增删改的
    for (String color : immutableNamedColors) {
      System.out.println(color);
    }
  }

  /**
   * Multiset看似是一个Set，但是实质上它不是一个Set，它没有继承Set接口，它继承的是Collection<E>接口， 你可以向Multiset中添加重复的元素，Multiset会对添加的元素做一个计数。
   */
  public static void multisetTest() {
    Multiset multiset = HashMultiset.create();
    String sentences = "this is a story, there is a good girl in the story.";
    Iterable<String> words = Splitter.onPattern("[^a-z]{1,}").omitEmptyStrings().trimResults()
        .split(sentences);
    for (String word : words) {
      multiset.add(word);
    }

    for (Object element : multiset.elementSet()) {
      System.out.println((String) element + ":" + multiset.count(element));
    }
  }

  /**
   * google guava的BiMap：双向Map 既提供键到值的映射，也提供值到键的映射，所以它是双向Map
   */
  public static void biMapTest() {
    BiMap<String, String> weekNameMap = HashBiMap.create();
    weekNameMap.put("星期一", "Monday");
    weekNameMap.put("星期二", "Tuesday");
    weekNameMap.put("星期三", "Wednesday");
    weekNameMap.put("星期四", "Thursday");
    weekNameMap.put("星期五", "Friday");
    weekNameMap.put("星期六", "Saturday");
    weekNameMap.put("星期日", "Sunday");

    System.out.println("星期日的英文名是" + weekNameMap.get("星期日"));
    System.out.println("Sunday的中文是" + weekNameMap.inverse().get("Sunday"));
  }

  /**
   * google guava的Multimaps：一键多值的Map 有时候我们需要这样的数据类型Map<String,Collection<String>>，guava中的Multimap就是为了解决这类问题的。
   */
  public static void multimapsTest() {
    Multimap<String, String> myMultimap = ArrayListMultimap.create();

    // 添加键值对
    myMultimap.put("Fruits", "Bannana");
    //给Fruits元素添加另一个元素
    myMultimap.put("Fruits", "Apple");
    myMultimap.put("Fruits", "Pear");
    myMultimap.put("Vegetables", "Carrot");

    // 获得multimap的size
    int size = myMultimap.size();
    System.out.println(size);  // 4

    // 获得Fruits对应的所有的值
    Collection<String> fruits = myMultimap.get("Fruits");
    System.out.println(fruits); // [Bannana, Apple, Pear]

    Collection<String> vegetables = myMultimap.get("Vegetables");
    System.out.println(vegetables); // [Carrot]

    //遍历Mutlimap
    for (String value : myMultimap.values()) {
      System.out.println(value);
    }

    // Removing a single value
    myMultimap.remove("Fruits", "Pear");
    System.out.println(myMultimap.get("Fruits")); // [Bannana, Pear]

    // Remove all values for a key
    myMultimap.removeAll("Fruits");
    System.out.println(myMultimap.get("Fruits")); // [] (Empty Collection!)
  }

  /**
   * google guava集合之Table
   * 在guava库中还提供了一种二维表结构：Table。使用Table可以实现二维矩阵的数据结构，可以是稀溜矩阵。
   */
  public static void  tableTest() {
    Table<Integer, Integer, String> table = HashBasedTable.create();
    for (int row = 0; row < 10; row++) {
      for (int column = 0; column < 5; column++) {
        table.put(row, column, "value of cell (" + row + "," + column + ")");
      }
    }
    for (int row=0;row<table.rowMap().size();row++) {
      Map<Integer,String> rowData = table.row(row);
      for (int column =0;column < rowData.size(); column ++) {
        System.out.println("cell(" + row + "," + column + ") value is:" + rowData.get(column));
      }
    }
  }

  /**
   * Guava集合：使用Iterators简化Iterator操作
   * Iterators是Guava中对Iterator迭代器操作的帮助类，这个类提供了很多有用的方法来简化Iterator的操作。
   */
  public static void iteratorsTest() {
    List<String> list = Lists.newArrayList("Apple","Pear","Peach","Banana");

    Predicate<String> condition = new Predicate<String>() {
      @Override
      public boolean apply(String input) {
        return ((String)input).startsWith("P");
      }
    };
    boolean allIsStartsWithP = Iterators.all(list.iterator(), condition);
    System.out.println("all result == " + allIsStartsWithP);
  }

  public static void main(String[] args) {
    // immutableSetTest();
    // multisetTest();
    // biMapTest();
    // multimapsTest();
    tableTest();
  }

}
