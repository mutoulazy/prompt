package prompt.algorithm.session2;

/**
 * Created by mutoulazy on 2017/8/24.
 */
public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(){}

    public HighArray(int max){
        a= new long[max];
        nElems = 0;
    }

    public int getSize(){
        return nElems;
    }

    public boolean find(long searchKey){
        int j;
        for (j=0;j<nElems;j++){
            if (a[j] == searchKey)
                break;
        }
        if (nElems == j)
            return false;
        else
            return true;
    }

    /**
     * 二分法查找（有序数组）
     * @param searchKey
     * @return
     */
    public int binFind(long searchKey){
        int lowrBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true){
            curIn = (lowrBound + upperBound)/2;
            if (searchKey == a[curIn]){
                return curIn;
            }else if (lowrBound > upperBound){
                return nElems;
            }else {
                if (a[curIn] > searchKey){
                    upperBound = curIn - 1;
                }else
                    lowrBound = curIn + 1;
            }
        }
    }

    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value){
        int j;
        for(j=0; j<nElems; j++)
            if(value == a[j])
                break;
        if (nElems == j)
            return false;
        else{
            for (int k=j;k<nElems;k++)
                a[k] = a[k+1];
            nElems--;
            return true;
        }
    }

    public void display(){
        for (int j=0; j<nElems;j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    public void bubbleSort(){
        int out,in;
        for (out=nElems-1;out>1;out--){
            for (in=0;in<out;in++){
                if (a[in] > a[in+1]){
                    swap(in,in+1);
                }
            }
        }
    }

    public void selectionSort(){
        int out,in,min;
        for (out=0; out<nElems-1;out++){
            min = out;
            for (in=out+1;in<nElems;in++){
                if (a[in] < a[min]){
                    min = in;
                }
            }
            swap(out,min);
        }
    }

    public void insertionSort(){
        int in,out;
        for (out=1;out<nElems;out++){
            long temp = a[out];
            in = out;
            while (in>0 && a[in-1] >= temp){
                a[in] = a[in-1];
                --in;
            }
            a[in] = temp;
        }
    }

    private void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

}
