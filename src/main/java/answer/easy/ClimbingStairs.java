package answer.easy;

/**
 * @ClassName ClimbingStairs
 * @Deacription 爬楼梯
 * @Author Junhui Chen txcjhwing@gmail.com
 * @Date 2020/1/15 15:09
 * @Version 1.0
 **/
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}