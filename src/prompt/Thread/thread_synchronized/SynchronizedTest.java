package prompt.Thread.thread_synchronized;

/**
 * 线程同步的测试类
 * Created by mutoulazy on 2017/10/16.
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        User2 u = new User2("张三", 100);

        Mythread t1 = new Mythread("线程1", u, 20);
        Mythread t2 = new Mythread("线程2", u, -60);
        Mythread t3 = new Mythread("线程3", u, -80);
        Mythread t4 = new Mythread("线程4", u, -30);
        Mythread t5 = new Mythread("线程5", u, 30);
        Mythread t6 = new Mythread("线程6", u, 20);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
