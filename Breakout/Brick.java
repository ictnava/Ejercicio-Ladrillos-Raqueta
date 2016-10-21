import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 * A brick is a filled rectangle that doesn't do
 * anything when it gets the act message.
 * 
 * @author Barb Ericson, Georgia Tech
 * @version 1.0, April 6, 2007
 */
public class Brick extends Actor
{
    /** the width of the brick */
    private int width = 36;
  
    /** the height of the brick */
    private int height = 8;
  
    /** the color of the brick */
    private Color color;
  
    /////////// constructor ////////////////
  
    /**
     * Constructor that takes the color for the brick 
     * @param theColor the color to use for this brick
     */
    public Brick(Color theColor)
    {
      color = theColor;
      updateImage();
    }
  
    /**
     * Constructor that takes the width, height, and color for this 
     * brick.
     */
    public Brick(int theWidth, int theHeight, Color theColor)
    {
         width = theWidth;
         height = theHeight;
         color = theColor;
         updateImage();
    }
  
    ////////////// methods ///////////////////
    
    /**
     * Method to act during a time step 
     */
    public void act()
    {
    }
  
    /**
     * Method to create the image and set it for this brick.
     * If you change the width, height, or color invoke this
     * method.
     */
    public void updateImage()
    {
        GreenfootImage image = new GreenfootImage(width,height);
        image.setColor(this.color);
        image.fillRect(0,0,width,height);
        setImage(image);
    }
    
    public Color getColor(){ return color; }
}
