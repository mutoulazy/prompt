package practice.thread.std06;

public class Res {
  // 生成序列号共享变量
  public static Integer count = 0;
  public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
    @Override
    protected Integer initialValue() {
      return 0;
    }
  };

  public Integer getNum() {
    int count =  threadLocal.get() + 1;
    threadLocal.set(count);
    return count;
  }
}
