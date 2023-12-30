import java.util.regex.*;

public class PasswordCheck {
    public static void main(String[] args) {
        String pass = "prigskok1A";

        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[\\w]{8,16}$");
        Matcher matcher = pattern.matcher(pass);

        if (matcher.matches()) {
            System.out.println("Пароль введен корректно.");
        } else {
            System.err.println("Пароль не соответствует требованиям.");
        }
    }
}

