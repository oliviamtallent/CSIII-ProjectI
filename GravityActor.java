import mayflower.*;

public class GravityActor extends Actor {
    private boolean isJumping;
    private String direction;
    private int jumpStartX; // normalize x to 0
    private int jumpStartY;
    private int x;
    private int ARC = 30; // vertex
    private int a;
    private boolean offTop;
    private int prevY = 0;
    
    public GravityActor() {
    }
    
    public void act() {  
        if (isJumping) {
            int y;
            
            // if jump has not been cut short
            if (a == 0)
                y = (x * x) - (ARC * x); // x^2 - 30x
            else {
                y = (x * x) - (2 * a * x) - (a * (ARC - (2 * a)));  
                // x^2 - 2(cutoff)x - cutoff(30 - 2(cutoff))
            }
            
            // direction x increment/decrement
            int moveX = 0;
            if (direction == "left")
                moveX = -1;
            else
                moveX = 1;
            
            // set x and y to next plot point
            setLocation(getX() + moveX, y + jumpStartY);
            
            if (isBlockedTop(prevY, y) && a == 0) {
                // blocked above and not already cutoff, set cutoff
                a = x;
                
                // if jump arc already occurred stop jump and fall
                if (a > 30)
                    isJumping = false;
            } else if (isBlocked()) {
                if (a == 0 || offTop) {
                    while (isBlocked()) {
                        setLocation(getX(), getY() - 1);
                    }
                    isJumping = false;
                    a = 0;
                    prevY = 0;
                }
            }
            
            // no longer hitting top barrier
            if (!isBlockedTop(prevY, y) && a != 0) {
                offTop = true;
            }
            
            // increment/decrement x according to direction
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
    
    public boolean isBlockedTop(int y1, int y2) {
        if (isBlocked()) {
            setLocation(getX(), getY() - Math.abs(y1 - y2));
            if (isBlocked()) {
                setLocation(getX(), getY() + Math.abs(y1 - y2));
                return true;
            }
            setLocation(getX(), getY() + Math.abs(y1 - y2));
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
        offTop = false;
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