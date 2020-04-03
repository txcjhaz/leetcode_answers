package answer.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 820. 单词的压缩编码
 */
public class ShortEncodingofWwords {
    public int minimumLengthEncoding(String[] words) {
        TreeNode trie = new TreeNode();
        Map<TreeNode, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            TreeNode tmp = trie;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                tmp = tmp.get(words[i].charAt(j));
            }
            map.put(tmp, i);
        }


        int res = 0;
        for (TreeNode node : map.keySet()) {
            if (node.count == 0) {
                res += words[map.get(node)].length() + 1;
            }
        }

        return res;
    }

    private class TreeNode {
        TreeNode[] children;
        int count;

        public TreeNode() {
            children = new TreeNode[26];
            count = 0;
        }

        public TreeNode get(char ch) {
            if (children[ch - 'a'] == null) {
                children[ch - 'a'] = new TreeNode();
                count++;
            }
            return children[ch - 'a'];
        }
    }
//
//    public int minimumLengthEncoding(String[] words) {
//        int res = Integer.MAX_VALUE;
//        for(int i = 0; i < words.length; i++){
//            String[] otherWords = new String[words.length];
//            System.arraycopy(words, 0, otherWords, 0, words.length);
//            String t = otherWords[i];
//            otherWords[i] = otherWords[0];
//            otherWords[0] = t;
//            res = Math.min(res, go(words[i], 1, otherWords));
//        }
//        return res;
//    }
//
//    public int go(String curStr, int p, String[] words) {
//        if (p == words.length) {
//            if (curStr.charAt(curStr.length() - 1) == '#')
//                return curStr.length();
//            else
//                return curStr.length() + 1;
//        }
//
//        int[] a = new int[words.length-p];
////        Arrays.fill(a, 0);
//        for(int i = p; i < words.length;i++) {
//            String str = words[i];  // 当前字串后面一个字串
//            int matchNum = match(curStr, str);
//            int b = Integer.MAX_VALUE;
//            if (matchNum > 0) {
//                String tmp = curStr + "#" + (str.length() > matchNum ? str.substring(matchNum) : "");
//                String[] otherWords = new String[words.length];
//                System.arraycopy(words, 0, otherWords, 0, words.length);
//                String t = otherWords[i];
//                otherWords[i] = otherWords[p];
//                otherWords[p] = t;
//                b = go(tmp, p + 1, otherWords);
//            }
//            int c = go(curStr + str, p + 1, words);
//            a[i-pget] = Math.min(b, c);
//        }
//        int res = Integer.MAX_VALUE;
//        for(int i : a){
//            res = Math.min(i, res);
//        }
//
//        return res;
//    }
//
//    /**
//     * 返回b开头可被编码的字符数量
//     *
//     * @param a 源串
//     * @param b 待编码串
//     * @return b开头可被编码的字符数量
//     */
//    public int match(String a, String b) {
//        int p = a.length() - 1;
//        int q = 0;
//        int res = 0;
//        while (p >= 0 && q < b.length()) {
//            if (a.substring(p).equals(b.substring(0, q + 1)))
//                res = q + 1;
//            p--;
//            q++;
//        }
//        return res;
//    }
}
