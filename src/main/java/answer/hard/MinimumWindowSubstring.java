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
        StringBuilder S = new StringBuilder(s);
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        if(s.equals("") || t.equals("") || t.length() > s.length())
            return "";

        // t
        for(int i = 0; i < t.length(); i++){
            dict[tt[i]]++;
        }

        int left = 0, right = 1;
        String res = s;
        boolean flag = false;
        while(right <= s.length()){
            String sub = S.substring(left, right);
//            String sub = s.substring(left, right);
            while(right - left > 0 && test(sub, t)){
                if(res.length() >= sub.length()) {
                    res = sub;
                    flag = true;
                }
                left++;
                sub = S.substring(left, right);
            }
            right++;
        }
        right--;
        // right已到头，left开始缩
        String sub = S.substring(left, right);
        while(right - left > 0 && test(sub, t)){
            if(res.length() >= sub.length()) {
                res = sub;
                flag = true;
            }
            left++;
            sub = S.substring(left, right);
        }

        if(flag)
            return res;
        else
            return "";
    }

    /* *
     * @Author Junhui Chen txcjhwing@gmail.com
     * @Description 这个版本应该满足时间复杂度的要求了，但对于最终结果的处理还是有待改进
     * @Date 10:42 2020/1/14
     * @Param [s, t]
     * @return java.lang.String
     **/
    public String minWindow2(String s, String t) {
        StringBuilder S = new StringBuilder(s);
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        if(s.equals("") || t.equals("") || t.length() > s.length())
            return "";

        // t
        for(int i = 0; i < t.length(); i++){
            dict[tt[i]]++;
        }

        int count = 0, n = t.length();
        int L = 0, R = 0;
        int L_res = 0, R_res = s.length();
        int[] map = new int[256];
        boolean changed = false;
        while(R < s.length()){
            if(dict[ss[R]] - map[ss[R]] > 0)
                count++;
            map[ss[R]]++;

            while(count == n){
                if(R-L < R_res-L_res) {
                    changed = true;
                    L_res = L;
                    R_res = R;
                }
                map[ss[L]]--;
                if(dict[ss[L]] - map[ss[L]] > 0)
                    count--;
                L++;
            }
            R++;
        }


        if(count < n - 1 || count == 0 && L_res != R_res || !changed)
            return "";

        return s.substring(L_res, R_res + 1);
    }

    // 执行用时9ms的java
    public String minWindowImproved(String s, String t) {
        int m=s.length(),n=t.length();
        if(m<n){
            return "";
        }
        //转化成数组，提升查找速度
        char[] S=s.toCharArray();
        char[] T=t.toCharArray();
        int[] map=new int[256];//利用ASSII码做映射，比hashmap效率高
        for(int i=0;i<n;i++){
            map[T[i]]++;
        }
        int start=-1;
        int L=0,R=0;//滑动窗口[L,R]
        int count=0;//保存窗口里已经找到了多少字符
        int min=m+1;
        while(L<=m-n&&R<m){
            map[S[R]]--;
            if(map[S[R]]>=0){
                count++;
            }
            if(count==n){
                while(map[S[L]]<0){//L尽量往左移动
                    map[S[L]]++;
                    L++;
                }
                if(R-L<min){//记录位置
                    min=R-L;
                    start=L;
                }
                map[S[L++]]++;//L继续右移一位，进行下次寻找
                count--;
            }
            R++;
        }
        if(min<m+1){
            return s.substring(start,start+min+1);
        }
        return "";
    }

    // 判断a是否包含b所有的字符
    public boolean test(String a, String b){
        char[] aa = a.toCharArray();
        int[] dictA = new int[256];
        for(int i = 0; i < a.length(); i++){
            dictA[aa[i]]++;
        }
        for(int i = 0; i < 256; i++){
            if(dict[i] > dictA[i]){
                return false;
            }
        }
        return true;
    }
}
