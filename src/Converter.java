import java.io.File;
import java.io.IOException;

public interface Converter {
    void convert(File file) throws IOException, IllegalArgumentException;
    int[] convertToBW(int[] colorArr);
}
