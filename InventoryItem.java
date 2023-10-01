import mayflower.*;

public class InventoryItem extends Actor {
    private boolean isWinScreen;
    private boolean isFollowing;
    private int offsetX;
    private int offsetY;
    private String file;
    
    public InventoryItem(String file) {
        this.file = file;
        MayflowerImage item = new MayflowerImage(file);
        item.scale(35, 35);
        setImage(item);
    }
    
    public InventoryItem(String file, int scale) {
        isWinScreen = true;
        this.file = file;
        MayflowerImage item = new MayflowerImage(file);
        item.scale(scale, scale);
        setImage(item);
    }
    
    public void act() {
        // follow mouse if on win screen and isfollowing
        if (isWinScreen && isFollowing) {
            MouseInfo mInfo = Mayflower.getMouseInfo();
            setLocation(mInfo.getX() + offsetX, mInfo.getY() + offsetY);
        }
    }
    
    public void setIsFollowing(boolean follow) {
        isFollowing = follow;
        if (isFollowing == true) {
            MouseInfo mInfo = Mayflower.getMouseInfo();
            offsetX = getX() - mInfo.getX();
            offsetY = getY() - mInfo.getY();
        } else {
            // if touching the bowl and mouse not clicked drop into bowl
            if (isTouching(InventoryBackground.class)) {
                WinWorld w = (WinWorld) getWorld();
                w.addToBowl(file);
                w.removeObject(this);
            }
        }
    }
}
