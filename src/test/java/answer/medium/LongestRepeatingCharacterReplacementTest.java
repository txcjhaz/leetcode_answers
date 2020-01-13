package answer.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestRepeatingCharacterReplacementTest {

    @Test
    public void characterReplacement1() {
        assertEquals(4, LongestRepeatingCharacterReplacement.characterReplacement("ABAB", 2));
    }

    @Test
    public void characterReplacement2() {
        assertEquals(4, LongestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1));
    }

    @Test
    public void characterReplacement3() {
        assertEquals(4, LongestRepeatingCharacterReplacement.characterReplacement("AAAA", 2));
    }

    @Test
    public void count() {
        assertEquals(4, LongestRepeatingCharacterReplacement.count("choiasdhnacascc".toCharArray()));
    }
}