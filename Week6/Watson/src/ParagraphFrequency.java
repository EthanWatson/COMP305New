// Step 17
/** Represents a word and it's word count */
public class ParagraphFrequency implements Comparable<ParagraphFrequency> {
    String word;
    int wordCount;

    public ParagraphFrequency(String passedWord, int passedWordCount) {
        this.word = passedWord;
        this.wordCount = passedWordCount;
    }

    /** Get the word stored in this class */
    public String getWord() {
        return this.word;
    }

    /** Get the number of occurances of the word stored in this class */
    public int getWordCount() {
        return this.wordCount;
    }

    /** Override the toString method to reference the parent object */ 
    @Override
    public String toString() {
        return super.toString();
    }

    
    /** Override the compareTo method to return a value based on the frequency of this class's stored word compared to the otherParagraphFrequency
     * return 1 for higher
     * return -1 for lower
     * return 0 for equal
     * return 2 for other
     */
    @Override
    public int compareTo(ParagraphFrequency otherParagraphFrequency) {
        int frequencyValue = 2;

        if (this.wordCount > otherParagraphFrequency.wordCount)
            frequencyValue = 1;
        if (this.wordCount < otherParagraphFrequency.wordCount)
            frequencyValue = -1;
        if (this.wordCount == otherParagraphFrequency.wordCount)
            frequencyValue = 0;
        
        return frequencyValue;
    }
}
