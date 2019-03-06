package practice.design_patterns.proxy;

/**
 * 静态代理模式
 */
public class StaticProxyDemo {
  static class Xiao implements Home{

    @Override
    public void Buy() {
      System.out.println("Xiao buy home");
    }
  }

  static class StaticProxy implements Home {
    private Xiao xiao;

    public StaticProxy(Xiao xiao) {
      this.xiao = xiao;
    }

    @Override
    public void Buy() {
      System.out.println("StaticProxy start");
      xiao.Buy();
      System.out.println("StaticProxy end");
    }
  }

  public static void main(String[] args) {
    Home proxy = new StaticProxy(new Xiao());
    proxy.Buy();
  }
}
