import org.junit.*;
import static org.junit.Assert.*;

/**
 * Unit tests for the WordFrequency class.
 * This class tests the methods of the WordFrequency class including
 * the constructor, getters, incrementing the count, and comparison functionality.
 * 
 * @author Cole Allan Francis Peterson
 * @version Mar 01, 2025
 */
public class WordFrequencyTest {
    // Object to be tested
    private WordFrequency runner;

    /**
     * setup() method, runs before each test method below.
     * Initializes the runner object with the word "Hello".
     */
    @Before
    public void setup() {
        runner = new WordFrequency("Hello");
    }

    /**
     * Test for the getWord() method.
     * Verifies that the word "Hello" is correctly returned.
     */
    @Test
    public void testGetWord() {
        assertEquals("Hello", runner.getWord());
    }

    /**
     * Test for the getCount() method.
     * Verifies that the initial count is 1 when a WordFrequency object is created.
     */
    @Test
    public void testGetCount() {
        assertEquals(1 , runner.getCount());
    }

    /**
     * Test for the increment() method.
     * Verifies that the count is correctly incremented from 1 to 2.
     */
    @Test
    public void testIncrement() {
        assertEquals(1, runner.getCount());
        runner.increment();
        assertEquals(2, runner.getCount());
    }

    /**
     * Test for the compareTo() method when comparing the same word.
     * Verifies that when comparing the same WordFrequency object, the result is 0.
     */
    @Test
    public void testCompareToSameWord() {
        assertEquals(0 , runner.compareTo(runner));
    }

    /**
     * Test for the compareTo() method when comparing different words.
     * Verifies that when comparing different words, the comparison result is negative.
     */
    @Test
    public void testCompareToDifferentWords() {
        WordFrequency runner2 = new WordFrequency("World");
        assertTrue(runner.compareTo(runner2) < 0);  
        assertTrue(runner2.compareTo(runner) > 0);  
    }

    /**
     * Test for the compareTo() method when comparing the same word but with different counts.
     * Verifies that the comparison result reflects the count difference.
     */
    @Test
    public void testCompareToSameWordDifferentCounts() {
        WordFrequency runner2 = new WordFrequency("Hello");
        runner2.increment();  
        assertTrue(runner.compareTo(runner2) < 0);  
        assertTrue(runner2.compareTo(runner) > 0); 
    }
}