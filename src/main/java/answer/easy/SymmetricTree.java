package answer.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName SymmetricTree
 * @Deacription 101. 对称二叉树
 * @Author Junhui Chen txcjhwing@gmail.com
 * @Date 2020/1/19 9:55
 * @Version 1.0
 **/
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode a, TreeNode b){
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        return (a.val == b.val) && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
//    public boolean isSymmetric(TreeNode root) {
//        // 广度遍历，遍历每一层，将值生成数组，然后回文比较
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        boolean continuee = true;
//        while (queue.size() > 0 && continuee) {
//            continuee = false;
//            List<Integer> layer = new ArrayList<>();
//            for (int i = queue.size(); i > 0; i--) {
//                TreeNode tmp = queue.poll();
//                if(tmp.left != null && !(tmp.val == Integer.MAX_VALUE)) {
//                    queue.add(tmp.left);
//                    continuee = true;
//                }
//                else
//                    queue.add(new TreeNode(Integer.MAX_VALUE));
//                if(tmp.right != null && !(tmp.val == Integer.MAX_VALUE)) {
//                    queue.add(tmp.right);
//                    continuee = true;
//                }
//                else
//                    queue.add(new TreeNode(Integer.MAX_VALUE));
//
//                if(tmp.val == Integer.MAX_VALUE)
//                    layer.add(0);
//                else
//                    layer.add(tmp.val);
//                if(root == tmp)
//                    continue;
//            }
//            if (!listIsSymmetric(layer))
//                return false;
//        }
//
//        return true;
//    }
//
//    /* *
//     * @Author Junhui Chen txcjhwing@gmail.com
//     * @Description 判断数组是否对称
//     * @Date 10:05 2020/1/19
//     * @Param [list]
//     * @return boolean
//     **/
//    public boolean listIsSymmetric(List<Integer> list) {
//        if(list.size() == 1)    // 除了根节点别的应该均大于1
//            return false;
//        int i = 0, j = list.size()-1;
//        while(i <= j){
//            if(list.get(i) != list.get(j))
//                return false;
//            i++;
//            j--;
//        }
//        return true;
//    }
//
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
