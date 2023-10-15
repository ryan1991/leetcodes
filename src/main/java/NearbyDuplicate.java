import java.util.HashSet;

/**
 *
 * 219. 存在重复元素 II
 * @author songjunbao
 * @date 2023-10-13
 */
public class NearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = {4,1,2,3,1,5};
        int k = 3;

        System.out.println(containsNearbyDuplicate(nums, k));
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (set.contains(cur)){
                return true;
            }
            set.add(cur);
            if (set.size() > k){
                //删除set头部值
                int head = nums[i - k];
                set.remove(head);
            }
        }
        return false;
    }

}
