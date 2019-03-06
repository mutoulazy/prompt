package practice.design_patterns.factory_method;

/**
 * 简单工厂模式
 */
public class SimpleFactoryMethodDemo {
  interface Car{
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

  static class CarFactory {
    public static Car createCar(String name) {
      Car car = null;
      switch (name) {
        case "AoDi":
          car = new AoDi();
          break;
        case "BenChi":
          car = new BenChi();
          break;
        default:
          break;
      }
      return car;
    }
  }

  public static void main(String[] args) {

  }
}
