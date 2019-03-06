package practice.thread.std15;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class AnnotationDemo {

  @Target(value = {ElementType.TYPE})
  @Retention(RetentionPolicy.RUNTIME)
  public @interface SetTable{
    String value();
  }

  @Retention(RetentionPolicy.RUNTIME)
  public @interface SetProperty {
    String name();
    int leng();
  }

  public static void main(String[] args) throws ClassNotFoundException{
    Class<?> forName = Class.forName("practice.thread.std15.User");
    StringBuffer sf = new StringBuffer();
    sf.append("select");
    // 获取属性
    Field[] fields = forName.getDeclaredFields();
    for (int i = 0; i < fields.length; i++) {
      Field field = fields[i];
      SetProperty propertyAnnota = field.getDeclaredAnnotation(SetProperty.class);
      String prppertyName = propertyAnnota.name();
      sf.append(" " + prppertyName);
      if (i < fields.length - 1) {
        sf.append(",");
      }
    }
    SetTable tableAnnota = forName.getDeclaredAnnotation(SetTable.class);
    String tableName = tableAnnota.value();
    sf.append(" from " + tableName);
    System.out.println(sf.toString());
  }
}
