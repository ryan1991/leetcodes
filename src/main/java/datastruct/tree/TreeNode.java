package datastruct.tree;

/**
 * @author songjunbao
 * @date 2023-12-01
 */
public class TreeNode {
    int value;
    TreeNode left, right;
    TreeNode(){}
    TreeNode(int value){
        this.value = value;
    }

    TreeNode(int value, TreeNode left, TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
