package adt.bst;

public class BSTTest {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num : nums){
            bst.add(num);
        }


        //        5
        //      /   \
        //     3     6
        //    / \     \
        //   2   4     8
//        System.out.println(bst.toString());

        bst.preOrder();
        System.out.println("------非递归前序：");
        bst.preOrderNR();
        System.out.println("------层级遍历");
        bst.levelOrder();


//          bst.inOrder();
//        bst.postOrder();
    }

}
