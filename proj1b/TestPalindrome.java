import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
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
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));

        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("love"));
        assertFalse(palindrome.isPalindrome("aslkdfjklsasdf"));

        // OffByOne palindromes test
        OffByOne offByOne = new OffByOne();

        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("cd", offByOne));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("bgkxylha", offByOne));

        assertFalse(palindrome.isPalindrome("racecar", offByOne));
        assertFalse(palindrome.isPalindrome("noon", offByOne));
        assertFalse(palindrome.isPalindrome("horse", offByOne));
        assertFalse(palindrome.isPalindrome("love", offByOne));
        assertFalse(palindrome.isPalindrome("aslkdfjklsasdf", offByOne));
    }
}
