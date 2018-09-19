package prompt.Thread.thread_callable;

import java.util.concurrent.Callable;

/**
 * Created by mutoulazy on 2017/10/17.
 */
public class MyCallable implements Callable {
    private String old;

    MyCallable(String old){
        this.old = old;
    }

    @Override
    public Object call() throws Exception {
        return old+"任务返回内容";
    }
}
