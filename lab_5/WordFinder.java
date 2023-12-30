import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFinder {
    public static void main(String[] args) {
        String text = "Hello world, I am igor so proud to be behind here!";
        String targetLetter = "h";
        String regex = "(?<=(\\s|^))(" + targetLetter.toUpperCase() + "|" + targetLetter.toLowerCase() + ")[A-z]+\\b" +
                "|(?<=(\\s|^))(" + targetLetter.toUpperCase() + "|" + targetLetter.toLowerCase() + ")\\b";

        Pattern wordPatern = Pattern.compile(regex);
        Matcher wordMatcher = wordPatern.matcher(text);

        while (wordMatcher.find()) {
            System.out.println(wordMatcher.group());
        }
    }
}
