import java.util.ArrayList;
import java.util.regex.*;


public class IPCheck {
    public static void main(String[] args) {
        String ip = "110.12.12.266";

        Pattern correctPatern = Pattern.compile("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$");
        Matcher correctMatcher = correctPatern.matcher(ip);

        if (correctMatcher.matches()) {
            System.out.println(IpCheck(correctMatcher.group()));
        } else {
            System.out.println("IP введен неккоректо");
        }

    }

    public static String IpCheck(String str) {
        ArrayList<Integer> arr = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1) {
                temp += String.valueOf(str.charAt(i));
                arr.add(Integer.parseInt(temp));
            }
            if (!String.valueOf(str.charAt(i)).equals(".")) {
                temp += String.valueOf(str.charAt(i));
            } else {
                arr.add(Integer.parseInt(temp));
                temp = "";
            }
        }

        for (int element : arr) {
            if (element >= 255) {
                return "IP введен неккоректно";
            }
        }
        return "IP введен успешно";
    }
}
