package answer.medium;

import java.util.*;

/**
 * 236.二叉树的最近公共祖先
 */
public class NearestCmmonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 判断当前节点是否为祖先，再判断子节点是否为祖先，当子节点均不是时为最近祖先
        boolean selfIsAncestor = hasNode(root, p) && hasNode(root, q);
        boolean leftChildIsAncestor = false;
        if(root.left != null)
            leftChildIsAncestor = hasNode(root.left, p) && hasNode(root.left, q);
        boolean rightChildIsAncestor = false;
        if(root.right != null)
            rightChildIsAncestor = hasNode(root.right, p) && hasNode(root.right, q);

        if(selfIsAncestor){
            if(leftChildIsAncestor)
                return lowestCommonAncestor(root.left, p, q);
            if(rightChildIsAncestor)
                return lowestCommonAncestor(root.right, p, q);
            return root;
        }

        return null;
    }

    public static boolean hasNode(TreeNode tree, TreeNode node){
        if(tree.val == node.val)
            return true;
        else{
            boolean result = false;
            if(tree.left != null)
                result = hasNode(tree.left, node);
            if(result)
                return result;
            if(tree.right != null)
                result = hasNode(tree.right, node);
            return result;
        }
    }

    /**
     * 将节点序列转化成树
     * @param treeSeq 形如[3,5,1,6,2,0,8,null,null,7,4]的节点序列
     * @return 根节点
     */
    public static TreeNode parseTree(String treeSeq){
        // 先转化为字符串数组
        String[] numStrs = treeSeq.substring(1, treeSeq.length()-1).split(",");

        // 生成根节点
        TreeNode root;
        if(numStrs.length > 0)
            root = new TreeNode(Integer.parseInt(numStrs[0]));
        else
            return null;

        // 再生成其余节点
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode top = root;
        for (int i = 1; i < numStrs.length; i+=2){
            if(!numStrs[i].equals("null")) {
                top.left = new TreeNode(Integer.parseInt(numStrs[i]));
                queue.add(top.left);
            }

            if(i+1 < numStrs.length && !numStrs[i+1].equals("null")) {
                top.right = new TreeNode(Integer.parseInt(numStrs[i+1]));
                queue.add(top.right);
            }

            top = queue.element();
            queue.remove();
        }

        return root;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}