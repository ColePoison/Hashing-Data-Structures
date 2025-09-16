/**
 * Project2 as a public class that implements, inherited methods from Comparable<WordFrequency>.
 * This class provides functionality to store, manipulate strings.
 * It includes methods for counting, comparing, and getting string data.
 * 
 * @author  Cole Allan Francis Peterson
 * @version Mar 01, 2025
 */
public class WordFrequency implements Comparable<WordFrequency> {
    private String word;
    private int count;

    /**
     * Constructs a WordFrequency object for a given word.
     * Initializes the word with the specified value and sets the count to 1.
     *
     * @param w The word for which this WordFrequency object is created.
     */
    public WordFrequency(String w) {
        this.word = w;
        this.count = 1;
    }

    /**
     * Returns the word associated with this WordFrequency object.
     *
     * @return The word stored in this WordFrequency object.
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the count of occurrences of the word associated with this WordFrequency object.
     *
     * @return The count of the word.
     */
    public int getCount() {
        return count;
    }

    /**
     * Increments the count by 1 to track an additional occurrence of the word.
     */
    public void increment() {
        count++;
    }

    /**
     * Compares this WordFrequency object with another WordFrequency object.
     * The comparison is first based on the word (lexicographically).
     * If the words are the same, the comparison is then based on the count (ascending order).
     *
     * @param other The other WordFrequency object to compare with.
     * @return A negative integer, zero, or a positive integer as this object is less than,
     *         equal to, or greater than the specified object.
     */
    public int compareTo(WordFrequency other) {
        int wordComparison = this.word.compareTo(other.word);
        
        if (wordComparison != 0) {
            return wordComparison;
        }
        return Integer.compare(this.count, other.count);
    }
}