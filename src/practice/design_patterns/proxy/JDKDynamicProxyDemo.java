package practice.design_patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理类(不需要生成代理类)
 * AOP底层实现方法
 */
public class JDKDynamicProxyDemo {
  static class Xiao implements Home {

    @Override
    public void Buy() {
      System.out.println("Xiao buy home");
    }
  }

  static class JDKDynamicProxy implements InvocationHandler {

    private Object target;

    public JDKDynamicProxy(Object target) {
      this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      System.out.println("JDKDynamicProxy start");
      Object invoke = method.invoke(target, args);
      System.out.println("JDKDynamicProxy end");
      return invoke;
    }
  }

  public static void main(String[] args) {
    Xiao xiao = new Xiao();
    JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(xiao);
    Home home = (Home) Proxy.newProxyInstance(xiao.getClass().getClassLoader(), xiao.getClass().getInterfaces(),
            jdkDynamicProxy);
    home.Buy();
  }
}
