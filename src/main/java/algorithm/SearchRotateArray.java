package algorithm;

import java.util.Arrays;

/**
 *
 * 从旋转后的
 * @author songjunbao
 * @date 2023-10-12
 */
public class SearchRotateArray {

    public static void main(String[] args) {
        int[] nums = {5,1,3};
        int target = 5;
        System.out.println("target index :" + search(nums, target));
    }


    public static int search(int[] nums, int target) {
        if (nums.length <= 2){
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target)
                    return i;

            }
            return -1;
        }

        int l = 0, r = nums.length -1;
        while (l < r){
            int mid = l + (r -l) / 2;
            if (nums[mid] < nums[mid - 1]){
                r = mid-1;
            }else {
                l = mid;
            }
        }
        int k = l;
        System.out.println(k);
        int idx1 = search(target, nums, 0, k);
        int idx2 = search(target, nums, k+1, nums.length - 1);
        if (idx1 != -1)
            return idx1;
        if (idx2 != -1)
            return idx2;

        return  -1;
    }

    public static int search(int k, int[] a, int lo, int hi){
        while (lo <= hi){
            int mid = lo + (hi - lo) /2;
            if (a[mid] > k) hi = mid - 1;
            else if (a[mid] < k) lo = mid + 1;
            else return mid;

        }
        return  - 1;
    }


}
