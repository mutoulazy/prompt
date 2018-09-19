package prompt.Thread.thread_synchronized;

/**
 * Created by mutoulazy on 2017/10/16.
 */
public class Mythread extends Thread{
    private User2 u;
    private int y = 0;


    Mythread(String name, User2 u, int y){
        super(name);
        this.u = u;
        this.y = y;
    }

    @Override
    public void run() {
        u.oper(y);
    }

}
