package practice.thread.std01;

import java.util.List;

public class UserThread extends Thread {

  private List<UserEntity> userEntityList;

  public UserThread(List<UserEntity> userEntityList) {
    this.userEntityList = userEntityList;
  }

  @Override
  public void run() {
    for (UserEntity user : userEntityList) {
      System.out.println(
          Thread.currentThread().getName() + ":" + user.getUserId() + ":" + user.getUserName());

      //TODO

    }
  }
}
