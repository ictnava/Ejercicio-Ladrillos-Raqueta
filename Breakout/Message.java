import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Font;
import java.awt.Color;
/**
 * The message class holds a text message 
 * 
 * @author Barbara Ericson, Georgia Tech
 * @version 1.0, April 6, 2007
 */
public class Message extends Actor
{
    /////////////// fieldds ////////////////////
    
    /** holds the text of the message */
    private String text;
    
    /** the width of the message area */
    private int width = 408;
    
    /** the height of the message area */
    private int height = BreakoutWorld.BRICK_Y_OFFSET - 10;

    
    ///////////// Conbtructors /////////////////
    
    /** 
     * Constructor that takes the text to display
     */
    public Message(String theText)
    {
        text = theText;
        updateImage();
    }
    
    /**
     * Constructor that takes the text to display, the width,
     * and the height
     * @param theText   the text to use
     * @param theWidth  the width to use
     * @param theHeight the height to use
     */
    public Message(String theText, int theWidth, int theHeight)
    {
        text = theText;
        width = theWidth;
        height = theHeight;
        updateImage();
    }
    
    ////////////////// methods ///////////////////////
    
    /**
     * Method to change the text in this message
     * @param theText the new text to usee
     */
    public void setText(String theText)
    { 
        text = theText;
        updateImage();
    }
    
    /** 
     * Messages don't do anything when asked to act
     */
    public void act() 
    {
    }

    /**
     * Method to create and set the image for this message
     * Invoke this method when the text changes, the width changes, and/or
     * the height changes
     */
    private void updateImage()
    {
        Font font = new Font("Helvetica",Font.BOLD,20);
        GreenfootImage image = new GreenfootImage(width,height);
        image.setFont(font);
        image.clear();
        image.setColor(Color.BLACK);
        image.drawString(text, 5, height / 2);
        setImage(image);
    }  
}
