package answer.easy;

/**
 * @Classname: MaximumDepthOfBinaryTree
 * @Description: 104. 二叉树的最大深度
 * @Date: 2020/1/19 23:07
 * @Created by Junhui Chen 384673977@qq.com
 */
public class MaximumDepthOfBinaryTree {
//    class Solution {
//        public int maxDepth(TreeNode root) {
//            if (root == null) {
//                return 0;
//            } else {
//                int left_height = maxDepth(root.left);
//                int right_height = maxDepth(root.right);
//                return java.lang.Math.max(left_height, right_height) + 1;
//            }
//        }
//    }
//
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int maxDepth(TreeNode root) {
        return getMaxDepth(root, 1);
    }

    public int getMaxDepth(TreeNode root, int curDepth) {
        if (root.left == null && root.right == null)
            return curDepth;
        int maxDepth = Integer.MIN_VALUE;
        if (root.left != null)
            maxDepth = getMaxDepth(root.left, curDepth + 1);
        if (root.right != null) {
            int tmp = getMaxDepth(root.right, curDepth + 1);
            if (tmp > maxDepth)
                maxDepth = tmp;
        }
        return maxDepth;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
