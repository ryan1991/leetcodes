package datastruct.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *  找到根节点 根节点左边为左子树 右边为右子树
 *
 * @author songjunbao
 * @date 2023-12-01
 */
public class TreeBuilder {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null
                || preorder.length ==0
                || inorder == null
                || inorder.length ==0
                || preorder.length != inorder.length) {
            throw new IllegalArgumentException("参数异常");
        }
        int n = inorder.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, indexMap, 0, n -1, 0, n-1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, Map<Integer, Integer> indexMap, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight){
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preRootIndex = preLeft;
        // 在中序遍历中定位根节点
        Integer inRootIndex = indexMap.get(preorder[preRootIndex]);
        TreeNode root = new TreeNode(preorder[preRootIndex]);

        int leftSubTreeSize = inRootIndex - inLeft;
        root.left = myBuildTree(preorder, inorder, indexMap, preLeft+1, preLeft + leftSubTreeSize, inLeft,  inRootIndex -1);
        root.right = myBuildTree(preorder, inorder, indexMap, preLeft + leftSubTreeSize + 1, preRight, inRootIndex + 1, inRight);
        return root;
    }
}
