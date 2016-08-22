import greenfoot.*;

/**
 * Write a description of class city here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class City extends World
{
    private Counter counter;
    /**
     * Constructor for objects of class city.
     * 
     */
    public City()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1,false); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Background(),303,200);
        addObject(new Road(),303,400);
        addObject(new Plank(),900,370);
        addObject(new Bike(),303,370);
        addObject(new Coins(),400,350);
        addObject(new Coins(),400,380);
        addObject(new Coins(),430,350);
        addObject(new Coins(),430,380);
        addObject(new Fireballs(),450,200);
        addObject(new Instructions(), 300,200);
        counter = new Counter();
        addObject(counter,50,20);
        
        setPaintOrder(Counter.class,Score.class,GameOver.class,Instructions.class,Bike.class,Road.class,Plank.class,Fireballs.class,Coins.class,Background.class);
    }
    
    public void addScoreOnRotation()
    {
        counter.updateOnRotation();
    }
    
    public void addScoreOnCoins()
    {
        counter.updateOnCoins();
    }
}
