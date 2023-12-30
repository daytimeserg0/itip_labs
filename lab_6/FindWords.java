import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.HashMap;

public class FindWords {
    public static void main(String[] args) {
        ArrayList<String> words = fileToArray("text.txt");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase();
            if (!wordCountMap.containsKey(word)) {
                wordCountMap.put(word, 1);
            } else {
                int new_value = wordCountMap.get(word) + 1;
                wordCountMap.put(word, new_value);
            }
        }

        wordCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static ArrayList<String> fileToArray(String file_name) {
        String text = "";
        try {
            FileReader reader = new FileReader(file_name);

            int character;
            while ((character = reader.read()) != -1) {
                char charValue = (char) character;
                text += String.valueOf(charValue);
            }
            reader.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Pattern wordPattern = Pattern.compile("\\b[A-z]+\\b");
        Matcher wordMatcher = wordPattern.matcher(text);

        ArrayList<String> words = new ArrayList<>();

        while (wordMatcher.find()) {
            words.add(wordMatcher.group());
        }
        return words;
    }
}