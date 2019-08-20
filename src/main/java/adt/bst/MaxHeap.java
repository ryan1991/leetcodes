package adt.bst;

import java.util.ArrayList;

public class MaxHeap<E extends Comparable<E>> {

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private ArrayList<E> data;


    public MaxHeap(){
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MaxHeap(int capacity){
        data = new ArrayList<>(capacity);

    }

    public int size(){
        return data.size();
    }


    public boolean isEmpty(){
        return data.isEmpty();
    }


    private int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("index - 0 dost't have parent");


        return (index -1)/2;

    }

    private int leftChild(int index){
        return index*2 + 1;
    }

    private int rightChild(int index){
        return index*2 + 2;
    }

    public void add(E e){
        //添加到最后
        data.add(e);
        siftUp(data.indexOf(e));

    }

    public E findMax(){
        if (data.size() == 0)
            throw new IllegalArgumentException("heap is null, can't find max ");

        return data.get(0);
    }


    public E extractMax(){
        E ret =findMax();
        swap(0, data.size()-1);
        data.remove(data.size() -1);
        siftDown(0);

        return ret;

    }


    private void siftDown(int k){
        while(leftChild(k) < data.size()){
            int j = leftChild(k);

            // j  是左右子节点中最大值索引
            if (j+1 <data.size() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j = rightChild(k);

            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;

            swap(k, j);
            k = j;
        }


    }



    /**
     * 上浮
     */
    private void siftUp(int k){
        while (k>0 && data.get(parent(k)).compareTo(data.get(k))<0){
            swap(k, parent(k));
            k = parent(k);
        }

    }


    private void swap(int i, int j){
        if (i < 0 || i > data.size() || j<0 ||j>data.size()){
            E t = data.get(i);
            data.set(i, data.get(j));
            data.set(j, t);
        }
    }
}
