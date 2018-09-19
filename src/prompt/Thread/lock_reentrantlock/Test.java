package prompt.Thread.lock_reentrantlock;


import java.math.BigInteger;

/**
 * Created by mutoulazy on 2017/10/20.
 */
public class Test {
    public static void main(String[] args) {
        /*PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for (int i=0;i<5;i++){
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        for (int i=0;i<5;i++){
            thread[i].start();
        }*/
        //9223372036854775807
        //110000000010100000111000000000
        try {
            BigInteger a = new BigInteger("110000000010100000111000000000",10);
            String strValue = a.toString(2);
            System.out.println(strValue);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
