public class ArrayAverage {
    public static void main(String[] args) {
        //String[] arr = {"1", "wrong", "2", "3", "4"};
        String[] arr = {"1", "2", "3", "4"};

        try
        {
            int sum = 0;
            for (int i = 0; i <= arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
            }
            float avg = (float) sum / arr.length;
            System.out.println(avg);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.err.println("Выход за границы");
        }
        catch (NumberFormatException e)
        {
            System.err.println("Неверно введены данные");
        }
    }
}
