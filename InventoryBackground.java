import mayflower.*;

public class InventoryBackground extends Actor {
    private boolean isButton;
    
    public InventoryBackground() {
        MayflowerImage block = new MayflowerImage("img/Tiles/inventory_bg.png");
        setImage(block);
    }
    
    public InventoryBackground(String file) {
        MayflowerImage block = new MayflowerImage(file);
        setImage(block);
    }
    
    public InventoryBackground(String file, int scale, boolean isButton) {
        MayflowerImage block = new MayflowerImage(file);
        block.scale(scale, scale);
        setImage(block);
        this.isButton = isButton;
    }
    
    public InventoryBackground(String file, int x, int y, int w, int h) {
        MayflowerImage block = new MayflowerImage(file);
        block.crop(x, y, w, h);
        setImage(block);
    }
    
    public void act() {
    }
    
    public boolean isButton() {
        return isButton;
    }
}