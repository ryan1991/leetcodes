package sort;

/**
 * 归并排序
 *
 * 稳定  O(nlogn)  空间复杂度更大
 */
public class MergeSort implements Sort{



    @Override
    public void sort(Comparable[] source) {

        //递归使用归并排序， 对arr[l...r]的范围进行排序

        mergeSort(source, 0 ,source.length - 1);




    }

    private void mergeSort(Comparable[] arr, int l, int r){

        if (l >= r)
            return;

        int mid = (l + r) /2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r);


    }

    /**
     * 整合
     * 将arr[l ... mid] 和 arr[mid + 1 ...r]两个部分进行整合
     */
    private void merge(Comparable[] arr, int l, int mid, int r) {
        //临时空间
        Comparable[] aux = new Comparable[r -l + 1];
        for (int i = l; i<=r; i++){
            aux[i -l ] = arr[i];
        }

        int i = l, j = mid + 1;


        /**
         * j - l 是偏移量
         */
        for (int k = l; k <= r; k ++ ){
            if (i > mid){
                arr[k] = aux[j - l];
                j++;
            }else if (j > r){
                arr[k] = aux[i - l];
                i ++;
            } else if (aux[i-l].compareTo(aux[j-l]) < 0){
                arr[k] =  aux[i-l];
                i++;

            }else {
                arr[k] = aux[j-l];
                j++;

            }


        }







    }


}
