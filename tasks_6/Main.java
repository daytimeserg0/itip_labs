import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------1");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        System.out.println("----------2");
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));

        System.out.println("----------3");
        System.out.println("\"" + nicoCipher("myworldevolvesinhers", "tesh") + "\"");
        System.out.println("\"" + nicoCipher("andiloveherso", "tesha") + "\"");
        System.out.println("\"" + nicoCipher("mubashirhassan", "crazy") + "\"");
        System.out.println("\"" + nicoCipher("edabitisamazing", "matt") + "\"");
        System.out.println("\"" + nicoCipher("iloveher", "612345") + "\"");

        System.out.println("----------4");
        int[] nums1 = {1, 2, 3, 9, 4, 5, 15};
        int[] nums2 = {1, 2, 3, 9, 4, 15, 3, 5};
        int[] nums3 = {1,  2, -1,  4,  5,  6,  10, 7};
        int[] nums4 = {1, 2, 3, 4, 5,  6, 7, 8, 9, 10};
        int[] nums5 = {100, 12, 4, 1, 2};
        System.out.println(twoProduct(nums1, 45));
        System.out.println(twoProduct(nums2, 45));
        System.out.println(twoProduct(nums3, 20));
        System.out.println(twoProduct(nums4, 10));
        System.out.println(twoProduct(nums5, 15));

        System.out.println("----------5");
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));

        System.out.println("----------6");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println("----------7");
        System.out.println(PiString("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        System.out.println(PiString("33314444"));
        System.out.println(PiString("TOP"));
        System.out.println(PiString("X"));
        System.out.println(PiString("CANIMAKEAGUESSNOW"));

        System.out.println("----------8");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));

        System.out.println("----------9");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        System.out.println("----------10");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
    }

    //1-----------------------------------------------------------------------------------------------------------------1//
    public static String hiddenAnagram(String text, String anagram) {
        text = deleteSpace(text);
        anagram = deleteSpace(anagram);
        String tempText;

        for (int i = 0; i < text.length() - anagram.length() + 1; i++) {
            tempText = text.substring(i, i + anagram.length());
            if (isAnagram(tempText, anagram)) {
                return tempText;
            }
        }
        return "not found";
    }

    public static String deleteSpace(String str) {
        String newString = "";
        Pattern pattern = Pattern.compile("[A-z]+");
        Matcher matcher = pattern.matcher(str.toLowerCase());
        while (matcher.find()) {
            newString += matcher.group();
        }
        return newString;
    }

    public static boolean isAnagram(String string_x, String string_y) {
        char[] letters_x = string_x.toCharArray();
        char[] letters_y = string_y.toCharArray();
        Arrays.sort(letters_x);
        Arrays.sort(letters_y);
        string_x = Arrays.toString(letters_x);
        string_y = Arrays.toString(letters_y);
        return string_x.equals(string_y);
    }
    //2-----------------------------------------------------------------------------------------------------------------2//
    public static String[] collect(String word, int cut) {
        ArrayList<String> words = new ArrayList<>();
        words = collectWords(word, cut, words);
        String[] finalWords = new String[words.size()];

        for (int i = 0; i < words.size(); i++) {
            finalWords[i] = words.get(i);
        }

        Arrays.sort(finalWords);
        return finalWords;
    }

    public static ArrayList<String> collectWords(String str, int cut, ArrayList<String> words) {
        if (str.length() < cut) {
            return words;
        }
        words.add(str.substring(0, cut));
        str = str.substring(cut);
        words = collectWords(str, cut, words);
        return words;
    }
    //3-----------------------------------------------------------------------------------------------------------------3//
    public static String nicoCipher(String message, String key) {
        ArrayList<String> words = new ArrayList<>();
        char[] keyLetters = key.toCharArray();
        Arrays.sort(keyLetters);
        String cipherKey = key;
        for (int i = 1; i < key.length() + 1; i++) {
            cipherKey = cipherKey.replaceFirst(String.valueOf(keyLetters[i - 1]), String.valueOf(i));
        }

        String cipherMessage = "";
        words = splitWord(message, key.length(), words);
        for (String element : words) {
            for (int i = 1; i < key.length() + 1; i++) {
                cipherMessage += element.charAt(cipherKey.indexOf(String.valueOf(i)));
            }
        }
        return cipherMessage;
    }

    public static ArrayList<String> splitWord(String str, int cut, ArrayList<String> words) {
        if (str.length() < cut) {
            for (int i = str.length(); i < cut; i++) {
                str += " ";
            }
            words.add(str);
            return words;
        }
        words.add(str.substring(0, cut));
        str = str.substring(cut);
        if (!str.isEmpty()) {
            words = splitWord(str, cut, words);
        }
        return words;
    }
    //4-----------------------------------------------------------------------------------------------------------------4//
    public static String twoProduct(int[] nums, int n) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] * nums[j] == n) {
                    return Arrays.toString(new int[]{nums[j], nums[i]});
                }
            }
        }
        return Arrays.toString(new int[]{});
    }
    //5-----------------------------------------------------------------------------------------------------------------5//
    public static int[] isExact(int n) {
        if (n == 1) {
            return new int[]{1, 1};
        }
        int factorial = 1;
        int multiplier = 1;
        int[] nums = isBorderOfFactorial(n, factorial, multiplier);
        return nums;
    }

    public static int[] isBorderOfFactorial(int n, int factorial, int multiplier) {
        if (n == factorial) {
            return new int[]{n, multiplier - 1};
        }
        if (n < factorial) {
            return new int[]{};
        }
        return isBorderOfFactorial(n, multiplier * factorial, multiplier + 1);
    }
    //6-----------------------------------------------------------------------------------------------------------------6//
    public static String fractions(String decimal) {
        String nonRepeatingPart = decimal.substring(decimal.indexOf(".") + 1, decimal.indexOf("("));
        String repeatingPart = decimal.substring(decimal.indexOf("(") + 1, decimal.length() - 1);

        int numerator;
        if (nonRepeatingPart.isEmpty()) {
            numerator = Integer.parseInt(repeatingPart);
        } else {
            numerator = Integer.parseInt(nonRepeatingPart + repeatingPart) - Integer.parseInt(nonRepeatingPart);
        }

        String strDenominator = "";
        for (int i = 0; i < repeatingPart.length(); i++) {
            strDenominator += "9";
        }
        for (int i = 0; i < nonRepeatingPart.length(); i++) {
            strDenominator += "0";
        }

        int denominator = Integer.parseInt(strDenominator);

        int gcd = findGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        numerator = Integer.parseInt(decimal.substring(0, decimal.indexOf("."))) * denominator + numerator;

        return numerator + "/" + denominator;
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }
    //7-----------------------------------------------------------------------------------------------------------------7//
    public static String PiString(String originStr) {
        String pi = "314159265358979";
        ArrayList<String> words = new ArrayList<>();
        return makePiString(originStr, pi, words);
    }

    public static String makePiString(String originStr, String pi, ArrayList<String> words) {
        if (originStr.isEmpty() || pi.isEmpty()) {
            return String.join(" ", words);
        }
        if (originStr.length() < pi.charAt(0) - '0') {
            for (int i = originStr.length(); i < pi.charAt(0) - '0'; i++) {
                originStr += originStr.charAt(originStr.length() - 1);
            }
            words.add(originStr);
            return String.join(" ", words);
        }

        int wordLen = pi.charAt(0) - '0';
        words.add(originStr.substring(0, wordLen));
        return makePiString(originStr.substring(wordLen), pi.substring(1), words);
    }
    //8-----------------------------------------------------------------------------------------------------------------8//
    public static String generateNonconsecutive(String equation) {
        if (equation.contains("(")) {
            equation = eqInBrackets(equation);
        }

        String[] sym = equation.split(" ");
        if (sym.length == 1) {
            return equation;
        }
        int multiInd = equation.length();
        if (equation.contains(" * ")) {
            multiInd = equation.indexOf("*");
        }
        int divInd = equation.length();
        if (equation.contains(" / ")) {
            divInd = equation.indexOf("/");
        }
        int plusInd = equation.length();
        if (equation.contains(" + ")) {
            plusInd = equation.indexOf("+");
        }
        int minusInd = equation.length();
        if (equation.contains(" - ")) {
            minusInd = equation.indexOf("- ");
        }


        String result;
        try {
            if (equation.contains(" * ") || equation.contains(" / ")) {
                if (multiInd < divInd) {
                    for (int i = 0; i < sym.length; i++) {
                        if (sym[i].equals("*")) {
                            result = String.valueOf(Integer.parseInt(sym[i - 1]) * Integer.parseInt(sym[i + 1]));
                            equation = equation.replace(sym[i - 1] + " * " + sym[i + 1], result);
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < sym.length; i++) {
                        if (sym[i].equals("/")) {
                            if (sym[i + 1].equals("0")) {
                                return "Делить на ноль нельзя!";
                            }
                            result = String.valueOf(Integer.parseInt(sym[i - 1]) / Integer.parseInt(sym[i + 1]));
                            equation = equation.replace(sym[i - 1] + " / " + sym[i + 1], result);
                            break;
                        }
                    }
                }
            } else if (equation.contains(" + ") || equation.contains(" - ")) {
                if (plusInd < minusInd) {
                    for (int i = 0; i < sym.length; i++) {
                        if (sym[i].equals("+")) {
                            result = String.valueOf(Integer.parseInt(sym[i - 1]) + Integer.parseInt(sym[i + 1]));
                            equation = equation.replace(sym[i - 1] + " + " + sym[i + 1], result);
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < sym.length; i++) {
                        if (sym[i].equals("-")) {
                            result = String.valueOf(Integer.parseInt(sym[i - 1]) - Integer.parseInt(sym[i + 1]));
                            equation = equation.replace(sym[i - 1] + " - " + sym[i + 1], result);
                            break;
                        }
                    }
                }
            } else {
                return "Уравнение введено неккоректно!";
            }
        } catch (Exception e) {
            return "Уравнение введено неккоректно!";
        }
        return generateNonconsecutive(equation);
    }

    public static String eqInBrackets(String equation) {
        int openBracketCount = 0;
        int openBracket = equation.indexOf("(");
        int closeBracket = 0;
        for (int i = openBracket + 1; i < equation.length(); i++) {
            if (equation.charAt(i) == '(') {
                openBracketCount += 1;
            } else if (equation.charAt(i) == ')') {
                if (openBracketCount == 0) {
                    closeBracket = i;
                    break;
                } else {
                    openBracketCount -= 1;
                }
            }
        }

        try {
            String bracketsEq = equation.substring(openBracket + 1, closeBracket);
            equation = equation.replace(equation.substring(openBracket, closeBracket + 1), generateNonconsecutive(bracketsEq));
            if (equation.contains("(")) {
                equation = eqInBrackets(equation);
            }
        } catch (Exception e) {
            return "Уарвниние введено нккоректно!";
        }
        return equation;
    }
    //9-----------------------------------------------------------------------------------------------------------------9//
    public static String isValid(String orStr) {
        HashMap<Character, Integer> symCounter = new HashMap<>();
        for (int i = 0; i < orStr.length(); i++) {
            symCounter.put(orStr.charAt(i), symCounter.getOrDefault(orStr.charAt(i), 0) + 1);
        }

        int mostFreqElem = findMostFreqElem(symCounter);
        if (mostFreqElem == 0) {
            return "YES";
        }
        int except = 0;

        for (int value : symCounter.values()) {
            if (value != mostFreqElem) {
                if ((value - 1 == mostFreqElem) || value == 1) {
                    except += 1;
                } else {
                    return "NO";
                }
            }
        }

        if (except > 1) {
            return "NO";
        }
        return "YES";
    }

    public static int findMostFreqElem(HashMap<Character, Integer> map) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int element : map.values()) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        int mostFrequentElement = 0;
        int maxFrequency = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentElement = entry.getKey();
            }
        }
        if (frequencyMap.size() == 2 & maxFrequency == 1) {
            return 0;
        }

        return mostFrequentElement;
    }
    //10----------------------------------------------------------------------------------------------------------------10//
    public static String findLCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] F = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    F[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    F[i][j] = F[i - 1][j - 1] + 1;
                } else {
                    F[i][j] = Math.max(F[i - 1][j], F[i][j - 1]);
                }
            }
        }
        //for (int i = 0; i < F.length; i++) {
        //    System.out.println(Arrays.toString(F[i]));
        //}

        int index = F[m][n];
        char[] lcs = new char[index];
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                index--;
                lcs[index] = str1.charAt(i - 1);
                i--;
                j--;
            } else if (F[i - 1][j] > F[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return new String(lcs);
    }
}



