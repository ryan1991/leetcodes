package adt.bst;

public class AVLTree<K extends Comparable<K>, V> {




    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;

        }

    }

    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }


    public boolean isEmpty(){
        return size ==0;
    }

    public int getSize(){
        return size;
    }

    private int getHeight(Node node){
        if (node == null)
            return 0;

        return node.height;

    }


    /**
     * 平衡因子
     */
    private int getBalanceFactor(Node node){
        if (node ==null)
            return 0;

        return getHeight(node.left) - getHeight(node.right);

    }






}
