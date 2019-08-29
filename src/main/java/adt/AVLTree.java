package adt;


import java.util.ArrayList;
import java.util.List;

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
    public boolean contains(K e){

        return contains(root, e);
    }


    private boolean contains(Node node, K e){
        if (node == null)
            return false;

        int compareResult = e.compareTo(node.key);
        if (compareResult == 0){
            return true;
        }else if (compareResult < 0){
            return contains(node.left, e);
        }else {
            return contains(node.right, e);
        }
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

        //平衡维护 LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            //右旋转
            return rightRotate(node);

        }

        //RR
        if (balanceFactor < -1 &getBalanceFactor(node.right) <= 0){
            //左旋转
            return leftRotate(node);
        }

        //LR
        if (balanceFactor >1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node);
            return rightRotate(node);

        }

        if (balanceFactor<-1 && getBalanceFactor(node.left) > 0){
            node.right = rightRotate(node);
            return leftRotate(node);

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

    //左旋转
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;


        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;


        return x;


    }


    public void set(K key, V value){


    }

    public V get(K key){
        return null;
    }

    public void add(K key, V value){

        add(root, key, value);
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();

        AVLTree<String, Integer> tree = new AVLTree<>();
        for (String word: words){
            if (tree.contains(word))
                tree.set(word,tree.get(word) + 1);

            else
                tree.add(word, 1);

        }




    }

}
