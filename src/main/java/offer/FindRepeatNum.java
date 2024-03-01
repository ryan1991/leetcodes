package offer;

/**
 * 剑指offer找出重复数
 *
 * @author songjunbao
 * @date 2024-01-15
 */
public class FindRepeatNum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};

        System.out.println(findRepeatNumber(nums));

    }

    public static int findRepeatNumber(int[] nums){

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (i != nums[i]){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }

                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }


        }

        return -1;
    }



}
