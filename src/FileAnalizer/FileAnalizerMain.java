package FileAnalizer;

import java.io.IOException;
import java.util.Map;

public class FileAnalizerMain {
    public static void main(String[] args) {
        FileAnalizer analyzer = new FileAnalizer();
        String filePath = "";

        try {

            Map<String, Integer> wordMap = analyzer.wordMap(filePath);
            System.out.println("Word Map: " + wordMap);

            int totalWords = analyzer.totalWordCount(filePath);
            System.out.println("Total Word Count: " + totalWords);

            int uniqueWords = analyzer.uniqueWordCount(filePath);
            System.out.println("Unique Word Count: " + uniqueWords);

            int topN = 5;
            Map<String, Integer> topWords = analyzer.topFrequentWords(filePath, topN);
            System.out.println("Top " + topN + " Frequent Words: " + topWords);

            String specificWord = "example";
            int wordOccurrences = analyzer.countWordOccurrences(filePath, specificWord);
            System.out.println("Occurrences of word '" + specificWord + "': " + wordOccurrences);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while analyzing the file.");
        }
    }
}
