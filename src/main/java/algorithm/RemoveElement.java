package algorithm;

import java.util.Arrays;

/**
 * 27.移除元素
 *
 * 双指针法
 * @author songjunbao
 * @date 2023-10-15
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int[] nums2 = {0,1,2,2,3,0,4,2};

        System.out.println(removeElement(nums, 3));
        System.out.println(removeElement(nums2, 2));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int l = 0, r = nums.length - 1;
        while (l < r){
            while (l < r && nums[l] != val){
                l ++;
            }

            while (l < r && nums[r] == val){
                r --;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        System.out.println("swap nums:" + Arrays.toString(nums));
        return nums[l] == val ? l : l + 1;
    }


}
