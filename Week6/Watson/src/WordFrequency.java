public class WordFrequency {
    String word;
    int wordCount;

    public WordFrequency(String passedWord, int passedWordCount) {
        word = passedWord;
        wordCount = passedWordCount;
    }

    public String getWord() {
        return word;
    }

    public int getWordCount() {
        return wordCount;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
