import greenfoot.*;

/**
 * Write a description of class Plank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plank extends Mover
{
    public Plank()
    {
        this.velocity=-3;
    }

    /**
     * Act - do whatever the Plank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveRight();
        setRotation(150);
        World world=getWorld();
        if(getX()==3)
        {
            world.addObject(new Plank(),900,370);
        }  

    }
}