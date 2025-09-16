import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the HashDocument class.
 * Verifies word addition, frequency calculation, content retrieval, and other functionalities.
 * 
 * @author Cole Allan Francis Peterson
 * @version Mar 07, 2025
 */
public class HashDocumentTest {
    /** 
     * Object being tested. 
     * */
    private HashDocument runner;

    /** 
     * Sets up a HashDocument instance before each test case. 
     */
    @Before
    public void setup() {
        String gettysburgText = "Four score and seven years ago our fathers brought forth," +
            " upon this continent, "+
            "a new nation, conceived in liberty, and dedicated"+
            "to the proposition that \"all men are created equal.\" " +
            "Now we are engaged in a great civil war,"+
            "testing whether that nation, or any nation so conceived, " +
            "and so dedicated, can long endure. We are met on a great battlefield of that war. " +
            " We have come to dedicate a portion of it,"+
            " as a final resting place for those who died here, that the nation might live. " +
            "This we may, in all propriety do. But, in a larger sense," +
            " we can not dedicate -- we can not consecrate --"+
            "we can not hallow, this ground -- The brave men, living and dead, " +
            " who struggled here, have hallowed it, "+
            "far above our poor power to add or detract. The world will little note," +
            " nor long remember what we say here; "+
            "while it can never forget what they did here. It is rather for us," +
            " the living, to stand here, we here be dedicated to the great task "+
            "remaining before us -- that, from these honored dead we take " +
            "increased devotion to that cause for which they here," +
            " gave the last full measure of devotion -- "+
            "that we here highly resolve these dead shall not have died in vain;" +
            "that the nation, shall have a new birth of freedom, "+
            "and that government of the people, by the people, for the people, " +
            "shall not perish from the earth.";

        runner = new HashDocument("Gettysburg", gettysburgText);
    }

    /** 
     * Tests the addWord method. 
     */
    @Test
    public void testAddWord() {
        runner.addWord("freedom"); 
        assertEquals(2, runner.frequency("freedom"));
    }

    /** 
     * Tests the contains method. 
     * */
    @Test
    public void testContains() {
        assertTrue(runner.contains("freedom"));
        assertFalse(runner.contains("meow"));
    }

    /** 
     * Tests the frequency method. 
     */
    @Test
    public void testFrequency() {
        assertEquals(1, runner.frequency("freedom")); 
        assertEquals(0, runner.frequency("cat"));
    }

    /**
     *  Tests the getContent method. 
     */
    @Test
    public void testGetContent() {
        assertTrue(runner.getContent().contains("Four score and seven years ago"));
    }
    /** 
     * Tests the getTitle method. 
    */
    @Test
    public void testGetTitle() {
        assertEquals("Gettysburg", runner.getTitle());
    }

    /** 
     * Tests the mostCommonWord method. 
     */
    @Test
    public void testMostCommonWord() {
        assertEquals("that", runner.mostCommonWord());
    }

    /** 
     * Tests the numUniqueWordsInTable method. 
     * */
    @Test
    public void testNumUniqueWordsInTable() {
        assertTrue(runner.numUniqueWordsInTable() > 0);
    }

    /** 
     * Tests the termFrequency method. 
    */
    @Test
    public void testTermFrequency() {
        assertTrue(runner.termFrequency("nation") > 0 && runner.termFrequency("nation") <= 1);
    }

    /** 
     * Tests the totalNumOfWords method.
     */
    @Test
    public void testTotalNumOfWords() {
        assertTrue(runner.totalNumOfWords() > 0);
    }
}