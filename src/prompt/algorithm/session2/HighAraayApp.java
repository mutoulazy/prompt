package prompt.algorithm.session2;

/**
 * Created by mutoulazy on 2017/8/24.
 */
public class HighAraayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);

        arr.insert(77);
        arr.insert(66);
        arr.insert(88);
        arr.insert(22);
        arr.insert(11);
        arr.insert(00);
        arr.insert(99);
        arr.insert(33);
        arr.insert(44);
        arr.insert(55);

        arr.display();

        long searchKey = 11;
        if (arr.getSize() == arr.binFind(searchKey))
            System.out.println("Can't find  " + searchKey);
        else
            System.out.println("find " + searchKey);

        arr.delete(00);
        arr.delete(55);
//        arr.bubbleSort();
//        arr.selectionSort();
        arr.insertionSort();
        arr.display();

    }
}
