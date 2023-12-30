import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------1");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));

        System.out.println("----------2"); //????????????????????????????????????
        String[] array1 = generateBracket(1).toArray(new String[generateBracket(1).size()]);
        String[] array2 = generateBracket(2).toArray(new String[generateBracket(2).size()]);
        String[] array3 = generateBracket(3).toArray(new String[generateBracket(3).size()]);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));

        System.out.println("----------3");//????????????????????????????????????
        String[] array4 = binarySystem(3).toArray(new String[binarySystem(3).size()]);
        String[] array5 = binarySystem(4).toArray(new String[binarySystem(4).size()]);
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));

        System.out.println("----------4");
        System.out.println(alphabeticRow("aaaaa"));
        System.out.println(alphabeticRow("bcbcbcb"));

        System.out.println("----------5");
        System.out.println(charactersCounter("aaabbcdd"));
        System.out.println(charactersCounter("vvvvaajaaaaa"));

        System.out.println("----------6");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));

        System.out.println("----------7");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));

        System.out.println("----------8");//??????????????????????????????
        int[][] arr1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int[][] arr2 = {
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}
        };
        System.out.println(shortestWay(arr1));
        System.out.println(shortestWay(arr2));

        System.out.println("----------9");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("----------10");
        System.out.println(switchNums(7, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    //1-----------------------------------------------------------------------------------------------------------------
    public static String nonRepeatable(String orig_str) {
        orig_str = orig_str.toLowerCase();
        return stringOfNonRepeatable(orig_str, "");
    }


    public static String stringOfNonRepeatable(String orig_str, String new_str) {
        if (orig_str.isEmpty()) {
            return new_str;
        }

        new_str += orig_str.charAt(0);
        orig_str = orig_str.replace(String.valueOf(orig_str.charAt(0)), "");

        return stringOfNonRepeatable(orig_str, new_str);
    }

    //2-----------------------------------------------------------------------------------------------------------------
    public static ArrayList<String> generateBracket(int n) {
        ArrayList<String> combinations = new ArrayList<>();
        generateCombinations("", n, n, combinations);
        return combinations;
    }

    private static void generateCombinations(String current, int open, int close, ArrayList<String> combinations) {
        if (open == 0 && close == 0) {
            combinations.add(current);
        }

        if (open > 0) {
            generateCombinations(current + "(", open - 1, close, combinations);
        }
        if (close > open) {
            generateCombinations(current + ")", open, close - 1, combinations);
        }
    }

    //3-----------------------------------------------------------------------------------------------------------------
    public static ArrayList<String> binarySystem(int n) {
        ArrayList<String> combinations = new ArrayList<>();
        generateCombinations("", n, combinations);
        return combinations;
    }

    private static void generateCombinations(String current, int n, ArrayList<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        generateCombinations(current + "1", n, result);

        // Если текущая последовательность не заканчивается нулем, добавляем "0" и рекурсивно вызываем функцию
        if (current.length() == 0 || current.charAt(current.length() - 1) != '0') {
            generateCombinations(current + "0", n, result);
        }
    }

    //4-----------------------------------------------------------------------------------------------------------------
    public static String alphabeticRow(String or_str) {
        or_str = or_str.toLowerCase();
        ArrayList<String> strings = new ArrayList<>();
        String incr_str = "";
        for (int i = 0; i < or_str.length(); i++) {
            if (i == or_str.length() - 1) {
                strings.add(incr_str + or_str.charAt(i));
                incr_str = "";
                break;
            }
            if (or_str.charAt(i) - or_str.charAt(i + 1) == -1) {
                incr_str += or_str.charAt(i);
            } else {
                strings.add(incr_str + or_str.charAt(i));
                incr_str = "";
            }
        }

        for (int i = 0; i < or_str.length(); i++) {
            if (i == or_str.length() - 1) {
                strings.add(incr_str + or_str.charAt(i));
                break;
            }
            if (or_str.charAt(i) - or_str.charAt(i + 1) == 1) {
                incr_str += or_str.charAt(i);
            } else {
                strings.add(incr_str + or_str.charAt(i));
                incr_str = "";
            }
        }
        return findMax(strings);
    }

    public static String findMax(ArrayList<String> strings) {
        String maxLengthString = strings.get(0);
        for (String str : strings) {
            if (str.length() > maxLengthString.length()) {
                maxLengthString = str;
            }
        }
        return maxLengthString;
    }

    //5-----------------------------------------------------------------------------------------------------------------
    public static String charactersCounter(String orig_str) {
        ArrayList<String> array = new ArrayList<>();
        ArrayList<String> ind_array = new ArrayList<>();
        return makingNewString(orig_str + " ", "", array, ind_array, "");
    }

    public static String makingNewString(String or_str, String temp_str, ArrayList<String> array, ArrayList<String> ind_array, String out_str) {
        for (int i = 0; i < or_str.length() - 1; i++) {
            if (or_str.charAt(i) == or_str.charAt(i + 1)) {
                temp_str += or_str.charAt(i);
            } else {
                array.add(or_str.charAt(i) + String.valueOf(temp_str.length() + 1));
                ind_array.add(String.valueOf(temp_str.length() + 1));
                temp_str = "";
            }
        }

        Collections.sort(ind_array);
        for (int i = 0; i < ind_array.size(); i++) {
            for (int j = 0; j < ind_array.size(); j++) {
                if (array.get(j).contains(ind_array.get(i))) {
                    out_str += array.get(j);
                    array.set(j, "-");
                }
            }
        }

        return out_str;
    }

    //6-----------------------------------------------------------------------------------------------------------------
    public static int convertToNum(String or_str) {
        String[] words = or_str.split(" ");
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred"};

        int out_num = 0;
        List<String> nums1 = Arrays.asList(nums);
        List<String> words1 = new ArrayList<>(Arrays.asList(words));
        List<String> tens1 = Arrays.asList(tens);


        for (String element : words1) {
            if (!nums1.contains(element) & !tens1.contains(element)) {
                return -1;
            }
        }

        if (or_str.contains("hundred") & nums1.contains(words1.get(0))) {
            out_num += nums1.indexOf(words1.get(0)) * 100;
            words1.remove(0);
            words1.remove(0);
            if (words1.isEmpty()) {
                return out_num;
            }
        }

        if (tens1.contains(words1.get(0))) {
            out_num += tens1.indexOf(words1.get(0)) * 10;
            words1.remove(0);
            if (words1.isEmpty()) {
                return out_num;
            }
        }

        if (nums1.contains(words1.get(0))) {
            out_num += nums1.indexOf(words1.get(0));
            words1.remove(0);
        }

        if (!words1.isEmpty()) {
            return -1;
        }

        return out_num;
    }

    //7-----------------------------------------------------------------------------------------------------------------
    public static String uniqueSubstring(String or_str) {
        String sub = "";
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < or_str.length(); i++) {
            if (!sub.contains(String.valueOf(or_str.charAt(i)))) {
                sub += or_str.charAt(i);
                res.add(sub);
            } else {
                int cut_index = sub.indexOf(or_str.charAt(i));
                sub = sub.substring(cut_index + 1) + or_str.charAt(i);
                res.add(sub);
            }
        }

        String longestString = res.get(0);
        int maxLength = res.get(0).length();
        for (String element : res) {
            int length = element.length();
            if (length > maxLength) {
                maxLength = length;
                longestString = element;
            }
        }
        return longestString;
    }

    //8-----------------------------------------------------------------------------------------------------------------
    public static int shortestWay(int[][] arr) {
        int len = arr[0].length;
        return findShortestWay(arr, 0, 0, len);
    }

    public static int findShortestWay(int[][] arr, int right, int down, int len) {
        if (right == len - 1 && down == len - 1) {
            return arr[down][right];
        }

        int rightSum = Integer.MAX_VALUE;
        int downSum = Integer.MAX_VALUE;

        if (right < len - 1) {
            rightSum = arr[down][right] + findShortestWay(arr, right + 1, down, len);
        }

        if (down < len - 1) {
            downSum = arr[down][right] + findShortestWay(arr, right, down + 1, len);
        }

        return Math.min(rightSum, downSum);
    }

    //9-----------------------------------------------------------------------------------------------------------------
    public static String numericOrder(String or_str) {
        String[] words = or_str.split(" ");
        String new_str = "";
        for (int i = 1; i < words.length + 1; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[j].contains(String.valueOf(i))) {
                    new_str += words[j].replace(String.valueOf(i), "") + " ";
                }
            }
        }
        return new_str;
    }

    //10-----------------------------------------------------------------------------------------------------------------
    public static String switchNums(int first_num, int second_num) {
        String first_str = String.valueOf(first_num);
        String second_str = String.valueOf(second_num);

        List<Integer> first_arr = new ArrayList<>();
        for (int i = 0; i < first_str.length(); i++) {
            first_arr.add(Integer.parseInt(String.valueOf(first_str.charAt(i))));
        }
        Collections.sort(first_arr);

        for (int i = 0; i < second_str.length(); i++) {
            if (!first_arr.isEmpty()) {
                if (first_arr.get(first_arr.size() - 1) > Integer.parseInt(String.valueOf(second_str.charAt(i)))) {
                    second_str = second_str.replaceFirst(String.valueOf(second_str.charAt(i)), String.valueOf(first_arr.get(first_arr.size() - 1)));
                    first_arr.remove(first_arr.size() - 1);
                }
            }
        }

        return second_str;
    }
}



