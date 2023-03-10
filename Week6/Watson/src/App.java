import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<String> words = readWords("res/words.txt"); //Step 4
        HashMap<String, Integer> wordCounter = buildHashMap(words); //Step 5
        createHTMLFile(wordCounter); //Step 6

        // Step 9
        ArrayList<WordFrequency> wordFrequencies = new ArrayList<>();
        for (String key: wordCounter.keySet()) {
            int wordCount = wordCounter.get(key);
            WordFrequency wordFrequency = new WordFrequency(key, wordCount);
            wordFrequencies.add(wordFrequency);
        }

        //Step 10
        // Sort the contents of the ArrayList in increasing order of the wordcount
        Collections.sort(wordFrequencies);
        // Create a second HTML file called sortedWords.html that consists of a table of words and word counts, 
        //  arranged in ascending wordcount order.
        createSortedWordsHTMLFile(wordFrequencies);

        //Step 14: read paragraph file
        ArrayList<String> paragraphWords = readWords("res/paragraph.txt");

        //Step 15: count word occurances and store them in a HashMap
        HashMap<String, Integer> paragraphMap = buildHashMap(paragraphWords);

        //Step 16: create an HTML file named paragraph.html that contains a table consisting of two columns
        createParagraphHTMLFile(paragraphMap);

        //Step 18: put data from paragraphMap into an ArrayList
        ArrayList<ParagraphFrequency> paragraphFrequencies = new ArrayList<>();
        for (String key: paragraphMap.keySet()) {
            int wordCount = paragraphMap.get(key);
            ParagraphFrequency paragraphFrequency = new ParagraphFrequency(key, wordCount);
            paragraphFrequencies.add(paragraphFrequency);
        }

        //Step 19: sort the paragraphFrequencies ArrayList and output to sortedParagraphWords.html
        Collections.sort(paragraphFrequencies);
        createSortedParagraphHTMLFile(paragraphFrequencies);

    }

    /** Step 4: Read input file */ 
    private static ArrayList<String> readWords(String fileName) {
        File file = new File(fileName);
        ArrayList<String> wordList = new ArrayList<>();

        try (FileReader reader = new FileReader(file)) {
            BufferedReader bufferredReader = new BufferedReader(reader);

            String line = bufferredReader.readLine();
            while (line != null) {
                String[] words = line.split("[ .,]+");
                for (String word: words) {
                    if (word.trim().length() > 0) {
                        wordList.add(word.toLowerCase());
                    }
                }
                line = bufferredReader.readLine();
            }
            bufferredReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    /** Step 5: Count Word Occurances */ 
    private static HashMap<String, Integer> buildHashMap(ArrayList<String> words) {
        HashMap<String, Integer> wordCounter = new HashMap<>();
        for (String word: words) {
            Integer count = wordCounter.get(word);
            if (count == null) {
                wordCounter.put(word, 1);
            }
            else {
                wordCounter.put(word, count + 1);
            }
        }
        return wordCounter;
    }

    /** Step 6: Create Output File */ 
    private static void createHTMLFile(HashMap<String, Integer> wordCounter) {
        File file = new File("res/words.html");
        try (FileWriter fileWriter = new FileWriter(file)) {
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Word Count</h1>");
            builder.append("<table  border=\"1\">");
            for (String key: wordCounter.keySet()) {
                builder.append("<tr>");
                builder.append("<td>" + key + "</td>");
                builder.append("<td>" + wordCounter.get(key) + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            fileWriter.append(builder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String keyWord: wordCounter.keySet()) {
            System.out.println(keyWord + ": " + wordCounter.get(keyWord));
        }
    }

    /** Step 10: Create sorted output file */ 
    private static void createSortedWordsHTMLFile(ArrayList<WordFrequency> wordCounter) {
        File file = new File("res/sortedWords.html");
        try (FileWriter fileWriter = new FileWriter(file)) {
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Sorted Word Count</h1>");
            builder.append("<table border=\"1\">");
            for (WordFrequency wordFrequency: wordCounter) {
                builder.append("<tr>");
                builder.append("<td>" + wordFrequency.getWord() + "</td>");
                builder.append("<td>" + wordFrequency.getWordCount() + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            fileWriter.append(builder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (WordFrequency wordFrequency: wordCounter) {
            System.out.println(wordFrequency.getWord() + ": " + wordFrequency.getWordCount());
        }
    }

    /** Step 16: Create paragraph output file */ 
    private static void createParagraphHTMLFile(HashMap<String, Integer> wordCounter) {
        File file = new File("res/paragraph.html");
        try (FileWriter fileWriter = new FileWriter(file)) {
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Paragraph Count</h1>");
            builder.append("<table  border=\"1\">");
            for (String key: wordCounter.keySet()) {
                builder.append("<tr>");
                builder.append("<td>" + key + "</td>");
                builder.append("<td>" + wordCounter.get(key) + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            fileWriter.append(builder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String keyWord: wordCounter.keySet()) {
            System.out.println(keyWord + ": " + wordCounter.get(keyWord));
        }
    }

    /** Step 19: create sorted paragraph words output file */ 
    private static void createSortedParagraphHTMLFile(ArrayList<ParagraphFrequency> wordCounter) {
        File file = new File("res/sortedParagraphWords.html");
        try (FileWriter fileWriter = new FileWriter(file)) {
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Sorted Paragraph Count</h1>");
            builder.append("<table border=\"1\">");
            for (ParagraphFrequency wordFrequency: wordCounter) {
                builder.append("<tr>");
                builder.append("<td>" + wordFrequency.getWord() + "</td>");
                builder.append("<td>" + wordFrequency.getWordCount() + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            fileWriter.append(builder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (ParagraphFrequency wordFrequency: wordCounter) {
            System.out.println(wordFrequency.getWord() + ": " + wordFrequency.getWordCount());
        }
    }
}
