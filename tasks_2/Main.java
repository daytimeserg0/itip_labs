import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------1");
        System.out.println(duplicateChars("donald"));
        System.out.println(duplicateChars("orange"));

        System.out.println("----------2");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));

        System.out.println("----------3");
        int[] numbers1 = {44, 32, 86, 19};
        int[] numbers2 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(numbers1));
        System.out.println(differenceEvenOdd(numbers2));

        System.out.println("----------4");
        int[] numbers3 = {1, 2, 3, 4, 5};
        int[] numbers4 = {1, 2, 3, 4, 6};
        System.out.println(equalToAvg(numbers3));
        System.out.println(equalToAvg(numbers4));

        System.out.println("----------5");
        int[] numbers5 = {1, 2, 3};
        int[] numbers6 = {3, 3, -2, 408, 3, 31};
        System.out.println(indexMult(numbers5));
        System.out.println(indexMult(numbers6));

        System.out.println("----------6");
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));

        System.out.println("----------7");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));

        System.out.println("----------8");
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));

        System.out.println("----------9");
        System.out.println(botHelper("Hello, I’m under the water, he help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));

        System.out.println("----------10");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }


    public static boolean duplicateChars(String x) {
        int length = x.length();
        char[] letters = new char[length];
        for (int i = 0; i < x.length(); i++) {
            letters[i] = x.charAt(i);
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (letters[i] == letters[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getInitials(String x) {
        String[] parts = x.split(" ");
        char fn = parts[0].charAt(0);
        char ln = parts[1].charAt(0);
        return String.valueOf(fn) + String.valueOf(ln);
    }

    public static int differenceEvenOdd(int[] x) {
        int lenght = x.length;
        int k = 0;
        for (int i = 0; i < lenght; i++) {
            if (x[i] % 2 == 0) {
                k += x[i];
            } else {
                k -= x[i];
            }
        }
        return Math.abs(k);
    }

    public static boolean equalToAvg(int[] x) {
        float lenght = x.length;
        float k = 0;
        for (int i = 0; i < lenght; i++) {
            k += x[i];
        }
        float avg = k / lenght;
        for (int i = 0; i < lenght; i++) {
            if (x[i] == avg) {
                return true;
            }
        }
        return false;
    }

    public static String indexMult(int[] x) {
        int[] y = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = x[i] * i;
        }
        return Arrays.toString(y);
    }

    public static char[] reverse(String x) {
        char[] letters = new char[x.length()];
        char[] letters_reversed = new char[x.length()];
        for (int i = 0; i < x.length(); i++) {
            letters[i] = x.charAt(i);
        }
        int j = 0;
        for (int i = x.length() - 1; i > -1; i--) {
            letters_reversed[j] = letters[i];
            j += 1;
        }
        return letters_reversed;
    }

    public static int Tribonacci(int x) {
        int[] y = new int[x];
        y[2] = 1;
        for (int i = 3; i < x; i++) {
            y[i] = y[i - 3] + y[i - 2] + y[i - 1];
        }
        return y[x - 1];
    }

    public static StringBuilder pseudoHash(int x) {
        String characters = "abcdef0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < x; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomString.append(randomChar);
        }
        return randomString;
    }

    public static String botHelper(String x) {
        String string = x.toLowerCase();
        string = string.replaceAll("\\p{Punct}", "");
        String[] parts = string.split(" ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("help")) {
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";
    }

    public static boolean isAnagram(String x, String y) {
        String string_x = x.replaceAll(" ", "");
        String string_y = y.replaceAll(" ", "");
        char[] letters_x = string_x.toCharArray();
        char[] letters_y = string_y.toCharArray();
        Arrays.sort(letters_x);
        Arrays.sort(letters_y);
        string_x = Arrays.toString(letters_x);
        string_y = Arrays.toString(letters_y);
        return string_x.equals(string_y);
    }
}
