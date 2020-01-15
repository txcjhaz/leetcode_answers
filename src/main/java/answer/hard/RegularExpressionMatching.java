package answer.hard;

import java.util.Arrays;
import java.util.Queue;

/**
 * @ClassName RegularExpressionMatching
 * @Deacription 10. 正则表达式匹配
 * @Author Junhui Chen txcjhwing@gmail.com
 * @Date 2020/1/15 9:54
 * @Version 1.0
 **/
public class RegularExpressionMatching {
    // 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
    // '.' 匹配任意单个字符
    // '*' 匹配零个或多个前面的那一个元素
    // 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
    // 说明:
    // s 可能为空，且只包含从 a-z 的小写字母。
    // p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
    public boolean isMatch(String text, String pattern) {
        char[] T = text.toCharArray(), P = pattern.toCharArray();
        boolean[][] dp = new boolean[T.length + 1][P.length + 1];

        dp[0][0] = true;
        for (int i = 0; i < P.length; i++) {
            dp[0][i + 1] = P[i] == '*' && dp[0][i - 1];
        }
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < P.length; j++) {
                if (T[i] == P[j] || P[j] == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (P[j] == '*') {
                    // 有两种情况
                    if (T[i] != P[j - 1] && P[j - 1] != '.') {        // 由于是星号，可以匹配0次或多次（相当于去掉不匹配的a*）
                        dp[i + 1][j + 1] = dp[i][j];                    // 所以现在dp[i][j]取决于dp[i][j-2]
                    } else {
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1];
                    }
                }
            }
        }

        return dp[T.length][P.length];
    }
}


// 初始情况
//        if(Ps[0].length() > 0){
//                char[] chs = Ps[0].toCharArray();
//                boolean flag = true;
//                for(int i = 0; i < chs.length; i++){
//        if (chs[i] != S[i]) {
//        flag = false;
//        break;
//        }
//        }
//        if(!flag)
//        return false;
//        indexs[0][0] = chs.length;
//        }
//        else
//        indexs[0][0] = 0;
//        // 后续情况
//        for(int i = 1; i < Ps.length; i++){
//        boolean flag = false;       // 匹配成功的标志
//        for(int k = 0; indexs[i-1][k] > 0; k++){
//        // 分两种情况，含星号和不含星号
//        if(Ps[i].contains("*")){
//        char[] chs = Ps[i].toCharArray();
//        if(chs[0] == '.'){  // 可以匹配任意字符，将剩余的索引全部写入indexs
//        for(int j = index)
//        }
//        }
//        else{
//
//        }
//        }
//        if(!flag)
//        return false;
//        }