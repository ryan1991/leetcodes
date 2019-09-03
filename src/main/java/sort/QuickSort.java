package sort;

/**
 * 快速排序
 */
public class QuickSort implements Sort {


    @Override
    public void sort(Comparable[] source) {

        int len = source.length;
        if (len <= 1)
            return ;

        quickSort(source, 0, source.length -1);

    }


    private void quickSort(Comparable[] source, int l, int r){
        if (l >= r)
            return;

        int p = partition(source, l ,r);

        quickSort(source, l, p -1);
        quickSort(source, p + 1, r);

    }

    private int partition(Comparable[] source, int l, int r) {
        Comparable v = source[l];

        int j = l;
        for (int i = l + 1; i <=r ; i++){
            if (source[i].compareTo(v)< 0){
                exch(source, j+1, i);
                j++;

            }

        }

        exch(source, l, j);

        return j;





    }
}
