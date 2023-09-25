import mayflower.*;

public class Level2World extends World
{

    public Level2World()
    {
        setBackground("img/BG/farm.png");
        InventoryBackground invBg = new InventoryBackground();
        addObject(invBg, 0, 0);
    }
    
    public void act() {
        
    }
}