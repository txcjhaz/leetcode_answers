package answer.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FindAllAnagramsInAString
 * @Deacription 438. 找到字符串中所有字母异位词
 * @Author Junhui Chen txcjhwing@gmail.com
 * @Date 2020/1/13 15:31
 * @Version 1.0
 **/
public class FindAllAnagramsInAString {
    // 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
    // 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        // 初始情况
        if(p.equals(""))
            return res;

        int[] dictP = new int[256];         // 记录p中所有字符出现的次数
        for(int i = 0; i < p.length(); i++){
            dictP[p.charAt(i)]++;
        }

        for(int i = 0; i < s.length() - p.length() + 1; i++){
            String sub = s.substring(i, i + p.length());
            int[] dictSub = new int[256];
            for(int j = 0; j < sub.length(); j++){
                dictSub[sub.charAt(j)]++;
            }

            // 比较dictSub与dictP，若相同，则将i加入res
            boolean isSame = true;
            for(int j = 0; j < 256; j++){
                if (dictP[j] != dictSub[j]) {
                    isSame = false;
                    break;
                }
            }
            if(isSame)
                res.add(i);
        }
        return res;
    }
}