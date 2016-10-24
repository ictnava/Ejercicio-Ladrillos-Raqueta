import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.util.List;

/**
 * Holds a game of breakout. In breakout there are 10 rows of bricks that the user
 * must get rid of to win.  To get rid of bricks hit them with the ball.  Use the paddle
 * to hit the ball.  Use the left and right arrow keys to move the paddle.  The user has
 * 3 balls to use to try to win the game and if the last ball gets past the paddle the user
 * loses.  
 * 
 * This game is based on Breakout by Eric Roberts who presented it as a nifty assignment 
 * at SIGCSE in 2006 using the Java Task Force libraries.
 * 
 * @author Barbara Ericson, Georgia Tech
 * @version 1.0, April 6, 2007
 */
public class BreakoutWorld extends World
{
   /////////////////// constants //////////////////////////
   
   /** the width of the bricks in pixels (cells) */
   public static final int BRICK_WIDTH = 36; 
   /** the height of the bricks in pixels (cells) */
   public static final int BRICK_HEIGHT = 8; 
   /** the distance between bricks in pixels (cells) */
   public static final int BRICK_SEP = 4;   
   /** the number of bricks per row */
   public static final int NUM_BRICKS_PER_ROW = 10; 
   /** distance from the top edge in pixels (cells) */
   public static final int BRICK_Y_OFFSET = 50;     
   /** the number of pixels per cell */
   public static final int RESOLUTION = 1;          
   /** world width in pixels (cells) */
   public static final int WIDTH = (BRICK_WIDTH + BRICK_SEP) * NUM_BRICKS_PER_ROW + BRICK_SEP; 
   /** world height in pixels (cells) */
   public static final int HEIGHT = 500;   
   /** number of rows of bricks */
   public static final int NUM_ROWS = 10;  
   /** the colors to use for each row of bricks */
   public static final Color[] colorArray = {Color.RED, Color.RED,
      Color.ORANGE, Color.ORANGE, Color.GREEN,Color.GREEN,
      Color.YELLOW,Color.YELLOW,  Color.CYAN, Color.CYAN};
          
   ////////////////// instance fields ///////////////////////////////
  
   /** the number of balls created in the game so far */
   private int numBalls = 0;
  
   /** a message displayed for the user */
   private Message message = null;
   //Contador para las vidas
   private Counter contVidas;
   //////////// constructors /////////////
  
   /**
    * No argument constructor 
    */
   public BreakoutWorld()
   {
        super (WIDTH, HEIGHT, RESOLUTION,false);
        addObject(contVidas=new Counter("Vidas: "),350,20);
        contVidas.setValue(3);
        setUpBreakout();
   }
  
   /////////////// methods ///////////////
  
   /**
    * Method to get the number of balls created 
    * @return the number of balls created in the game 
    */
   public int getNumBalls() { return numBalls; }
   
   public void decrementaVida(){
      contVidas.add(-1);    
   }
   /**
    * Method to add a new ball
    */
   public void newBall() 
   {
       /* increment the number of balls created */
      numBalls++;
      
      /* check if used 3 or more */
      if (numBalls > 3)
      {
          message.setText("Game over and you lost.");
          Greenfoot.stop();
      }
      /* create new ball and tell the user the number of balls created */
      else
      { 
          
         addObject(new Ball(), (WIDTH / 2), 222);
         message.setText("Ball " + numBalls);
      }
    }
  
    /**
     * Method to check if the game is over and if so tell the user
     * and stop the simulation
     */
    public void checkIfWon()
    {
        List brickList = this.getObjects(Brick.class);
        if (brickList.size() == 0)
        {
            message.setText("You Won!!!!!!");
            Greenfoot.stop();
        }
    }
  
    /**
     * Method to set up the breakout game
     */
    public void setUpBreakout()
    {
        /* update image */
        updateImage();
        
        /* set up the message */
        message = new Message("Game starting");
        addObject(message,WIDTH/2, 20);
    
        /* set up the bricks */
        setUpBricks();
    
        /* create the paddle */
        addObject(new Paddle(),(WIDTH / 2),HEIGHT - 30);
    
        /* create a new ball */
        newBall();
  
    }
  
    /*
     * Method to set up the bricks in the world 
     */
    private void setUpBricks()
    {
        int yPos = BRICK_HEIGHT / 2 + BRICK_Y_OFFSET;
        int halfWidth = BRICK_WIDTH / 2;

        // addObject(new Brick(Color.RED),4,0);
        for (int row = 0; row < NUM_ROWS; row++, 
             yPos = yPos + BRICK_HEIGHT + BRICK_SEP)
        {
            for (int col = 0, xPos = BRICK_SEP + halfWidth; col < NUM_BRICKS_PER_ROW; 
                 col++, xPos = xPos + BRICK_WIDTH + BRICK_SEP)
            {
                addObject(new Brick(colorArray[row]),xPos,yPos);
            }
        }
        
    }
    
    /**
     * Method to create and set the image for the background 
     */
    public void updateImage()
    {
        GreenfootImage image = new GreenfootImage(WIDTH,HEIGHT);
        image.setColor(new Color(200,200,200));
        image.fillRect(0,0,WIDTH,HEIGHT);
        setBackground(image);
    }
    
    public int getWidth()
    {
        return WIDTH;
    }
    
    public int getHeight()
    {
        return HEIGHT;
    }
    
   public void pierde(){
       if(contVidas.getValue()==0){
           Label etiquetaFin=new Label("Game Over",50);
          addObject(etiquetaFin,250,250);
          Greenfoot.stop();
        }
    }
}

