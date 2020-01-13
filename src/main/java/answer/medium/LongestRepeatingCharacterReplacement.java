package answer.medium;

/**
 * @ClassName LongestRepeatingCharacterReplacement
 * @Deacription 424. 替换后的最长重复字符
 * @Author Junhui Chen txcjhwing@gmail.com
 * @Date 2020/1/13 14:03
 * @Version 1.0
 **/
public class LongestRepeatingCharacterReplacement {
    // 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
    // 在执行上述操作后，找到包含重复字母的最长子串的长度。
    public static int characterReplacement(String s, int k) {
        if(s.length() == 0)
            return 0;

        int maxLength = 1;
        // 使用滑动窗口可优化到 O（N）
        for(int i = 0; i < s.length() - maxLength + 1; i++){
            char[] sub = s.substring(i, i + maxLength).toCharArray();
            if(count(sub) > sub.length - k) {
                maxLength++;
                i--;
            }
            else if(count(sub) == sub.length - k && i + maxLength < s.length() && sub[0] == s.charAt(i + maxLength)){
                maxLength++;
                i--;
            }
            if(maxLength == s.length())
                return maxLength;
        }
        return maxLength;
    }

    /* *
     * @Author Junhui Chen txcjhwing@gmail.com
     * @Description 数一下当前字符串包含多少个串首字符
     * @Date 14:22 2020/1/13
     * @Param [s, ch]
     * @return int
     **/
    public static int count(char[] chs){
        int count = 1;
        for(int i = 1; i < chs.length; i++){
            if(chs[i] == chs[0])
                count++;
        }
        return count;
    }
}
