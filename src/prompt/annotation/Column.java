package prompt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 Column
 * 详细解释参考https://mrbird.cc/%E8%87%AA%E5%AE%9A%E4%B9%89annotation.html
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
  String name() default ""; // name用来设置字段名
  int length() default 0; // length用来设置字段长度
  String defaultValue() default ""; // defaultValue用来设置默认值
}
