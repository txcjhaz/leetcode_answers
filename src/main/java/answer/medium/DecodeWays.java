package answer.medium;

/**
 * @ClassName DecodeWays
 * @Deacription 91. 解码方法
 * @Author Junhui Chen txcjhwing@gmail.com
 * @Date 2020/1/15 15:21
 * @Version 1.0
 **/
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;

        char[] S = s.toCharArray();
        int[] res = new int[S.length];

        // 手动计算一下初始情况
        res[0] = S[0] == '0' ? 0 : 1;
        if (S.length > 1)
            if (S[1] == '0') {
                if (S[0] == '0' || S[0] > '2')
                    return 0;
                res[1] = 1;
            }
            else
                res[1] = (S[0] == '1' || (S[0] == '2' && S[1] < '7')) ? 2 : 1;

        for (int i = 2; i < S.length; i++) {
            if (S[i] == '0') {
                if (S[i - 1] == '0' || S[i - 1] > '2')
                    return 0;
                res[i] = res[i - 2];
            } else if (S[i - 1] == '1' || (S[i - 1] == '2' && S[i] < '7')) {   // 说明可以组合
                res[i] = res[i - 1] + res[i - 2];
            } else
                res[i] = res[i - 1];
        }

        return res[S.length - 1];
    }
}
