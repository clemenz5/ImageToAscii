public class ImagePrinter {
    public static void print(int[] pixelArray, int threshold, String color1, String color2, int width) {
        for (int i = 0; i < pixelArray.length; i++) {
            if (pixelArray[0] > threshold && i == 0) {
                System.out.print(color1);
            } else if (pixelArray[0] < threshold && i == 0) {
                System.out.print(color2);


            } else if (pixelArray[i] > threshold && (i %width) == 0) {
                System.out.print(color1);
                System.out.print("\n");
            } else if (pixelArray[i] > threshold && !((i % width) == 0)) {
                System.out.print(color1);
            } else if (pixelArray[i] < threshold && (i % width) == 0) {
                System.out.print(color2);
                System.out.print("\n");
            } else if (pixelArray[i] < threshold && !((i % width) == 0)) {
                System.out.print(color2);
            }
        }
    }
}
