package imageProcessing;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class green
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
        int g = (p>>16) & 0xff;     
        p = (a<<24) | (0<<16) | (g<<8) | 0; 
        image.setRGB(x, y, p);
      }
    }
    try
    {
      file = new File("D:\\KHUSHBOO\\JAVA\\imageProcessing\\src\\pictures\\green1.jpeg");
      System.out.println("SConverted the image to a green");
      ImageIO.write(image, "jpeg", file);
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
  }
}

