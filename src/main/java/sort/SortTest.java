package sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        Integer[] source = {1,3,6,5,4,8};

//        Sort sort = new SelectionSort();
//        Sort sort = new BubbleSort();
//        Sort sort = new InsertionSort();

//        Sort sort = new QuickSort();

        Sort sort = new MergeSort();
        sort.sort(source);



        System.out.println(Arrays.toString(source));




    }


}
