import mayflower.*;

public class WinWorld extends World {
    public WinWorld() {
        setBackground("img/BG/kitchen.png");
        InventoryBackground bowl = new InventoryBackground("img/Object/bowl.png");
        addObject(bowl, 175, 200);
    }

    public void act() {
    
    }
}
