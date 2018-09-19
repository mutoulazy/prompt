package prompt.Thread.thread_deadlock;

/**
 * 尝试死锁
 * Created by mutoulazy on 2017/10/16.
 */
public class Test {
    public static void main(String[] args) {
        DeadlockRisk dead = new DeadlockRisk();
        Mythread t1 = new Mythread(dead, 1, 2);
        Mythread t2 = new Mythread(dead, 3, 4);
        Mythread t3 = new Mythread(dead, 5, 6);
        Mythread t4 = new Mythread(dead, 7, 8);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
