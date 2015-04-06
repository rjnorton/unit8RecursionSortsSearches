import java.awt.*;
import javax.swing.JPanel;

public class FractalTreePanel extends JPanel
{
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 800;

    private final double SQ = Math.sqrt(3.0) / 6;

    private final int TOPX = 200, TOPY = 20;
    private final int LEFTX = 60, LEFTY = 300;
    private final int RIGHTX = 340, RIGHTY = 300;
    
    private int MAX;
    private int current;
    private double angleConst;
    private int scale;
    
    public FractalTreePanel(int currentOrder, int max, double angleChange, int lineScale)
    {
        current = currentOrder;
        MAX = 1;
        setBackground(Color.black);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        angleConst = angleChange;
        scale = lineScale;
    }

    public void drawFractal (int order, int x1, int y1, int x2, int y2,
                            Graphics page, double prevAngle)
   {
      if(order != MAX)
      {
         page.drawLine(x1, y1, x2, y2);
         
         int x3 = 0, y3 = 0, x4 = 0, y4 = 0;
         double currentAngle = angleConst + prevAngle;
         double len = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
         x3 = (int) (len*(Math.sin(currentAngle)));
         y3 = (int) (len*(Math.cos(currentAngle)));
         
         drawFractal(order+1, x2, y2, x2 - x3, y2 - y3, page, currentAngle);
         
         currentAngle = prevAngle - angleConst;
         x4 = (int) (len*(Math.sin(currentAngle)));
         y4 = (int) (len*(Math.cos(currentAngle)));
         
         drawFractal(order+1, x2, y2, x2 - x4, y2 - y4, page, currentAngle);
      }
      
      else if(order == MAX)
      {
         page.drawLine(x1, y1, x2, y2);
      }
   }
   
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);

      page.setColor (Color.green);

      drawFractal(1, PANEL_WIDTH/2, PANEL_HEIGHT/2,PANEL_WIDTH/2, (PANEL_HEIGHT/2)+30, page, 0);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
      MAX = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}
