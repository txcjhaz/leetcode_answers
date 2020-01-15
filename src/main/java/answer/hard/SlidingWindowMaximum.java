package answer.hard;

/**
 * @ClassName SlidingWindowMaximum
 * @Deacription 239. 滑动窗口最大值
 * @Author Junhui Chen txcjhwing@gmail.com
 * @Date 2020/1/14 10:45
 * @Version 1.0
 **/
public class SlidingWindowMaximum {
    // 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
    // 返回滑动窗口中的最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 下一个窗口与当前最大值的区别在于，这个最大值可能是滑过的数字，也可能还在当前窗口中（所以仅需比较两次，重点在于确定最大数字的位置）

        // 特殊情况
        if (nums.length == 0)
            return new int[]{};

        // 初始化
        int res_len = nums.length - k + 1;
        int[] res = new int[res_len];
        int last_max = (int) Double.NEGATIVE_INFINITY;
        int last_max_index = -1, L = 0, R = k - 1;

        while (R < nums.length) {
            if (last_max_index < L) { // 如果最大值已经滑过了，得重新选举最大值
                last_max = (int) Double.NEGATIVE_INFINITY;  // reset最大值
                for (int i = L; i <= R; i++) {
                    if (last_max < nums[i]) {
                        last_max = nums[i];
                        last_max_index = i;
                        res[L] = last_max;
                    }
                }
            } else {                   // 否则仅需比较最大值与下一个位置的值的大小即可
                if (last_max < nums[R]) {
                    last_max = nums[R];
                    last_max_index = R;
                    res[L] = last_max;
                } else
                    res[L] = last_max;
            }
            L++;
            R++;
        }

        return res;
    }
}
