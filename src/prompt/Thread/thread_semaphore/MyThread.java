package prompt.Thread.thread_semaphore;

/**
 * Created by mutoulazy on 2017/10/18.
 */
public class MyThread extends Thread{
    private String name;
    private MyPool pool;
    private int x;

    public MyThread(String name, MyPool pool, int x) {
        this.name = name;
        this.pool = pool;
        this.x = x;
    }

    @Override
    public void run() {
        try {
            //从此信号量获取给定数目的许可
            pool.getSp().acquire(x);
            //也许这里可以做更复杂的业务
            System.out.println(name + "成功获取了" + x + "个许可！");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            //释放给定数目的许可，将其返回到信号量。
            pool.getSp().release(x);
            System.out.println(name + "释放了" + x + "个许可！");
        }
    }
}
