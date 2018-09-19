package prompt.test.json;

public class ReplaceTest {
  public static void main(String [] args) {
    String s = "wahaha\rwaheihei\nwahoho";
    System.out.println(s);
    s = s.replaceAll("\r\n", "<br>");//需要分开处理
    System.out.println("~~~~~~~~");
    System.out.println(s);
    s = s.replaceAll("\r", "<br>");
    s = s.replaceAll("\n","<br>" );
    System.out.println("~~~~~~~~");
    System.out.println(s);
  }

  
}
