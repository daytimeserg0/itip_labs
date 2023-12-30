import java.io.*;
import java.time.LocalDateTime;

public class CustomUnsupportedOperationException extends Exception {
    public CustomUnsupportedOperationException(String message) {
        super(message);
    }
    public static double Operations(int firstNum, int secondNum, String operation) throws CustomUnsupportedOperationException {
        switch (operation) {
            case "+" -> {
                return firstNum + secondNum;
            }
            case "-" -> {
                return firstNum - secondNum;
            }
            case "*" -> {
                return firstNum * secondNum;
            }
            case "/" -> {
                if (secondNum != 0) {
                    return (double) firstNum / secondNum;
                } else {
                    throw new CustomUnsupportedOperationException("Деление на ноль!");
                }
            }
            default -> throw new CustomUnsupportedOperationException("Недопустимая операция: " + operation);
        }
    }


    public static void main(String[] args) throws IOException {
        try {
            System.out.println(Operations(1, 3, "*"));
        } catch (CustomUnsupportedOperationException e) {
            System.err.println(e.getMessage());
            FileWriter writer = new FileWriter("LogException.txt", true);
            writer.write(e.getMessage() + " " + LocalDateTime.now() + "\n");
            writer.close();
        }
    }
}