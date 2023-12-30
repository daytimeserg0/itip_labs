public class Main {
    public static void main(String[] args) {
        System.out.println("----------1");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println("----------2");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println("----------3");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println("----------4");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        System.out.println("----------5");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        System.out.println("----------6");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));

        System.out.println("----------7");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println("----------8");
        System.out.println(qcd(48, 18));
        System.out.println(qcd(52, 8));
        System.out.println(qcd(259, 28));

        System.out.println("----------9");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println("----------10");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }

    public static double convert(int x) {
        return x * 3.785;
    }

    public static int fitCalc(int x, int y) {
        if (y >= 1 && y <= 3) {
            return x * y;
        } else {
            System.out.print("Значение (y) должно быть в диапазоне от 1 до ");
            return 3;
        }
    }

    public static int containers(int x, int y, int z) {
        return x * 20 + y * 50 + z * 100;
    }

    public static String triangleType(int x, int y, int z) {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "not a triangle";
        } else if (x == y && x == z) {
            return "isosceles";
        } else if (x == y || x == z || y == z) {
            return "equilateral";
        } else {
            return "different-sided";
        }
    }

    public static int ternaryEvaluation(int x, int y) {
        return (x > y) ? x : y;
    }

    public static int howManyItems(int x, double y, double z) {
        return (int) (x / (2 * y * z));
    }

    public static int factorial(int x) {
         int k = 1;
        for (int i = 1; i <= x; i++) {
            k *= i;
        }
        return k;
    }

    public static int qcd(int x, int y) {
        while (x != 0 && y != 0) {
            if (x > y) {
                x = x % y;
            } else {
                y = y % x;
            }
        }
        return x + y;
    }

    public static int ticketSaler(int x, int y) {
        return (int) (x * (y - y * 0.28));
    }

    public static int tables(float x, float y) {
        if (x > y * 2) {
            return (int) Math.ceil((x - (y * 2)) / 2);
        } else {
            return 0;
        }
    }
}