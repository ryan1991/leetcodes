package algorithm;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * @author songjunbao
 * @date 2023-11-24
 */
public class MergeTwoSortedNums {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }



    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while(p1 < m || p2 < n){
            if (p1 == m){
                cur = nums2[p2 ++];
            }else if (p2 == n){
                cur = nums1[p1 ++];
            }else if (nums1[p1] < nums2[p2]){
                cur = nums1[p1 ++];
            }else {
                cur = nums2[p2 ++];
            }
            sorted[p1 + p2 -1] = cur;
        }

//        for (int i = 0; i < m + n; i++){
//            nums1[i] = sorted[i];
//        }

        System.arraycopy(sorted,0,nums1,0,sorted.length);
    }




}
