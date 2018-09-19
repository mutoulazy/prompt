package prompt.Thread.producer_and_consumer;

/**
 * 消费者
 * Created by mutoulazy on 2017/10/16.
 */
public class Consumer extends Thread {
    private int needNum; //需要消费的数量
    private Godown godown;

    Consumer(int needNum,Godown godown){
        this.needNum = needNum;
        this.godown = godown;
    }

    @Override
    public void run() {
        //消费指定数量的产品
        godown.consume(needNum);
    }
}
