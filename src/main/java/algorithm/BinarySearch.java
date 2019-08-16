package algorithm;

import java.util.Arrays;

/**
 *  二分查找
 *  1.先排序
 *  2.获取mid
 *
 **/
public class BinarySearch {


    public static void main(String[] args) {
        int[] a = {8, 11, 15, 6, 9, 99};
        Arrays.sort(a);
        System.out.println(new BinarySearch().search(6, a));


    }


    public int search(int k, int[] a){
        System.out.println(Arrays.toString(a));

        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) /2;
            if (a[mid] > k) hi = mid - 1;
            else if (a[mid] < k) lo = mid + 1;
            else return mid;

        }

        return  - 1;

    }
}
