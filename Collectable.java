import mayflower.*;

public class Collectable extends Actor {
    private String id;
    
    public Collectable(String file, int scale) {
        id = file;
        MayflowerImage item = new MayflowerImage(file);
        item.scale(scale, scale);
        setImage(item);
    }

    public void act() {
        // if touching any of the maincharacters add to inventory and remove
        if (isTouching(MainCharacter.class) || isTouching(MazeMainCharacter.class) || isTouching(FarmMainCharacter.class)) {
            Inventory.addItem(id);
            getWorld().removeObject(this);
        }
    }
}