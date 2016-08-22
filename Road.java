import greenfoot.*;

/**
 * Write a description of class road here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Road extends Mover
{
    public Road()
    {this.velocity=-3;
    }
    public void act() 
    {
       moveRight();
        World world=getWorld();
        if(getX()==300)
        {world.addObject(new Road(),900,400);
        }
    }    
}
