package practice.thread.std01;

import java.util.ArrayList;
import java.util.List;

/**
 * 主类
 */
public class BatchSms {

  public static void main(String[] args) {
    List<UserEntity> list = initUser(11);
    int userCount = 2;
    List<List<UserEntity>> splitList = ListUtils.splitList(list, userCount);
    for (int i = 0; i<splitList.size(); i++) {
      List<UserEntity> userList = splitList.get(i);
      UserThread userThread = new UserThread(userList);

      Thread thread = new Thread(userThread, "Thread:" + i);
      thread.start();
    }
  }

  static private List<UserEntity> initUser(int listSize) {
    List<UserEntity> resultList = new ArrayList<>();
    for (int i = 0; i < listSize; i++) {
      resultList.add(new UserEntity("UserName:" + i, "UserId" + i));
    }
    return resultList;
  }
}
