public class Palindrome {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
           String s1 = args[i];
           String s2 = reverseString(s1);
           System.out.println(args[i] + ": " + isPalindrome(s1, s2));
        }
    }
    public static String reverseString(String s) {
        String reversed_string = "";
        for (int i = s.length() - 1; i > - 1; i--) {
            reversed_string = reversed_string + s.charAt(i);
        }
        return reversed_string;
    }

    public static boolean isPalindrome(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        return false;
    }
}

