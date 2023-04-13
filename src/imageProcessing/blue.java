package imageProcessing;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class blue
{
  public static void main(String args[])throws IOException
  {
    BufferedImage image = null;
    File file = null;
    try
    {
      file = new File("D:\\KHUSHBOO\\JAVA\\imageProcessing\\src\\pictures\\khushboo.jpeg");
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
        int b = (p>>16) & 0xff;     //to change to red color: 
        p = (a<<24) | (0<<16) | (0<<8) | b;    //set the value of red and set g and b as 0
                      //r          g     b
        image.setRGB(x, y, p);
      }
    }
    try
    {
      file = new File("D:\\KHUSHBOO\\JAVA\\imageProcessing\\src\\pictures\\blue.jpeg");
      System.out.println("Converted the image to a blue image");
      ImageIO.write(image, "jpeg", file);
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
  }
}

