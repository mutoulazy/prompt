package prompt.Thread.thread_deadlock;

/**
 * Created by mutoulazy on 2017/10/16.
 */
public class Mythread extends Thread{
    private DeadlockRisk dead;
    private int a, b;

    Mythread(DeadlockRisk dead, int a, int b) {
        this.dead = dead;
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        dead.read();
        dead.write(a, b);
    }
}
