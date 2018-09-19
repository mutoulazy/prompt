package prompt.annotation;

import java.util.Date;

@Table(name = "Student")
public class TestBean {

  @Column(name = "age", length = 3)
  int age;
  @Column(name = "userName", length = 10)
  String name;
  @Column(name = "birthday", defaultValue = "sysdate")
  Date birthday;
}
