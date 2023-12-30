import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------1");
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));

        System.out.println("----------2");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));

        System.out.println("----------3");
        int[] numbers1 = {1, 3, 5, 4, 5};
        int[] numbers2 = {1, 8, 1, 1, 1};
        int[] numbers3 = {1, 2, 2, 1, 1};
        System.out.println(doesBlockFit(numbers1));
        System.out.println(doesBlockFit(numbers2));
        System.out.println(doesBlockFit(numbers3));

        System.out.println("----------4");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));

        System.out.println("----------5");
        int[] numbers4 = {1, -3, 2};
        int[] numbers5 = {2, 5, 2};
        int[] numbers6 = {1, -6, 9};
        System.out.println(countRoots(numbers4));
        System.out.println(countRoots(numbers5));
        System.out.println(countRoots(numbers6));


        System.out.println("----------6");
        String[][] first_array = {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        };
        String[][] second_array = {
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        };
        System.out.println(salesData(first_array));
        System.out.println(salesData(second_array));

        System.out.println("----------7");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));

        System.out.println("----------8");
        int[] numbers7 = {3, 3, 4, 2, 7, 5};
        int[] numbers8 = {1, 2, 1, 4, 5};
        int[] numbers9 = {1, 2, -6, 10, 3};
        System.out.println(waveForm(numbers7));
        System.out.println(waveForm(numbers8));
        System.out.println(waveForm(numbers9));

        System.out.println("----------9");
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));

        System.out.println("----------10");
        int[][] third_array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        };
        int[][] fourth_array = {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        };
        System.out.println(Arrays.deepToString(dataScience(third_array)));
        System.out.println(Arrays.deepToString(dataScience(fourth_array)));
    }

    public static String replaceVovels(String original_string) {
        return original_string.replaceAll("[AEIOUaeiou]", "*");
    }

    public static String stringTransform(String original_string) {
        original_string += " ";
        String new_string = "";
        for (int i = 0; i < original_string.length() - 1; i++) {
            if (original_string.charAt(i) == original_string.charAt(i + 1)) {
                new_string = new_string + "Double" + Character.toUpperCase(original_string.charAt(i));
                i++;
            } else {
                new_string = new_string + original_string.charAt(i);
            }
        }
        return new_string;
    }

    public static boolean doesBlockFit(int[] x) {
        int[] block = new int[] {x[0], x[1], x[2]};
        int[] hole = new int[] {x[3], x[4]};
        Arrays.sort(block);
        Arrays.sort(hole);
        return block[0] <= hole[0] & block[1] <= hole[1];
    }

    public static boolean numCheck(int number) {
        String x = String.valueOf(number);
        int new_number = 0;
        for (int i = 0; i < x.length(); i++) {
            new_number += (int) Math.pow(Character.getNumericValue(x.charAt(i)), 2);
        }
        return number % 2 == new_number % 2;
    }

    public static int countRoots(int[] numbers) {
        int count = 0;
        int D = (int) (Math.pow(numbers[1], 2) - 4 * numbers[0] * numbers[2]);
        float x1 = (float) ((-numbers[1] + Math.pow(D, 0.5)) / (2 * numbers[0]));
        float x2 = (float) ((-numbers[1] - Math.pow(D, 0.5)) / (2 * numbers[0]));
        if (D < 0) {
            return 0;
        }else if (D == 0 & x1 % 1 == 0) {
            return 1;
        } else if (D == 0 & x1 % 1 != 0){
            return 0;
        }

        if (x1 % 1 == 0) {
            count += 1;
        }
        if (x2 % 1 == 0) {
            count += 1;
        }
        return count;
    }

    public static ArrayList<String> salesData(String[][] double_array) {
        int maks_array = 0;
        ArrayList<String> new_array = new ArrayList<>();
        for (String[] strings : double_array) {
            if (strings.length > maks_array) {
                maks_array = strings.length;
            }
        }
        for (String[] strings : double_array) {
            if (strings.length == maks_array) {
                new_array.add(strings[0]);
            }
        }
        return new_array;
    }

    public static boolean validSplit(String orgignal_string) {
        String[] words = orgignal_string.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public static boolean waveForm(int[] num) {
        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] > num[i + 1] & num[i + 1] > num[i + 2]) {
                return false;
            }
            if (num[i] < num[i + 1] & num[i + 1] < num[i + 2]) {
                return false;
            }
            if (num[i] == num[i+1] | num[i + 1] == num[i + 2]) {
                return false;
            }
        }
        return true;
    }

    public static char commonVovel(String sentence) {
        int[] counter = new int[5];
        String chars = "aeiou";
        sentence = sentence.toLowerCase();
        for (int i = 0; i < sentence.length(); i++) {
            if (chars.contains(String.valueOf(sentence.charAt(i)))) {
                counter[chars.indexOf(sentence.charAt(i))] += 1;
            }
        }

        int max_index = 0;
        for (int i = 1; i < 5; i++) {
            if (counter[i] > counter[max_index]) {
                max_index = i;
            }
        }
        return chars.charAt(max_index);
    }

    public static int[][] dataScience(int[][] d_arr) {
        int[] sum_arr = new int[d_arr.length];
        for (int i = 0; i < d_arr.length; i++) {
            for (int j = 0; j < d_arr[i].length; j++) {
                if (i != j) {
                    sum_arr[i] += d_arr[j][i];
                }
            }
            sum_arr[i] = (int) Math.round((double) sum_arr[i] / (d_arr.length - 1));
            d_arr[i][i] = sum_arr[i];
        }
        return d_arr;
    }
}
