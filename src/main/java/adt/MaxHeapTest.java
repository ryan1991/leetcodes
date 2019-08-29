package adt;

import java.util.Random;

public class MaxHeapTest {
    public static void main(String[] args) {
        int n = 100000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        System.out.println("maxHead size:"+ maxHeap.size());
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i<n ;i ++){
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");


        }

        System.out.println("Completed");
    }

}
