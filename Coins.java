import greenfoot.*;

/**
 * Write a description of class coins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coins extends Actor
{
    /**
     * Act - do whatever the coins wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-3);
        int x=Greenfoot.getRandomNumber(10000);
        if(x<=10)
        {
            World world2=getWorld();
            world2.addObject(new Coins(),600-Greenfoot.getRandomNumber(200),400-Greenfoot.getRandomNumber(200));
        }
    }
        
        
            
            
        
            
            
            
        
    }

