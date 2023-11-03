import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    //You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }// Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testIsPalindrome(){
        Palindrome actual = new Palindrome();
        String a = "wujianghui";
        String b = "j";
        String c = "";
        String d = "jxdxj";
        assertFalse(actual.isPalindrome(a));
        assertTrue(actual.isPalindrome(b));
        assertTrue(actual.isPalindrome(c));
        assertTrue(actual.isPalindrome(d));

    }

    @Test
    public void testIspalindromeOffByOne() {
        CharacterComparator cc = new OffByOne();
        Palindrome actual = new Palindrome();
        assertFalse(actual.isPalindrome("aaa",cc));
        assertTrue(actual.isPalindrome("a",cc));
        assertTrue(actual.isPalindrome("",cc));
        assertTrue(actual.isPalindrome("abb",cc));

    }

    @Test
    public void testIspalindromeOffByN() {
        CharacterComparator cc = new OffByN(5);
        Palindrome actual = new Palindrome();
        assertFalse(actual.isPalindrome("aaa",cc));
        assertTrue(actual.isPalindrome("a",cc));
        assertTrue(actual.isPalindrome("",cc));
        assertTrue(actual.isPalindrome("abf",cc));

    }



}
