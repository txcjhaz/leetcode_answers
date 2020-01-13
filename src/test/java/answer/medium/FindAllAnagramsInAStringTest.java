package answer.medium;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FindAllAnagramsInAStringTest {
    private FindAllAnagramsInAString findAllAnagramsInAString;


    @Before
    public void before() {
        findAllAnagramsInAString = new FindAllAnagramsInAString();
    }

    @Test
    public void findAnagrams() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(6);
        assertEquals(expected,
                findAllAnagramsInAString.findAnagrams("cbaebabacd", "abc"));
    }
}