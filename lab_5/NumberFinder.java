import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the pro22duct is $19.99 -22.22 43.02.2 aaa22 -324 27 27.0 27a ";

        Pattern digPattern = Pattern.compile("(?<=(\\s|\\$|^))-?\\d+(\\.\\d+)*(?=\\s)");
        Matcher digMatcher = digPattern.matcher(text);
        while (digMatcher.find()) {
            if (countPoints(digMatcher.group()) >= 2) {
                System.err.println("Недопустимое значение: " + digMatcher.group());
            } else {
                System.out.println(digMatcher.group());
            }
        }
    }

    public static int countPoints (String str) {
        String dot = ".";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(dot)) {
                count += 1;
            }
        }
        return count;
    }
}