package prompt.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import java.util.HashMap;
import java.util.Map;

public class StringUtilsDemo {

  // 使用com.google.common.base.Strings类的isNullOrEmpty(input)方法判断字符串是否为空
  private static void isNullOrEmptyTest() {
    String input = null;
    boolean isNullOrEmpty = Strings.isNullOrEmpty(input);
    System.out.println("input " + (isNullOrEmpty ? "is" : "is not") + " null or empty.");
  }

  // 获得两个字符串相同的前缀或者后缀
  private static void commonPrefixTest() {
    //Strings.commonPrefix(a,b) demo
    // 取相同前缀
    String a = "com.jd.coo.Hello";
    String b = "com.jd.coo.Hi";
    String ourCommonPrefix = Strings.commonPrefix(a, b);
    System.out.println("a,b common prefix is " + ourCommonPrefix);

    //Strings.commonSuffix(a,b) demo
    // 取相同后缀
    String c = "com.google.Hello";
    String d = "com.jd.Hello";
    String ourSuffix = Strings.commonSuffix(c, d);
    System.out.println("c,d common suffix is " + ourSuffix);
  }

  // Strings的padStart和padEnd方法来补全字符串
  public static void padStartTest() {
    int minLength = 10;
    String padEndResult = Strings.padEnd("123", minLength, '0');
    System.out.println("padEndResult is " + padEndResult);

    String padStartResult = Strings.padStart("1", minLength, '0');
    System.out.println("padStartResult is " + padStartResult);
  }

  // 使用Splitter类来拆分字符串 正则匹配
  public static void splitterTest() {
    Iterable<String> splitResults = Splitter.onPattern("[,，]{1,}") // 进行正则匹配
        .trimResults() //对结果做trim
        .omitEmptyStrings() // 忽略空字符串
        .split("hello,word,,世界，水平"); // 需要进行拆分的字符串

    for (String item : splitResults) {
      System.out.println(item);
    }
  }

  // 做二次拆分，这里二次拆分的意思是拆分两次，例如我们可以将a=b;c=d这样的字符串拆分成一个Map<String,String>
  public static void splitterTest2() {
    String toSplitString = "a=b;c=d,e=f";
    Map<String, String> map = Splitter.onPattern("[,;]{1,}")
        .withKeyValueSeparator('=') // 第二次拆分
        .split(toSplitString);

    for (Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println(String.format("%s=%s", entry.getKey(),entry.getValue()));
    }
  }

  // 合并字符串，guava为我们提供了Joiner类来做字符串的合并
  public static void joinerTest() {
    String joinResult = Joiner.on(" ").join(new String[]{"hello","world"});
    System.out.println(joinResult);
  }

  // Splitter方法可以对字符串做二次的拆分，对应的Joiner也可以逆向操作，将Map<String,String>做合并。
  public static void joinerTest2() {
    Map<String,String> map = new HashMap<String,String>();
    map.put("a", "b");
    map.put("c", "d");
    String mapJoinResult = Joiner.on(",")
        .withKeyValueSeparator("=") //key value之间用 = 号拼接
        .join(map);
    System.out.println(mapJoinResult);
  }

  public static void main(String[] args) {
    // isNullOrEmptyTest();
    // commonPrefixTest();
    // padStartTest();
    // splitterTest();
    // splitterTest2();
    // joinerTest();
    joinerTest2();
  }
}
