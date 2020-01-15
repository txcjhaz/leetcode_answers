package answer.medium;

/**
 * @ClassName UniquePaths
 * @Deacription 62. 不同路径
 * @Author Junhui Chen txcjhwing@gmail.com
 * @Date 2020/1/15 15:10
 * @Version 1.0
 **/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for(int i = 1; i < m; i++){
            res[i][0] = res[i-1][0];
        }
        for(int i = 1; i < n; i++){
            res[0][i] = res[0][i-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }

        return res[m-1][n-1];
    }
}
