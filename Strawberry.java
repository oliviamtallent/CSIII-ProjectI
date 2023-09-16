import mayflower.*;
public class Strawberry extends Actor
{
     public Strawberry() 
    {
        setImage("img/Object/strawberryCopy.jpg");
    }
    
    public void act() 
    {
    	if(isTouching(Cat.class))
        {
        	World world = getWorld();
        	world.removeObject(this);
        }
    }
}
