package practice.thread.std15;

import practice.thread.std15.AnnotationDemo.SetProperty;
import practice.thread.std15.AnnotationDemo.SetTable;

@SetTable(value = "tb_user")
public class User {
  @SetProperty(name = "id", leng = 10)
  private String id;
  @SetProperty(name = "name", leng = 10)
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}