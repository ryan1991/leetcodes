package algorithm;

import java.util.PriorityQueue;

/**
 * 数组中的第 K 个最大元素
 */
public class KthLargest {

    public static void main(String[] args) {


        int[] nums = {3,2,1,5,6,4};

        System.out.println(findKthLargest(nums, 2));




    }



    public static int findKthLargest(int[] nums, int k){

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 -n2);
        for (int n: nums){
            heap.add(n);
            if (heap.size() > k){
                heap.poll();
            }


        }

        return heap.poll();





    }


}
