package prompt.Thread.producer_and_consumer;

/**
 * 仓库
 * Created by mutoulazy on 2017/10/16.
 */
public class Godown {
    public static final int MAX_SIZE = 100;//最大库存量
    public int curnum;  //当前库存量

    Godown(int curnum){
        this.curnum = curnum;
    }

    /**
     * 生产指定数量的产品
     * @param needNum
     */
    public synchronized void produce(int needNum){
        //检测是否需要生产
        while (needNum + curnum > MAX_SIZE) {
            System.out.println("要生产的产品数量" + needNum + "超过剩余库存量" + (MAX_SIZE - curnum) + "，暂时不能执行生产任务!");
            try {
                //使生产的线程等待
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //满足条件则开始生产
        curnum += needNum;
        System.out.println("已经生产了" + needNum + "个产品，现仓储量为" + curnum);
        //唤醒在此对象监视器上等待的所有线程
        notifyAll();
    }

    /**
     * 消费指定数量的产品
     * @param needNum
     */
    public synchronized void consume(int needNum){
        //检测是否可以消费
        while (curnum<needNum){
            try {
                //当前的生产线程等待
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //满足消费条件，则进行消费，这里简单的更改当前库存量
        curnum -= needNum;
        System.out.println("已经消费了" + needNum + "个产品，现仓储量为" + curnum);
        //唤醒在此对象监视器上等待的所有线程
        notifyAll();
    }
}
