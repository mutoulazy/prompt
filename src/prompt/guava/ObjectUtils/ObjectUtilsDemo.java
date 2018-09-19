package prompt.guava.ObjectUtils;


import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class ObjectUtilsDemo {
  // 比较两个对象是否相等
  public static void equalTest() {
    Object a = null;
    Object b = new Object();
   System.out.println(Objects.equal(a, b));
  }

  // 参数校验
  public static void preconditionsTest(String name, int age, String desc) {
    Preconditions.checkNotNull(name, "name may not be null");
    Preconditions.checkArgument(age >= 18 && age < 99, "age must in range (18,99)");
    Preconditions.checkArgument(desc !=null && desc.length() < 10, "desc too long, max length is ", 10);

    // doSomething
  }

  // 使用google guava的Optional接口来避免空指针错误
  public static void optionalTest() {
    Optional<Student> possibleNull = Optional.of(null);
    Student student = possibleNull.get();
  }

  public static void optionalTest2() {
    Optional<Student> possibleNull = Optional.absent();
    Student student =  possibleNull.get();
  }


  public static void main(String[] args) {
    // equalTest();
    // preconditionsTest("123", 19, "test");
    // optionalTest();
    optionalTest2();


  }

  public static class Student {}
}
