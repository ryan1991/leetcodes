package adt.bst;

import java.util.ArrayList;

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

    /**
     * 判断该二叉树是否是一棵二分搜索树
     *
     * 中序遍历是递增
     *
     */
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();

        inOrder(root, keys);
        for (int i =1; i< keys.size(); i++)
            if (keys.get(i-1).compareTo(keys.get(i)) > 0)
                return false;

        return true;

    }

    private void inOrder(Node node, ArrayList<K> keys){
        if (node == null)
            return;

        inOrder(node.left, keys);

        keys.add(node.key);
        inOrder(node.right, keys);


    }


    public boolean isBalanced(){
        return isBalanced(root);
    }



    private boolean isBalanced(Node node){
        if (node ==null)
            return true;
        int factor = getBalanceFactor(node);

        if (Math.abs(factor)> 1)
            return false;

        return isBalanced(node.left) && isBalanced(node.right);

    }


    public Node add(Node node, K key, V value){
        if(node ==null){
            size ++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key ,value);
        else
            node.value = value;

        //更新height
        node.height = 1+ Math.max(getHeight(node.left), getHeight(node.right));

        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1)
            System.out.println("unbalanced : " + balanceFactor);

        //平衡维护
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            //右旋转


        }

        return node;
    }


    /**
     * 在y节点不满足平衡
     * @param y
     * @return
     */
    private Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;

        x.right = y;
        y.left = T3;

        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;

    }


}
