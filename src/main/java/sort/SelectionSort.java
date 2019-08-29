package sort;

/**
 * 选择排序 每次找到元素中最小的值的位置 并交换元素
 *
 *  不稳定
 *
 */
public class SelectionSort implements Sort {

    @Override
    public void sort(Comparable[] source) {
        int length = source.length;
        for (int i = 0; i<length; i++){
            // 最小元素索引
            int min = i;
            for (int j = i + 1;j < length; j++){
                if (less(source[j], source[min]))
                    min = j;


            }
            exch(source, i, min);
        }

    }
}
