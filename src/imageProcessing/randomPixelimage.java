package imageProcessing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class randomPixelimage
{
  public static void main(String args[])throws IOException
  {
    int width = 640, height = 320;
    BufferedImage image = null;
    image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    File file = null;

    // create random values pixel by pixel
    for (int y = 0; y < height; y++)
    {
      for (int x = 0; x < width; x++)
      {
        //Generating values less than 250
        int a = (int)(Math.random()*255);
        int r = (int)(Math.random()*255);
        int g = (int)(Math.random()*255);
        int b = (int)(Math.random()*255);

        //Creating pixel
        int p = (a<<24) | (r<<16) | (g<<8) | b;
        image.setRGB(x, y, p);
      }
    }
    // write image
    try
    {
      file = new File("D:\\KHUSHBOO\\JAVA\\imageProcessing\\src\\pictures\\random.png");
      ImageIO.write(image, "png", file);
      System.out.println("Created a random pixel image!!");
    }
    catch(IOException e)
    {
      System.out.println("Error: " + e);
    }
  }
}
