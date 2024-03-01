package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author songjunbao
 * @date 2024-03-01
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));


    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int n2 = target - n;
            if (indexMap.containsKey(n2)){
                return new int[]{i, indexMap.get(n2)};
            }
            indexMap.put(nums[i], i);
        }
        return null;
    }



}
