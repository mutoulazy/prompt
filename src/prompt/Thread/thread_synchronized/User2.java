package prompt.Thread.thread_synchronized;

/**
 * 采用同步代码块
 * Created by mutoulazy on 2017/10/16.
 */
public class User2 {
    private String code;
    private int cash;

    /**
     * 使用synchronized修饰对cash操作的代码，使其同步
     * 如果不适用同步的方法，会造成数据错误的结果。
     * @param x
     */
    public void oper(int x){
        try {
            Thread.sleep(10L);
            synchronized (this){
                this.cash += x;
                System.out.println(Thread.currentThread().getName() + "运行结束，增加“" + x + "”，当前用户余额为：" + this.cash);
            }
            Thread.sleep(10L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public User2(String code, int cash) {
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
        return "User2{" +
                "code='" + code + '\'' +
                ", cash=" + cash +
                '}';
    }
}
