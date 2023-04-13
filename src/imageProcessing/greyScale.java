package imageProcessing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class greyScale
{
  public static void main(String args[])throws IOException
  {
    BufferedImage image = null;
    File file = null;
    try
    {
      file = new File("D:\\KHUSHBOO\\JAVA\\imageProcessing\\src\\pictures\\pic.jpg");
      image = ImageIO.read(file);
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
    int width = image.getWidth();
    int height = image.getHeight();
    for (int y = 0; y < height; y++)
    {
      for (int x = 0; x < width; x++)
      {
        int p = image.getRGB(x,y);
        int a = (p>>24) & 0xff;
        int r = (p>>16) & 0xff;
        int g = (p>>8) & 0xff;
        int b = p & 0xff;
        int avg = (r+g+b)/3;
        p = (a<<24) | (avg<<16) | (avg<<8) | avg;
        image.setRGB(x, y, p);
      }
    }
    try
    {
      file = new File("D:\\\\KHUSHBOO\\\\JAVA\\\\imageProcessing\\\\src\\\\pictures\\\\greyScale1.png");
      ImageIO.write(image, "png", file);
      System.out.println("Converted the image to grey scale");
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
  }
}
