package prompt.Thread.thread_lock;

import java.util.concurrent.locks.Lock;

/**
 * 模拟操作信用卡的用户
 * 在业务中添加锁
 * Created by mutoulazy on 2017/10/17.
 */
public class User implements Runnable{
    private String name;
    private MyCount myCount;
    private int iocash;
    private Lock myLock;

    public User(String name, MyCount myCount, int iocash, Lock myLock) {
        this.name = name;
        this.myCount = myCount;
        this.iocash = iocash;
        this.myLock = myLock;
    }

    public void run() {
        //获取锁
        myLock.lock();
        //执行业务
        System.out.println(name + "正在操作" + myCount + "账户，金额为" + iocash + "，当前金额为" + myCount.getCash());
        myCount.setCash(myCount.getCash() + iocash);
        System.out.println(name + "操作" + myCount + "账户成功，金额为" + iocash + "，当前金额为" + myCount.getCash());
        //释放锁，否则别的线程没有机会执行了
        myLock.unlock();
    }
}
