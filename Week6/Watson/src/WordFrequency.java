// Step 8
public class WordFrequency implements Comparable<WordFrequency> {
    String word;
    int wordCount;

    public WordFrequency(String passedWord, int passedWordCount) {
        this.word = passedWord;
        this.wordCount = passedWordCount;
    }

    public String getWord() {
        return this.word;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    
    @Override
    public int compareTo(WordFrequency otherWordFrequency) {
        int frequencyValue = 2;

        if (this.wordCount > otherWordFrequency.wordCount)
            frequencyValue = 1;
        if (this.wordCount < otherWordFrequency.wordCount)
            frequencyValue = -1;
        if (this.wordCount == otherWordFrequency.wordCount)
            frequencyValue = 0;
        
        return frequencyValue;
    }
}
