import greenfoot.*;

/**
 * Write a description of class mover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mover extends Animal
{
    protected int velocity;
    protected void moveRight()
    {
        setLocation (getX()+velocity,getY());

    }
}
