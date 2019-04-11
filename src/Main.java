import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Converter converter;
    static Scanner scanner;
    public static void main(String[] args){
        scanner = new Scanner(System.in);

        do {
            System.out.println("please give your png or jpg");
            String path = scanner.nextLine();
            if (path.endsWith("jpg")) {
                converter = new JPGConverter();
            } else if (path.endsWith("png")) {
                converter = new PNGConverter();
            } else if (path.equals("exit")) {
                System.exit(0);
            } else {
                System.out.println("invalid input");
            }
            try {
                converter.convert(new File(path));
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }while (true);
    }
}
