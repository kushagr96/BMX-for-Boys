import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private int score;
   
    public Counter() 
    {
        score=0;
        setImage(new GreenfootImage(200,30));
        update();
    }    
    
    public void updateOnRotation()
    {
        score+=100;
        update();
    }
    
    public void updateOnCoins()
    {
        score+=5;
        update();
    }
    
    public void update()
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setColor(Color.BLACK);
        img.drawString("Score:"+score,100,20);
    }
}
