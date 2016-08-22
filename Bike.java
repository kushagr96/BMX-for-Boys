import greenfoot.*;

/**
 * Write a description of class bike here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bike extends Mover
{  
    private int gravity;
    boolean dragging = false;
    int yCoordinateUp = 271;
    int yCoordinateDown = 249;
    int delay=0;
    int count=0;

    public Bike()
    {
        this.velocity=4;
    }    

    public void act() 
    { 
        eatCoins();
        if(count==0)
        {
            checkForJump();
            land();
            
        }
        else    
            count--;
        checkPlank();
        jump();
        addScore();
        checkDelay();
        checkLanding();
    }

    private void eatCoins()
    {
        Actor coin = getOneIntersectingObject(Coins.class);
        if(coin!=null)
        {   
            eat(Coins.class); 
            Greenfoot.playSound("coin.wav");
            City city = (City) getWorld();
            city.addScoreOnCoins();
        }
    }

    private void checkForJump()
    {
        Actor road = getOneIntersectingObject(Road.class);
        if (Greenfoot.getKey()=="space" && road != null)
        {
            gravity = 15;
            Greenfoot.playSound("Jump.wav");
        }
    }

    private void land()
    {
        Actor plank = getOneIntersectingObject(Plank.class);
        if(plank == null)
        {

            gravity--;
            int y=getY()-gravity;
            if(y<=370)
            {
                setLocation(getX(),y);
            }
            else     setLocation(getX(),370);
            checkKeyJump();
            addScoreJump();
        }
        else
        {
            count=200;
        }
    }

    private void checkPlank()
    {
        Actor plank = getOneIntersectingObject(Plank.class);
        if(plank != null)
        {
            removeInstructions();
            setRotation(330);
            setLocation(getX(),getY()-2);
        }

    }

    private void removeInstructions()
    {
        World world = getWorld();
        world.removeObjects(world.getObjects(Instructions.class));
    }

    private void jump()
    {

        if((getY()==yCoordinateUp || getY()==yCoordinateUp-1)&& yCoordinateUp>=250)
        {
            setLocation(getX(),yCoordinateUp-1);
            checkKey();
            yCoordinateUp--;
        }
        else if(getY()==yCoordinateDown && yCoordinateDown<=371)
        {
            setLocation(getX(),yCoordinateDown+1);
            checkKey();
            yCoordinateDown++;
            checkLanding();
        }
        else
        {
            yCoordinateUp = 271;
            yCoordinateDown = 249;
        }

    }

    private void checkKey()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-7);
        }

        if(Greenfoot.isKeyDown("right"))
        {
            turn(7);
        }
    }
    
    private void checkKeyJump()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-17);
        }

        if(Greenfoot.isKeyDown("right"))
        {
            turn(17);
        }
    }

    private void checkLanding()
    {
        Actor road = getOneIntersectingObject(Road.class);
        if( road != null)
        {
            int rotation = getRotation();
            if (rotation <= 80 || rotation >= 280)
            {
                setRotation(0);
            }
            else
            {
                setRotation(181);

                World world = getWorld();
                world.addObject(new GameOver(),300,200);
                Greenfoot.stop();
            }

        }
    }

    public void addScore()
    {
        if(getRotation()<=180 && getRotation()>=164)
        {
            World world = getWorld();
            world.addObject(new Score(),300, 200);
            delay=10;
            City city = (City) getWorld();
            city.addScoreOnRotation();
        }
    }
    
    public void addScoreJump()
    {
        if(getRotation()<=180 && getRotation()>=174)
        {
            World world = getWorld();
            world.addObject(new Score(),300, 200);
            delay=10;
            City city = (City) getWorld();
            city.addScoreOnRotation();
        }
    }

    private void checkDelay()
    {
        if(delay==0)
        {
            World world = getWorld();
            world.removeObjects(world.getObjects(Score.class));
        }
        else    delay--;
    }
}
