import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("good_file.txt");

            FileWriter writer = new FileWriter("2.txt");

            int character;
            while ((character = reader.read()) != -1) {
                char charValue = (char) character;
                System.out.println(charValue);
                writer.write(character);
            }

            reader.close();
            writer.close();

            System.out.println("Файл успешно скопирован.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}