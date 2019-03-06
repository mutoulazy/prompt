package practice.thread.std01;

public class UserEntity {
  private String userName;
  private String  userId;

  public UserEntity() {
  }

  public UserEntity(String userName, String userId) {
    this.userName = userName;
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
