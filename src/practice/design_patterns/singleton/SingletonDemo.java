package practice.design_patterns.singleton;

/**
 * 单例模式
 */
public class SingletonDemo {

  // 懒汉式
  static private class Singleton1 {

    private static Singleton1 singleton1;

    private Singleton1() {

    }

    synchronized public static Singleton1 getSingleton1() {
      if (singleton1 == null) {
        singleton1 = new Singleton1();
      }
      return singleton1;
    }
  }

  // 双重锁检验
  private static class Singleton2 {

    private volatile static Singleton2 singleton2;

    private Singleton2() {

    }

    public static Singleton2 getSingleton2() {
      if (singleton2 == null) {
        synchronized (Singleton2.class) {
          if (singleton2 == null) {
            singleton2 = new Singleton2();
          }
        }
      }
      return singleton2;
    }
  }

  // 饿汉式
  private static class Singleton3 {

    private static Singleton3 singleton3 = new Singleton3();

    private Singleton3() {

    }

    public static Singleton3 getSingleton3() {
      return singleton3;
    }
  }

  public static void main(String[] args) {

  }
}
