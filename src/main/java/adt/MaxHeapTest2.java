package adt;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MaxHeapTest2 {
    public static void main(String[] args) {
        int n = 100000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        }

        double cost1 = testHeap(testData, false);
        System.out.println("without heapify:" + cost1 + " ms");
        double cost2 = testHeap(testData, true);
        System.out.println("with heapify:" + cost2 + " ms");

    }

    private static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime =  System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if(isHeapify){
            maxHeap = new MaxHeap<>(testData);
        }else {
            maxHeap = new MaxHeap<>();
            for (Integer num : testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i <testData.length ; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i<testData.length ;i ++){
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        }
        System.out.println("Completed");
        long cost = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
        return cost;
    }

}
