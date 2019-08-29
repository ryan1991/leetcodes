package sort;


/**
 * 插入排序
 */
public class InsertionSort implements Sort{

    @Override
    public void sort(Comparable[] source) {

        int len = source.length;
        if (len <= 1)
            return ;

        for (int i = 0; i< len; i++){
            for (int j=i; j >0; j--){
                if (less(source[j], source[j-1]))
                    exch(source, j, j-1);

            }

        }



    }
}
