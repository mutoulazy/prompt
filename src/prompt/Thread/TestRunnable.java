package prompt.Thread;

/**
 * 实现多线程的方法一：
 * 测试Runnable类实现的多线程程序
 * Created by mutoulazy on 2017/10/10.
 */
public class TestRunnable {
    public static void main(String[] args) {
        DoSomething ds1 = new DoSomething("阿三");
        DoSomething ds2 = new DoSomething("小四");

        Thread t1 = new Thread(ds1);
        Thread t2 = new Thread(ds2);

        t1.start();
        t2.start();
    }
}
