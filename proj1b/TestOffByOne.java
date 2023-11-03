import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    @Test
    // Your tests go here.
    public void equalCharsTest(){
        char a = 'm';
        char b = 'n';
        char c = 'Q';
        char d = 'm';
        assertTrue(offByOne.equalChars(a,b));
        assertFalse(offByOne.equalChars(a,d));
        assertFalse(offByOne.equalChars(a,c));
        assertFalse(offByOne.equalChars(c,d));
        assertTrue(offByOne.equalChars('&', '%'));
        assertFalse(offByOne.equalChars('a', 'A'));
        
    }
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
}
