import mayflower.*;

public class GravityActor extends Actor {
    private boolean isJumping;
    private String direction;
    private int jumpStartX; // normalize x to start location
    private int jumpStartY; // normalize y to start location
    private int x;
    private int ARC = 30; // vertex
    private int a;
    private int prevY = 0;
    private boolean freeze;
    
    public GravityActor() {
    }
    
    public void act() {
        outer: if (isJumping) {
            int y;
            
            // set y based on current x or cut off
            if (a == 0)
                y = (x * x) - (ARC * x); // x^2 - 30x
            else 
                y = (x * x) - (2 * a * x) - (a * (ARC - (2 * a)));
            
            // direction x increment/decrement
            int moveX = 0;
            if (direction == "left")
                moveX = -1;
            else
                moveX = 1;
                
            int diff = y - prevY;
            for (int i = 0; i < Math.abs(diff); i++) {
                // if past vertex or not (<0 --> before vertex)
                if (diff < 0) {
                    setLocation(getX(), getY() - 1);
                    if (isBlocked()) {
                        setLocation(getX(), getY() + 1);
                        
                        // if x is unchanged before being blocked --> fall
                        if (direction == "left" && x > 30 || 
                            direction == "right" && x <= 1) {
                            isJumping = false;
                            break outer;
                        }
                        
                        // set break point to cut arc
                        a = x - moveX;
                        break outer;
                    }
                } else if (diff > 0) {
                    // increase y and make sure it isn't blocked underneath
                    setLocation(getX(), getY() + 1);
                    if (isBlocked()) {
                        setLocation(getX(), getY() - 1);
                        isJumping = false;
                        break outer;
                    }
                }
            }
            
            // move X and make sure it hasn't been blocked
            setLocation(getX() + moveX, getY());
            if (isBlocked()) {
                setLocation(getX() - moveX, getY());
                isJumping = false;
            }
            
            if (direction == "left")
               x--;
            else
               x++;
            prevY = y;
        } else {
            // fall
            int fallSpeed = 3;
            setLocation(getX(), getY() + fallSpeed);
            for (int i = 0; i < fallSpeed; i++) {
                if (isBlocked()) {
                    setLocation(getX(), getY() - 1);
                }
            }
        }
    }
    
    public boolean isBlocked() {
        if (isTouching(Block.class)) {
            return true;
        }
        
        return false;
    }
    
    public void startJump(String direction) {
        this.direction = direction;
        if (direction == "left")
            x = ARC;
        else
            x = 0;
        
        // reset all jump values
        jumpStartX = getX();
        jumpStartY = getY();
        a = 0;
        prevY = 0;
        isJumping = true;
    }
    
    public boolean isFalling() {
        if (isJumping())
            return false;
        setLocation(getX(), getY() + 1);
        if (isBlocked()) {
            setLocation(getX(), getY() - 1);
            return false;
        }
        setLocation(getX(), getY() - 1);
        return true;
    }
    
    public boolean isJumping() {
        if (isJumping) {
            int diff = direction == "left" ? -1 : 1;
            
            // check if the arc is increasing or decreasing
            if ((x * x) - (ARC * x) < ((x+diff) * (x+diff)) - (ARC * (x + diff))) 
                return false;
        }
        
        return isJumping;
    }
}