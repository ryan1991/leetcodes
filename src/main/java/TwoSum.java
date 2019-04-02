import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 hash表
 * @Author ryan.song
 * @Date 2019/1/28
 **/
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{6,2,3,4}, 5)));
    }

    public static int[] twoSum(int[] in, int target){
        // val - i
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0 ;i < in.length; i++){
            int diff =  target - in[i];
            if (map.containsKey(diff)){
                return new int[]{in[i], in[map.get(diff)]};
            }
            map.put(in[i], i);

        }

        throw new IllegalArgumentException("数组中不存在两数之和为"+target);



    }
}
