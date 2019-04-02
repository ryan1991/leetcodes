import java.util.*;

/**
 * @Author ryan.song
 * @Date 2019/4/2
 **/
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> rst = new ThreeSum().threeSum(nums);
        System.out.println(rst);
    }


    public  List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> rst = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (i > 0){
                if (n == nums[i-1]){
                    continue;
                }

            }


            int target = 0 - n;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i+1; j < nums.length ; j++) {
                int diff = target - nums[j];
                if (map.containsKey(diff)){
                    List<Integer> item = new ArrayList<>();
                    item.add(n);
                    item.add(diff);
                    item.add(nums[j]);
                    rst.add(item);
                } else {
                    map.put(nums[j], j);
                }


            }

        }


        return new ArrayList<>(rst);
    }

}
