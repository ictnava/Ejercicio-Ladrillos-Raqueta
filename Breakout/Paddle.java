import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 * A paddle is a rectangular object that can be moved via the left
 * and right arrow keys.  
 * 
 * @author Barbara Ericson, Georgia Tech
 * @version 1.0 April 6, 2007
 */
public class Paddle extends Actor
{
    /////////////// fields ////////////////////
  
    /** Width of the paddle */
    private int width = 60;
  
    /** Height of the paddle */
    private int height = 10;
    
    /** amount to move */
    private int moveAmount = 5;
    
    /** color of this paddle */
    private Color color = Color.BLACK;
    
    ///////////// constructors ///////////////////////////
  
    /**
     * No argument constructor 
     */
    public Paddle()
    {
        updateImage();
    }
    
    /**
     * Constructor that takes the width, height, color, and moveAmount
     * @param theWidth the width to use
     * @param theHeight the height to use
     * @param theColor the color to use
     * @param theAmount the number of cells (pixels) to move
     */
    public Paddle(int theWidth, int theHeight, 
                  Color theColor, int theAmount)
    {
        width = theWidth;
        height = theHeight;
        color = theColor;
        moveAmount = theAmount;
        updateImage();
    }
    
    ///////////////////// Methods ///////////////////////////////

    /**
     * Act - a paddle will move in reaction to a left or right
     * arrow key being pressed
     */
    public void act() 
    {
        muevete();
    }
    
    public void muevete()
    {
        BreakoutWorld mundo = (BreakoutWorld)getWorld();
   
        if(this.getX()+width/2<mundo.getWidth()){
          if(Greenfoot.isKeyDown("right")){
            move(moveAmount);
         }
        }
        if(this.getX()-width/2>0){
          if(Greenfoot.isKeyDown("left")){
            move(-moveAmount);
            }
        }
     }
    
    /**
     * Method to create and set the image for this paddle.  Invoke
     * this method again when the width, height, or color change.
     */
    public void updateImage()
    {
        GreenfootImage image = new GreenfootImage(width,height);
        image.setColor(color);
        image.fillRect(0,0,width,height);
        setImage(image);
    }
}
