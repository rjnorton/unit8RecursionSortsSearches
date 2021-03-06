import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;

public class LogSpiralPanel extends JPanel
{
   private static final double GOLDEN_MEAN = (1 + Math.sqrt(5)) / 2;

   public void paintComponent(Graphics g)
   {
      /* Your code goes here.
         1. Compute the dimensions of the goldenRectangle (you can use getHeight() 
            to obtain the side size)
         2. Draw the golden rectangle
         3. Call the recursive helper method "recursiveDraw" which will draw 
            the spiral.
      */
      int height = this.getHeight();
      int width = this.getWidth();
      int side = 0;
      double triangleHeight = 0.0;
      double triangleWidth = 0.0;
      if(height < width)
      {
          if(width/GOLDEN_MEAN > height)
          {
              triangleHeight = (double) height;
              triangleWidth = (double) height * GOLDEN_MEAN;
              side = height;
          }
          
          else
          {
              while(width/GOLDEN_MEAN < height)
              {
                  height--;
              }
              triangleHeight = (double) height;
              triangleWidth = (double) height * GOLDEN_MEAN;
              side = height;
          }
      }
      
      else
      {
          if(height/GOLDEN_MEAN > width)
          {
              triangleHeight = (double) width;
              triangleWidth = (double) width * GOLDEN_MEAN;
              side = width;
          }
          
          else
          {
              while(height/GOLDEN_MEAN < width)
              {
                  width--;
              }
              triangleHeight = (double) width;
              triangleWidth = (double) width * GOLDEN_MEAN;
              side = width;
          }
      }
      
      g.drawRect(0,0,(int)triangleWidth,(int)triangleHeight);
      recursiveDraw(g,0,0,side,90);
   }
   
   /**
      Method that recursively draws a logarithmic spiral.
      @param x The x-coordinate of the golden rectangle's upper-left corner  
      @param y The y-coordinate of the golden rectangle's upper-left corner
      @param side the smallest side size of the golden rectangle
      @param angle the angle (0, 90, 180 or 270) where the top of the 
      golden rectangle is located. For the outermost golden rectangle, 
      the angle is 90.
   */
   private void recursiveDraw(Graphics g, double x, double y, double side, int angle)
   {
      //. . .
   }
   
   //. . .
}
