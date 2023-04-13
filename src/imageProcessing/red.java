package imageProcessing;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class red
{
  public static void main(String args[])throws IOException
  {
    BufferedImage image = null;
    File file = null;
    try
    {
      file = new File("D:\\KHUSHBOO\\JAVA\\imageProcessing\\src\\pictures\\original.jpg");
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
        p = (a<<24) | (r<<16) | (0<<8) | 0; 
        image.setRGB(x, y, p);
      }
    }
    try
    {
      file = new File("D:\\KHUSHBOO\\JAVA\\imageProcessing\\src\\pictures\\red1.jpeg");
      System.out.println("SConverted the image to a red image");
      ImageIO.write(image, "jpeg", file);
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
  }
}
