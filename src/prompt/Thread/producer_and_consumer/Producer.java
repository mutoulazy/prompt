package prompt.Thread.producer_and_consumer;

/**
 * 生产者
 * Created by mutoulazy on 2017/10/16.
 */
public class Producer extends Thread {
    private int needNum;
    private Godown godown;

    Producer(int needNum, Godown godown){
        this.needNum = needNum;
        this.godown = godown;
    }

    @Override
    public void run() {
        //生产指定数量的产品
        godown.produce(needNum);
    }
}
