package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 169. 多数元素
 *
 * @author songjunbao
 * @date 2023-11-24
 */
public class MajorElement {

    public static void main(String[] args) {

        int[] nums = {3, 2, 3,3,4};

        System.out.println(majorityElementBetter(nums));

    }

    public static int majorityElement(int[] nums) {
        //计数
        Map<Integer, Integer> countMap  = IntStream.of(nums).boxed().collect(Collectors.toMap(Integer::valueOf, a -> 1, (a, b) -> a + 1));
        System.out.println(countMap);
        Map.Entry<Integer, Integer> max = null;
        for (Map.Entry<Integer, Integer> e : countMap.entrySet()){
            if (max == null || e.getValue() > max.getValue()) {
                max = e;
            }
        }

        return max.getKey();
    }


    public static int majorityElementBetter(int[] nums) {
        //计数
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = nums[0];
        int maxCount = 1;

        for (int num : nums){
            if (!countMap.containsKey(num)){
                countMap.put(num, 1);
            }else {
                Integer old = countMap.get(num);
                countMap.put(num, old + 1);
            }
            Integer cur = countMap.get(num);

            if (maxCount < cur){
                max = num;
                maxCount = cur;
            }
        }
        return max;
    }


}
