import mayflower.*;

public class InventoryItem extends Actor {
    public InventoryItem(String file) {
        MayflowerImage item = new MayflowerImage(file);
        item.scale(35, 35);
        setImage(item);
    }
    
    public void act() {
    }
}
