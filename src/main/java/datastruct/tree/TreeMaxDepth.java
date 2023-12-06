package datastruct.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 104. 二叉树的最大深度
 * @author songjunbao
 * @date 2023-12-01
 */
public class TreeMaxDepth {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));


        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }


    /**
     * 广度优先（层序遍历）
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                size --;
            }
            ans++;
        }
        return ans;
    }

    /**
     * 深度优先(递归)
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int maxLeft = maxDepth2(root.left);
        int maxRight = maxDepth2(root.right);

        return Math.max(maxLeft, maxRight) + 1;
    }
}
