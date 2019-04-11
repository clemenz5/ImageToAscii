import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

class PNGConverter implements  Converter{
    private BufferedImage image;
    final String BLACK = ".";
    final String WHITE = " ";

    PNGConverter() {

    }

    public void convert(File file) throws IOException, IllegalArgumentException {
        if(!file.getPath().endsWith("png")){
            throw new IllegalArgumentException();
        }
        image = ImageIO.read(file);

        if(imageIsBW()){
            int[] intarr = new int[image.getWidth() * image.getHeight()];
            ImagePrinter.print(((image.getData().getPixels(0, 0, image.getWidth(), image.getHeight(), intarr))), 5, BLACK, WHITE, image.getWidth());
        }else{
            int[] intarr = new int[image.getWidth() * image.getHeight() * 4];
            ImagePrinter.print(convertToBW((image.getData().getPixels(0, 0, image.getWidth(), image.getHeight(), intarr))), 500, WHITE, BLACK, image.getWidth());
        }
    }

    public int[] convertToBW(int[] colorArr) {
        int[] bwArr = new int[image.getWidth() * image.getHeight()];
        int bwArrPointer = 0;
        int sum = 0;
        for (int f = 0; f < colorArr.length; f++) { //walk through the colorArr and add every 4 values
            sum = sum + colorArr[f];
            if(((f+1)%4)==0){
                bwArr[bwArrPointer] = sum;
                sum =0;
                bwArrPointer ++;
            }
        }
        System.out.println(bwArr.length);
        return bwArr;
    }



    private void simplePrint(int[] pixelArr){
        for(int i:pixelArr){
            System.out.println(i);
        }
    }

    private boolean imageIsBW(){
        try {
            System.out.println(image.getColorModel().getBlue(0));
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
