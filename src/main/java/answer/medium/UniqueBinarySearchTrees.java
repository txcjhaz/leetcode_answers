package answer.medium;

/**
 * @ClassName UniqueBinarySearchTrees
 * @Deacription 96. 不同的二叉搜索树
 * @Author Junhui Chen txcjhwing@gmail.com
 * @Date 2020/1/15 16:07
 * @Version 1.0
 **/
public class UniqueBinarySearchTrees {
//    public int numTrees(int n) {
//        // 每新增一个节点，则肯定多出一个以它开头的二叉搜索树，以及插入原有二叉搜素树的搜索树
//        int[] res = new int[n];
//        res[0] = 1;
////        if (n > 2)
////            res[1] = 2;
//        for (int i = 1; i < n; i++) {
//            // 做根节点时，产生的二叉搜素树就是原来的个数
//            res[i] = res[i-1];
//            // 前面结果的二叉搜索树个数+多产生出的（插入后可能发生旋转）
//            // 可以插入右子树的右子节点或右非叶节点或直接插入根节点右侧
//            // 当前根节点为k，则比k大的数有i-k-1个，可插入的位置有 2 * (i-k-1)
//            for(int k = 0; k < i; k++){
//                res[i] += 2 * (k - 1);
//            }
//        }
//        return res[n - 1];
//    }
public int numTrees(int n) {
    int[] G = new int[n + 1];
    G[0] = 1;
    G[1] = 1;

    for (int i = 2; i <= n; ++i) {
        for (int j = 1; j <= i; ++j) {
            G[i] += G[j - 1] * G[i - j];
        }
    }
    return G[n];
}

}
