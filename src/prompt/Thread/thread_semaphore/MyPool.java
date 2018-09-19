package prompt.Thread.thread_semaphore;

import java.util.concurrent.Semaphore;

/**
 * 一个线程池
 * Created by mutoulazy on 2017/10/18.
 */
public class MyPool {
    private Semaphore sp;

    /**
     * 池的大小，这个大小会传递给信号量
     * @param size
     */
    MyPool(int size){
        this.sp = new Semaphore(size);
    }

    public Semaphore getSp() {
        return sp;
    }

    public void setSp(Semaphore sp) {
        this.sp = sp;
    }
}
