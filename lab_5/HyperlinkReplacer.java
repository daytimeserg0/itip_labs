import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HyperlinkReplacer {
    public static void main(String[] args) {
        String text = "Это текст с ссылкой: regexr.com и еще одной example.org.";

        String regex = "((\\b\\S+\\.org\\b)|(\\b\\S+\\.com\\b))";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Ссылка: " + matcher.group());
            System.out.println("Гиперссылка: http://" + matcher.group() + "\n");
        }
    }
}
