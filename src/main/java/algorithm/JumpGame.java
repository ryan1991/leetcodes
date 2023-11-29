package algorithm;

/**
 * 55. 跳跃游戏
 *
 * @author songjunbao
 * @date 2023-11-28
 */
public class JumpGame {


    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(canJump(nums));
        System.out.println(canJump(nums2));
    }



    public static boolean canJump(int[] nums) {
        int lastIndex = nums.length - 1;
        //可到达最远位置
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= pos){
                pos = Math.max(pos, i + nums[i]);
                if (pos >= lastIndex){
                    return true;
                }
            }
        }
        return false;
    }
}
