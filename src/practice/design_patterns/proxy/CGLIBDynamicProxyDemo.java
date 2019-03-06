package practice.design_patterns.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CGLIB动态代理类
 * AOP底层实现方法
 */
public class CGLIBDynamicProxyDemo {
  static class Xiao implements Home {

    @Override
    public void Buy() {
      System.out.println("Xiao buy home");
    }
  }

  static class CGLIBDynamicProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
        throws Throwable {
      System.out.println("CGLIBDynamicProxy start");
      Object invoker = methodProxy.invokeSuper(o, objects);
      System.out.println("CGLIBDynamicProxy end");
      return invoker;
    }
  }

  public static void main(String[] args) {
    CGLIBDynamicProxy CGLIBDynamicProxy = new CGLIBDynamicProxy();
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(Xiao.class);
    enhancer.setCallback(CGLIBDynamicProxy);
    Home home = (Home) enhancer.create();
    home.Buy();
  }
}
