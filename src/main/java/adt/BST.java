package adt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树 会退化成一个链表，递归可能会导致栈溢出
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

    private Node root;
    private int size;
    public BST(){
        root = null;
        size = 0;
    }


    //节点
    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){

            this.e = e;
            left = null;
            right = null;
        }

    }


    public void add(E e){
//        if (root ==null){
//            root =new Node(e);
//            size ++;
//        }else {
//            add(root, e);
//        }
        root = add(root, e);

    }


    /**
     * 向以node为根节点的二分搜索树插入元素E,递归算法
     *
     * 注释部分不够好，递归终止条件臃肿
     * @param node
     * @param e
     */
//    private void add(Node node, E e){
//        if (e.equals(node.e)){
//            return;
//        } else if (e.compareTo(node.e)< 0 && node.left ==null){
//            node.left = new Node(e);
//            size ++;
//            return;
//        } else if (e.compareTo(node.e)>0 && node.right ==null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//        if (e.compareTo(node.e)< 0){
//            add(node.left, e);
//        }
//
//        if (e.compareTo(node.e)> 0){
//            add(node.right, e);
//        }
//
//    }


    /**
     * 向以node为根节点的二分搜索树插入元素E,递归算法
     * @param node
     * @param e
     */
    private Node add(Node node, E e){
       if (node ==null){
           size ++;
           return new Node(e);
       }

       if (e.compareTo(node.e) < 0){
           node.left = add(node.left, e);
       }else if (e.compareTo(node.e)>0){
           node.right = add(node.right, e);
       }else {
           //duplicate : do nothing
       }

        return node;
    }


    public boolean contains(E e){

       return contains(root, e);
    }


    private boolean contains(Node node, E e){
        if (node == null)
            return false;

        int compareResult = e.compareTo(node.e);
        if (compareResult == 0){
            return true;
        }else if (compareResult < 0){
            return contains(node.left, e);
        }else {
            return contains(node.right, e);
        }
    }


    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    //前序遍历以node 为根的二分搜索树，递归算法
    private void preOrder(Node node){
        if (node==null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }

    //非递归前序遍历
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            /**
             * 注意：先处理右子树
             */
            if (cur.right !=null)
                stack.push(cur.right);
            if (cur.left !=null)
                stack.push(cur.left);

        }

    }


    /**
     * 层序遍历 队列
     * 广度优先（ 最优解）
     */
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left!=null)
                q.add(cur.left);

            if (cur.right!=null)
                q.add(cur.right);
        }


    }





    public void inOrder(){
        inOrder(root);
    }


    //中序遍历（从小到大排序）
    private void inOrder(Node node){
        if (node==null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }


    //后序遍历  先处理节点的sub节点， 再处理当前节点（内存释放）
    public void postOrder(){
        postOrder(root);
    }


    //后序遍历
    private void postOrder(Node node){
        if (node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

    /**
     * 返回以node为根的二分搜索树最小值
     * @return
     */
    public E minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");

        return minimum(root).e;
    }


    /**
     * 返回以node为根的二分搜索树最大值
     * @return
     */
    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }


    public E maximum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }

    private Node maximum(Node root) {
        if (root.right == null)
            return root;

        return maximum(root.right);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);

        return res.toString();

    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null){

            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i =0 ; i< depth; i++){
            res.append("--");
        }
        return res.toString();


    }
}
