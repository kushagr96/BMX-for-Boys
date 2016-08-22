import greenfoot.*;

/**
 * Write a description of class background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Mover
{
    public Background()
    {
        this.velocity=-3;
    }

    public void act() 
    {
        moveRight();
        World world=getWorld();
        if(getX()==300)
        {
            world.addObject(new Background(),900,200);
        }
        
    }  

}
