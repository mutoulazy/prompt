package prompt.Thread;

/**
 * 实现Runnable接口
 * Created by mutoulazy on 2017/10/10.
 */
public class DoSomething implements Runnable{
    private String name;

    public DoSomething(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("doSometing");
        // for (int i=0;i<5;i++){
        //     for (long k=0;k<100000000;k++){
        //         System.out.println(name + " : " + i);
        //     }
        // }
    }
}
