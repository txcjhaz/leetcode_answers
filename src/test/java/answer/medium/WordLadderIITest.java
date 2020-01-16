package answer.medium;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordLadderIITest {
    private WordLadderII wordLadderII;

    @Before
    public void setUp() throws Exception {
        wordLadderII = new WordLadderII();
    }

    @Test
    public void findLadders1() {
        JSONArray expected = JSONArray.parseArray("[\n" +
                "  [\"hit\",\"hot\",\"dot\",\"dog\",\"cog\"],\n" +
                "  [\"hit\",\"hot\",\"lot\",\"log\",\"cog\"]\n" +
                "]");
        JSONArray actual = new JSONArray();
        actual.add(wordLadderII.findLadders("hit",
                "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(expected.toJSONString(), actual.toJSONString().substring(1, actual.toJSONString().length()-1));
    }

    @Test
    public void findLadders2() {
        JSONArray expected = JSONArray.parseArray("[]");
        JSONArray actual = new JSONArray();
        actual.add(wordLadderII.findLadders("hit",
                "cog",
                Arrays.asList("hot","dot","dog","lot","log")));
        assertEquals(expected.toJSONString(), actual.toJSONString().substring(1, actual.toJSONString().length()-1));
    }

    @Test
    public void findLadders3() {
        JSONArray expected = JSONArray.parseArray("[[\"a\",\"c\"]]");
        JSONArray actual = new JSONArray();
        actual.add(wordLadderII.findLadders("a",
                "c",
                Arrays.asList("a","b","c")));
        assertEquals(expected.toJSONString(), actual.toJSONString().substring(1, actual.toJSONString().length()-1));
    }

    @Test
    public void findLadders4() {
        JSONArray expected = JSONArray.parseArray("[[\"a\",\"c\"]]");
        JSONArray actual = new JSONArray();
        actual.add(wordLadderII.findLadders("qa",
                "sq",
                Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
        assertEquals(expected.toJSONString(), actual.toJSONString().substring(1, actual.toJSONString().length()-1));
    }

    @Test
    public void canTrans() {
        assertTrue(wordLadderII.canTrans("abc", "abb"));
        assertFalse(wordLadderII.canTrans("acb", "abc"));
    }
}