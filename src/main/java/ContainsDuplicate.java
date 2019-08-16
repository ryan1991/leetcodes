import java.util.HashSet;
import java.util.Set;

/**
 *  判断数组中是否有重复的
 *
 **/
public class ContainsDuplicate {


    public static void main(String[] args) {
        int[] nums = {1,2,3,5,5,6};
        boolean isDup = new ContainsDuplicate().isDuplicate(nums);
        System.out.println(isDup);
    }

    public boolean isDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        return set.size() < nums.length;

    }


}
