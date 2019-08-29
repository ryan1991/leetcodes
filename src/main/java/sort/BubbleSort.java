package sort;

/**
 * 冒泡排序  相邻两个元素比较
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(Comparable[] source) {
        simpleSort(source);

    }


    private void simpleSort(Comparable[] source){

        int len = source.length;
        if (len <= 1)
            return ;

        for (int i = 0; i < len; i++){

            for (int j = 0; j < len - i - 1; j++){
                //升序
                if (less(source[j+1], source[j]))
                    exch(source, j, j+1);

            }

        }
    }


    /**
     * 优化版冒泡排序
     */
    private void optimize(Comparable[] source){

        //TODO







    }

}
