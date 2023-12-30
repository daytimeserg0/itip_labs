import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------1");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println("----------2");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("H2", "A4"));


        System.out.println("----------3");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount( 1289396387328L));

        System.out.println("----------4");
        String[] words_1 = {"cat", "create", "sat"};
        String[] words_2 = {"trance", "recant"};
        String[] words_3 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println(totalPoints(words_1, "caster"));
        System.out.println(totalPoints(words_2, "recant"));
        System.out.println(totalPoints(words_3, "tossed"));

        System.out.println("----------5");
        int[] nums_1 = {1, 2, 3, 4, 5};
        int[] nums_2 = {1, 2, 3, 7, 9};
        int[] nums_3 = {10, 9, 7, 2, 8};
        int[] nums_4 = {1, 6, 5, 4, 8, 2, 3, 7};
        System.out.println(Arrays.deepToString(sumsUp(nums_1)));
        System.out.println(Arrays.deepToString(sumsUp(nums_2)));
        System.out.println(Arrays.deepToString(sumsUp(nums_3)));
        System.out.println(Arrays.deepToString(sumsUp(nums_4)));

        System.out.println("----------6");
        String[] marks_1 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        String[] marks_2 = {"10%"};
        String[] marks_3 = {"53%", "79%"};
        System.out.println(takeDownAverage(marks_1));
        System.out.println(takeDownAverage(marks_2));
        System.out.println(takeDownAverage(marks_3));

        System.out.println("----------7");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "epqswx pewx xewo!", 4));

        System.out.println("----------8");
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));

        System.out.println("----------9");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println("----------10");
        System.out.println(isNew(30));
        System.out.println(isNew(201));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }

    //1-----------------------------------------------------------------------------------------------------------------
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            str1 = str1.replaceAll(String.valueOf(str1.charAt(i)), String.valueOf(str2.charAt(i)).toLowerCase());
        }
        str1 = str1.toUpperCase();
        return str1.equals(str2);
    }



    //2-----------------------------------------------------------------------------------------------------------------
    public static String spiderVsFly(String spider, String fly) {
        int way1 = spider.charAt(1) - '0' + fly.charAt(1) - '0';
        Boolean changeFlag;
        String tempBegin;
        String tempEnd;
        if (spider.charAt(1) < fly.charAt(1)) {
            changeFlag = true;
            tempBegin = fly;
            tempEnd = spider;
        } else {
            changeFlag = false;
            tempBegin = spider;
            tempEnd = fly;
        }

        int way2radial = tempBegin.charAt(1) - tempEnd.charAt(1);
        int way2ring = Math.abs(tempBegin.charAt(0) - tempEnd.charAt(0));
        if (way2ring >= 5) {
            way2ring = 8 - way2ring;
        }

        // bc^2 = x^2 + x^2 - 2*x*x*cos(45)
        // bc^2 = 2*x^2 - 2*x^2*cos(45)
        // bc = x (2 - sqrt(2))^0.5
        double ratioForRing = Math.pow(2 - Math.pow(2, 0.5), 0.5);
        double distanceOnRing = ratioForRing * way2ring * (tempEnd.charAt(1) - '0');


        double way2 = way2radial + distanceOnRing;
        ArrayList<String> steps = new ArrayList<>();
        if (way1 < way2) {
            for (int i = spider.charAt(1) - '0'; i > 0; i--) {
                steps.add(String.valueOf(spider.charAt(0)) + String.valueOf(i));
            }
            steps.add("A0");

            for (int i = 1; i <= fly.charAt(1) - '0'; i++) {
                steps.add(String.valueOf(fly.charAt(0)) + String.valueOf(i));
            }
        } else {
            for (int i = tempBegin.charAt(1) - '0'; i >= tempEnd.charAt(1) - '0'; i--) {
                steps.add(String.valueOf(tempBegin.charAt(0)) + String.valueOf(i));
            }
            if ((tempBegin.charAt(0) - 'A') > (tempEnd.charAt(0) - 'A')) {
                for (int i = 1; i <= way2ring; i++) {
                    steps.add(String.valueOf((char) ((tempBegin.charAt(0) - 'A' + i) % 8 + 'A') + String.valueOf(tempEnd.charAt(1) - '0')));
                }
            } else {
                for (int i = 1; i <= way2ring; i++) {
                    steps.add(String.valueOf((char) ((tempBegin.charAt(0) - 'A' - i + 8) % 8 + 'A') + String.valueOf(tempEnd.charAt(1) - '0')));
                }
            }
        }

        if (changeFlag & way1 > way2) {
            steps = reverseArray(steps);
        }
        return String.join("-", steps);
    }

    public static ArrayList<String> reverseArray(ArrayList<String> arr) {
        ArrayList<String> reversed = new ArrayList<>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            reversed.add(arr.get(i));
        }
        return reversed;
    }


    //3-----------------------------------------------------------------------------------------------------------------
    public static int digitsCount(long num){
        if (num == 0) {
            return 1;
        }
        return digitsCounter(num, 0);
    }

    public static int digitsCounter(long num, int count){
        if (num == 0){
            return count;
        }

        num = num / 10;
        count += 1;
        return digitsCounter(num, count);
    }


    //4-----------------------------------------------------------------------------------------------------------------
    public static int totalPoints(String[] words, String tar_word){
        String temp_str;
        int points = 0;
        boolean win = false;

        for (String element : words) {
            if (element.equals(tar_word)) {
                win = true;
                break;
            }
        }

        for (String element : words) {
            boolean flag = true;
            temp_str = tar_word;
            for (int i = 0; i < element.length(); i++) {
                if (temp_str.contains(String.valueOf(element.charAt(i)))) {
                    temp_str = temp_str.replaceFirst(String.valueOf(element.charAt(i)), "");
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (element.length() == 3) {
                    points += 1;
                } else if (element.length() == 4) {
                    points += 2;
                } else if (element.length() == 5) {
                    points += 3;
                } else if (element.length() == 6 & !win) {
                    points += 4;
                } else if (element.length() == 6 & win) {
                    points += 54;
                }
            }
        }
        return points;
    }

    //5-----------------------------------------------------------------------------------------------------------------
    public static int[][] sumsUp(int[] nums) {
        int[][] combs = new int[0][];
        ArrayList<Integer> inds = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((i != j) && ((nums[i] + nums[j]) == 8)) {
                    if (nums[i] > nums[j]) {
                        inds = addToInd(Math.abs(j - i), inds, combs, new int[]{nums[j], nums[i], Math.abs(j - i)});
                        combs = addToArr(combs, new int[]{nums[j], nums[i], Math.abs(j - i)});       //1, 6, 5, 4, 8, 2, 3, 7
                    } else {
                        inds = addToInd(Math.abs(j - i), inds, combs, new int[]{nums[i], nums[j], Math.abs(j - i)});
                        combs = addToArr(combs, new int[]{nums[i], nums[j], Math.abs(j - i)});
                    }
                }
            }
        }

        int[][] final_combs = new int[combs.length][];
        for (int i = 0; i < inds.size(); i++) {
            for (int[] pair : combs) {
                if (inds.get(i) == pair[2]) {
                    final_combs[i] = (new int[]{pair[0], pair[1]});
                    pair[2] = -1;
                    break;
                }
            }
        }

        return final_combs;
    }

    public static int[][] addToArr(int[][] arr, int[] pair) {
        for (int[] element : arr) {
            if (Arrays.equals(element, pair)) {
                return arr;
            }
        }

        int[][] new_arr = new int[arr.length + 1][];
        System.arraycopy(arr, 0, new_arr, 0, arr.length);
        new_arr[arr.length] = pair;
        return new_arr;
    }

    public static ArrayList<Integer> addToInd(int ind, ArrayList<Integer> inds, int[][] arr, int[] pair) {
        for (int[] element : arr) {
            if (Arrays.equals(element, pair)) {
                return inds;
            }
        }

        inds.add(ind);
        Collections.sort(inds);
        return inds;
    }

    //6-----------------------------------------------------------------------------------------------------------------
    public static String takeDownAverage(String[] marks) {
        int sum = 0;
        for (String element : marks) {
            sum += Integer.parseInt(String.valueOf(element.charAt(0)) + String.valueOf(element.charAt(1)));
        }
        double avg = ((double) sum / marks.length) - 5;
        double x = avg * (marks.length + 1) - sum;
        return (int) x + "%";
    }

    //7-----------------------------------------------------------------------------------------------------------------
    public static String caesarCipher(String func, String string, int moves) {
        String new_str = "";
        string = string.toLowerCase();
        if (func.equals("encode")) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) >= 97 & string.charAt(i) <= 122) {
                    new_str += (char) (string.charAt(i) + moves);
                } else {
                    new_str += string.charAt(i);
                }
            }
        } else if (func.equals("decode")) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) >= 97 & string.charAt(i) <= 122) {
                    new_str += (char) (string.charAt(i) - moves);
                } else {
                    new_str += string.charAt(i);
                }
            }
        }
        return new_str.toUpperCase();
    }

    //8-----------------------------------------------------------------------------------------------------------------
    public static int setSetup(int n, int k) {
        return factorial(n) / factorial (n - k);
    }

    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
    //9-----------------------------------------------------------------------------------------------------------------
    public static String timeDifference(String first_city, String date, String second_city) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        date = date.replace(",", "");
        String[] dates = date.split(" ");

        Map<String, Double> cities = new HashMap<>();
        cities.put("Los Angeles", - 8.0);
        cities.put("New York", - 5.0);
        cities.put("Caracas", - 4.5);
        cities.put("Buenos Aires", - 3.0);
        cities.put("London", 0.0);
        cities.put("Rome", 1.0);
        cities.put("Moscow", 3.0);
        cities.put("Tehran", 3.5);
        cities.put("New Delhi", 5.5);
        cities.put("Beijing", 8.0);
        cities.put("Canberra", 10.0);

        double time_diff = Math.abs(cities.get(first_city) - cities.get(second_city));
        int minutes = Integer.parseInt(String.valueOf(dates[3].charAt(3)) + String.valueOf(dates[3].charAt(4)));
        int hours = Integer.parseInt(String.valueOf(dates[3].charAt(0)) + String.valueOf(dates[3].charAt(1))) + (int)time_diff;
        int day = Integer.parseInt(dates[1]);
        int month = Arrays.asList(months).indexOf(dates[0]) + 1;
        int year = Integer.parseInt(dates[2]);
        if (minutes >= 30 & time_diff % 1 != 0) {
            minutes -= 30;
            hours += 1;
        }
        if (hours >= 24) {
            hours -= 24;
            day += 1;
        }
        if ((day == 29 & month == 2 & year % 4 != 0) || (day == 30 & month == 2 & year % 4 == 0)
                || (day == 31 & (month == 4 || month == 6 || month == 9 || month == 11))
                || (day == 32 & (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12))) {
            day = 1;
            month += 1;
        }
        if (month == 13) {
            month = 1;
            year += 1;
        }

        String time = "";
        if (hours <= 9) {
            time += "0" + hours;
        } else {
            time += hours;
        }
        if (minutes <= 9) {
            time += ":0" + minutes;
        } else {
            time += ":" + minutes;
        }

        return year + "-" + month + "-" + day + " " + time;
    }

    //10-----------------------------------------------------------------------------------------------------------------
    public static boolean isNew(int num){
        Boolean flag = true;
        String num_str = String.valueOf(num);
        if (num_str.length() == 1) {
            return true;
        }
        for (int i = 0; i < num_str.length(); i++) {
            if (i == num_str.length() - 1) {
                break;
            }
            for (int j = 0; j < num_str.length(); j++) {
                if (i < j & i != 0) {
                    if (Integer.parseInt(String.valueOf(num_str.charAt(i))) > Integer.parseInt(String.valueOf(num_str.charAt(j)))) {
                        flag = false;
                    }
                }

                if (i < j & i == 0) {
                    if (Integer.parseInt(String.valueOf(num_str.charAt(i))) > Integer.parseInt(String.valueOf(num_str.charAt(j)))
                            & !String.valueOf(num_str.charAt(j)).equals("0")) {
                        flag = false;
                    }
                }

            }
        }
        return flag;
    }
}



