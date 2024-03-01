package algorithm;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 26. 删除有序数组中的重复项
 * 80. 删除有序数组中的重复项 II
 * @author songjunbao
 * @date 2024-03-01
 */
public class RemoveDuplicates {


    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));



        int[] nums2 = {1,1,1,2,2,3};
        System.out.println(removeDuplicates2(nums2));
    }






    public static int removeDuplicates(int[] nums) {
       if (nums.length == 0)
           return 0;

       int fast = 1, slow = 1;
       while (fast < nums.length){
           if (nums[fast] != nums[fast - 1]){
               nums[slow] = nums[fast];
               ++ slow;
           }

           ++ fast;
       }

       System.out.println(Arrays.toString(nums));
       return slow;
    }


    public static int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return n;

        int fast = 2, slow = 2;
        while (fast < n){

            if (nums[slow -2] != nums[fast]){
                nums[slow] = nums[fast];
                ++ slow;
            }

            ++ fast;
        }

        System.out.println(Arrays.toString(nums));
        return slow;
    }
}
