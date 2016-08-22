import greenfoot.*;

/**
 * Write a description of class fireballs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireballs extends Actor
{
    /**
     * Act - do whatever the fireballs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         move(-3);
        int y=Greenfoot.getRandomNumber(20000);
        if(y<=20)
        {
            World world3=getWorld();
            world3.addObject(new Fireballs(),600-Greenfoot.getRandomNumber(200),300-Greenfoot.getRandomNumber(200));
        }
        if(isTouching(Bike.class))
        {
            World world = getWorld();
            world.addObject(new GameOver(),300,200);
            Greenfoot.stop();
        }
    }    
}
