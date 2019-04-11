import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Converter converter = new JPGConverter();
        try{
            converter.convert(new File("C:\\Users\\Loren\\Pictures\\BingImageOfTheDay.jpg"));
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
    }
}
