import mayflower.*;

public class MazeGravityActor extends Actor {
    public MazeGravityActor() {
    }
    
    public void act() {  
        int fallSpeed = 3;
        setLocation(getX(), getY() + fallSpeed);
        for (int i = 0; i < fallSpeed; i++) {
            if (isBlocked()) {
                setLocation(getX(), getY() - 1);
            }
        }
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