package sort;

/**
 * 排序接口， 涉及需要模板方法
 */
public interface Sort {

    /**
     *  排序操作
     */
    void sort(Comparable[] source);

    /**
     * a是否小于b
     */
    default boolean less(Comparable a,  Comparable b){
        return  a.compareTo(b) < 0;
    }

    /**
     * 交换元素的位置
     *
     */
    default void  exch(Comparable[] source, int i, int j){
        Comparable t = source[i];
        source[i] = source[j];
        source[j] = t;
    }

    /**
     * 递增顺序
     */
    default boolean  isSorted(Comparable[] source){
        for (int i = 1; i < source.length; i++)
            if (less(source[i],source[i - 1]))
                return false;
        return true;

    }

}
