package answer.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortEncodingofWwordsTest {
    private ShortEncodingofWwords shortEncodingofWwords = new ShortEncodingofWwords();


    @Test
    public void minimumLengthEncoding1() {
        assertEquals(10, shortEncodingofWwords.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    @Test
    public void minimumLengthEncoding2() {
        assertEquals(5, shortEncodingofWwords.minimumLengthEncoding(new String[]{"time", "me"}));
    }


}