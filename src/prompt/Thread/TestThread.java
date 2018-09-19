package prompt.Thread;

/**
 * 实现多线程的方法二：
 * 测试扩展Thread类实现的多线程程序
 * Created by mutoulazy on 2017/10/10.
 */
public class TestThread extends Thread{
    public static void main(String[] args) {
        Thread t1 = new TestThread("a3");
        Thread t2 = new TestThread("x4");

        t1.start();
        t2.start();
    }

    public TestThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
//            for (long k=0;k<100000000;k++){
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(this.getName() + " : " + i);
//            }
        }
    }
}
