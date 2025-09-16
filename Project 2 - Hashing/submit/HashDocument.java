import java.util.*;

/**
 * The HashDocument class represents a document with a title, content and word frequency statistics.
 * It provides functionality to process the text, store word frequencies and perform operations like
 * retrieving word frequency, checking word existence, and calculating term frequency.
 * 
 * @author Cole Allan Francis Peterson
 * @version Mar 07, 2025
 */
public class HashDocument {
    private String title;
    private String content;
    private HashMap<String, Integer> wordFrequency = new HashMap<>();
   
    /**
     * Constructs a new HashDocument with a given title and content.
     * The content is processed to build the word frequency map.
     * 
     * @param t The title of the document.
     * @param c The content of the document, which will be analyzed for word frequencies.
     */
    public HashDocument(String t, String c)
    {
        this.title = t;
        this.content = c;
        this.wordFrequency = new HashMap<>();
        processWords(content);
    }

    /**
     * Returns the title of the document.
     * 
     * @return The title of the document.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns the content of the document.
     * 
     * @return The content of the document.
     */
    public String getContent(){
        return content;
    }

    /**
     * Processes the content to extract words that are longer than 3 characters,
     * converts them to lowercase, and adds them to the word frequency map.
     * Punctuation is skipped, and only words are considered.
     * 
     * @param content The full content of the document.
     */
    private void processWords(String content) {
        String[] words = content.split("\\W+");
        for (String word : words) {
            if (word.length() > 3) {
                addWord(word.toLowerCase());
            }
        }
    }

    /**
     * Returns the frequency of a specific word in the document.
     * The word is case-insensitive, so "Hello" and "hello" are treated as the same word.
     * 
     * @param w The word whose frequency is to be retrieved.
     * @return The frequency of the word in the document.
     */
    public int frequency(String w) {
        return wordFrequency.getOrDefault(w.toLowerCase(), 0);
    }

    /**
     * Adds a word to the document's word frequency map. If the word already exists, 
     * its count is incremented. If it does not exist, it is added with a count of 1.
     * The word is treated in a case-insensitive manner.
     * 
     * @param w The word to be added to the frequency map.
     */
    public void addWord(String w) {
        wordFrequency.put(w , wordFrequency.getOrDefault(w, 0) + 1);
    }

    /**
     * Checks if a specific word exists in the document's word frequency map.
     * The word check is case-insensitive.
     * 
     * @param w The word to check for existence.
     * @return True if the word exists in the document, false otherwise.
     */
    public boolean contains(String w) {
        return wordFrequency.containsKey(w.toLowerCase());
    }

    /**
     * Returns the number of unique words in the document's word frequency map.
     * 
     * @return The number of unique words.
     */
    public int numUniqueWordsInTable() {
        return wordFrequency.size();
    }

    /**
     * Returns the total number of words in the document, including repeated occurrences.
     * This value is the sum of the frequencies of all words.
     * 
     * @return The total number of words in the document.
     */
    public int totalNumOfWords() {
        int total = 0;
        for(int count : wordFrequency.values()){
            total += count;
        }
        return total;
    }

    /**
     * Returns the most common word in the document, i.e., the word with the highest frequency.
     * If multiple words have the same highest frequency, the first encountered will be returned.
     * 
     * @return The most common word in the document.
     */
    public String mostCommonWord() {
        String mostCommon = null;
        int maxCount = 0;
        for(Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostCommon;
    }

    /**
     * Calculates term frequency for a given word, which is the ratio of the frequency of the word
     * to the total number of words in the document. The result is a value between 0 and 1.
     * 
     * @param w The word for which the term frequency is calculated.
     * @return The term frequency of the word in the document, or 0 if the total word count is 0.
     */
    public double termFrequency(String w) {
        int totalWords = totalNumOfWords();
        return (double) frequency(w) / totalWords;
    }
}