package prompt.Thread.thread_synchronized;

/**
 * 采用同步方法，使用synchronized修饰需要进行同步的方法
 * Created by mutoulazy on 2017/10/16.
 */
public class User {
    private String code;
    private int cash;

    /**
     * 使用synchronized修饰对cash操作的方法，使其同步
     * 如果不适用同步的方法，会造成数据错误的结果。
     * @param x
     */
    public synchronized void oper(int x){
        try {
            Thread.sleep(10L);
            this.cash += x;
            System.out.println(Thread.currentThread().getName() + "运行结束，增加“" + x + "”，当前用户余额为：" + this.cash);
            Thread.sleep(10L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public User(String code, int cash) {
        this.code = code;
        this.cash = cash;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "User{" +
                "code='" + code + '\'' +
                ", cash=" + cash +
                '}';
    }
}
