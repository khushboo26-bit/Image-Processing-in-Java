package imageProcessing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class watermark
{
  public static void main(String[] args)
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
    BufferedImage temp = new BufferedImage(image.getWidth(), 													 
    image.getHeight(), BufferedImage.TYPE_INT_RGB);

    Graphics graphics = temp.getGraphics();

    graphics.drawImage(image, 0, 0, null);
    graphics.setFont(new Font("Lucida Console", Font.ITALIC, 300));
    graphics.setColor(new Color(220,0,0,40));
    String watermark = "khushboo watermark";
    graphics.drawString(watermark, image.getWidth()/5, image.getHeight()/3);
    graphics.dispose();

    file = new File("D:\\KHUSHBOO\\JAVA\\imageProcessing\\src\\pictures\\watermark1.png");
    try
    {
      ImageIO.write(temp, "png", file);
      System.out.println("Added watermark to the image!!");
    }
    catch (IOException e)
    {
      System.out.println(e);
    }
  }
}
