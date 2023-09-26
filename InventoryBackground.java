import mayflower.*;

public class InventoryBackground extends Actor {
    public InventoryBackground() {
        MayflowerImage block = new MayflowerImage("img/Tiles/inventory_bg.png");
        setImage(block);
    }
    
    public InventoryBackground(String file) {
        MayflowerImage block = new MayflowerImage(file);
        setImage(block);
    }
    
    public InventoryBackground(String file, int x, int y, int w, int h) {
        MayflowerImage block = new MayflowerImage(file);
        block.crop(x, y, w, h);
        setImage(block);
    }
    
    public void act() {
    }
}