package algorithm;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        System.out.println(topKFrequent(nums, 2));

    }



    public static List<Integer> topKFrequent(int[] nums, int k) {

    // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });


        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();

        res.addAll(pq);
//        while (!pq.isEmpty()) {
//            res.add(pq.remove());
//        }
        return res;
    }

}
