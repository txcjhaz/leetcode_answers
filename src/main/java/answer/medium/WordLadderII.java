package answer.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName WordLadderII
 * @Deacription 126. 单词接龙 II
 * @Author Junhui Chen txcjhwing@gmail.com
 * @Date 2020/1/16 14:02
 * @Version 1.0
 **/
public class WordLadderII {
    // 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
    //
    // 每次转换只能改变一个字母。
    // 转换过程中的中间单词必须是字典中的单词。
    // 说明:
    //
    // 如果不存在这样的转换序列，返回一个空列表。
    // 所有单词具有相同的长度。
    // 所有单词只由小写字母组成。
    // 字典中不存在重复的单词。
    // 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0)
            return res;

        for(int i = 0; i < wordList.size(); i++){
            List<String> words = new ArrayList<>(wordList);
            if(canTrans(beginWord, wordList.get(i))){
                List<List<String>> subRes = isOk(wordList.get(i), endWord, wordList);
                for(List<String> list : subRes) {
                    list.add(0, beginWord);
                    res.add(list);
                }
            }
        }

        // 挑选出最短的
        int min = Integer.MAX_VALUE;
        for(List<String> list : res)
            if(list.size() < min)
                min = list.size();
        Iterator<List<String>> it = res.iterator();
        while(it.hasNext()){
            if(it.next().size() != min)
                it.remove();
        }

        return res;
    }

    public List<List<String>> isOk(String cur, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (cur.equals(endWord)) {
            List<String> tmp = new ArrayList<>();
            tmp.add(cur);
            res.add(tmp);
            return res;
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (canTrans(cur, wordList.get(i))) {
                List<String> subwords = new ArrayList<>(wordList);

                // 删除元素
                Iterator<String> it = subwords.iterator();
                while (it.hasNext()) {
                    String tmp = it.next();
                    if (tmp.equals(wordList.get(i))) {
                        it.remove();
                        break;
                    }
                }

                List<List<String>> subRes = isOk(wordList.get(i), endWord, subwords);
                if (subRes.size() > 0) {
                    for (List<String> list : subRes) {
                        list.add(0, cur);
                        res.add(list);
                    }
                }
            }
        }

        return res;
    }

    /* *
     * @Author Junhui Chen txcjhwing@gmail.com
     * @Description 判断能否仅改变一个字符转换
     * @Date 14:34 2020/1/16
     * @Param [source, target]
     * @return boolean
     **/
    public boolean canTrans(String source, String target){
        int times = 0;
        char[] S = source.toCharArray();
        char[] T = target.toCharArray();
        if(S.length != T.length)
            return false;
        else{
            for(int i = 0; i < S.length; i++){
                if(S[i] != T[i])
                    times++;
            }
            return times == 1;
        }
    }
}
