import mayflower.*;

public class MazeGravityActor extends Actor {
    private boolean isFrozen;
    
    public MazeGravityActor() {
    }
    
    public void act() {  
        // if not frozen by the enemy: fall
        if (!isFrozen) {
            int fallSpeed = 3;
            setLocation(getX(), getY() + fallSpeed);
            for (int i = 0; i < fallSpeed; i++) {
                if (isBlocked()) {
                    setLocation(getX(), getY() - 1);
                }
            }
        }
    }
    
    public void setFrozen(boolean isFrozen) {
        this.isFrozen = isFrozen;
    }
    
    public boolean isFrozen() {
        return isFrozen;
    }
    
    public boolean isBlocked() {
        if (isTouching(Block.class))
            return true;  
        else if (getX() < 32 || getX() > 800 - 64)
            return true;
        else if (getY() > 600 - 38) {
            // win the maze!
            return true;
        }
        return false;
    }
    
    public boolean isFalling() {
        setLocation(getX(), getY() + 1);
        if (isBlocked()) {
            setLocation(getX(), getY() - 1);
            return false;
        }
        setLocation(getX(), getY() - 1);
        return true;
    }
}