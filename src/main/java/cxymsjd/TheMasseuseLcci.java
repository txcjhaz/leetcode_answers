package cxymsjd;

/**
 * 面试题 17.16. 按摩师
 */
public class TheMasseuseLcci {
    public static int massage(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] res = new int[nums.length + 1];
        res[0] = 0;
        res[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i - 1]);
        }

        return res[nums.length];
    }
}
