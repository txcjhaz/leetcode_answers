package answer.hard;

/**
 * @ClassName MinimumWindowSubstring
 * @Deacription 76. 最小覆盖子串
 * @Author Junhui Chen txcjhwing@gmail.com
 * @Date 2020/1/13 16:44
 * @Version 1.0
 **/
public class MinimumWindowSubstring {
    int[] dict = new int[256];

    // 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
    public String minWindow(String s, String t) {
        if(s.equals("") || t.equals("") || t.length() > s.length())
            return "";

        // t
        for(int i = 0; i < t.length(); i++){
            dict[t.charAt(i)]++;
        }

        int left = 0, right = 1;
        String res = s;
        boolean flag = false;
        while(right <= s.length()){
            String sub = s.substring(left, right);
            while(right - left > 0 && test(sub, t)){
                if(res.length() >= sub.length()) {
                    res = sub;
                    flag = true;
                }
                left++;
                sub = s.substring(left, right);
            }
            right++;
        }
        right--;
        // right已到头，left开始缩
        while(left < right){
            String sub = s.substring(left, right);
            while(right - left > 0 && test(sub, t)){
                if(res.length() >= sub.length()) {
                    res = sub;
                    flag = true;
                }
                left++;
                sub = s.substring(left, right);
            }
            left++;
        }

        if(flag)
            return res;
        else
            return "";
    }

    // 判断a是否包含b所有的字符
    public boolean test(String a, String b){
        int[] dictA = new int[256];
        for(int i = 0; i < a.length(); i++){
            dictA[a.charAt(i)]++;
        }
        for(int i = 0; i < 256; i++){
            if(dict[i] > 0){
                if(dict[i] > dictA[i])
                    return false;
            }
        }
        return true;
    }
}
