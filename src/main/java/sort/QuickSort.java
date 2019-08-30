package sort;

/**
 * 快速排序
 */
public class QuickSort implements Sort {


    @Override
    public void sort(Comparable[] source) {





    }


    private void quickSort(Comparable[] source, int l, int r){
        if (l >= r)
            return;

        int p = partition(source, l ,r);

        quickSort(source, l, p -1);
        quickSort(source, p + 1, r);

    }

    private int partition(Comparable[] source, int l, int r) {

        return 0;
    }
}
