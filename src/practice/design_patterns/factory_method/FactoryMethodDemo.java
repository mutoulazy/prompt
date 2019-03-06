package practice.design_patterns.factory_method;

/**
 * 工厂模式
 */
public class FactoryMethodDemo {

  interface Car {

    void run();
  }

  static class AoDi implements Car {

    @Override
    public void run() {
      System.out.println("AoDi");
    }
  }

  static class BenChi implements Car {

    @Override
    public void run() {
      System.out.println("BenChi");
    }
  }

  static class AoDiFactory {
    public static Car createCar() {
      return new AoDi();
    }
  }

  static class BenChiFactory {
    public static Car createCar() {
      return new BenChi();
    }
  }

  public static void main(String[] args) {

  }
}
