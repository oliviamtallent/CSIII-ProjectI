import mayflower.*;

public class GravityActor extends Actor {
    private boolean isJumping;
    private String direction;
    private int jumpStartX; // normalize x to 0
    private int jumpStartY;
    private int x;
    private int yGoal;
    private int y;
    private int ARC = 10; // vertex of jump
    private int a;
    private boolean offTop;
    private int prevY = 0;
    
    public GravityActor() {
    }
    
    public void act() {  
        if (isJumping) {
            if (y == yGoal) {
                // if jump has full arc (not vertically constrained)
                if (a == 0)
                    yGoal = (x * x) - (ARC * x);
                else {
                    yGoal = (x * x) - (2 * a * x) - (a * (ARC - (2 * a)));  
                }
                System.out.println(y + " " + yGoal);
                
                // increment x
                int moveX = 0;
                if (direction == "left")
                    moveX = -1;
                else
                    moveX = 1;
                
                setLocation(getX() + moveX, y + jumpStartY);
                
                if (direction == "left")
                   x--;
                else
                   x++;
                   
                if(getBlockedDirection() == Direction.Down && x != 0 && prevY != 0) {
                    System.out.println(x);
                    isJumping = false;
                }
                prevY = y;
            } else {
                if (y < yGoal)
                    y++;
                else
                    y--;
                setLocation(getX(), y + jumpStartY);
            }
        } else {
            int fallSpeed = 3;
            setLocation(getX(), getY() + fallSpeed);
            for (int i = 0; i < fallSpeed; i++) {
                if (isBlocked()) {
                    setLocation(getX(), getY() - 1);
                }
            }
        }
        /*
        if (isBlockedTop(prevY, y) && a == 0) {
            a = x;
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
        if (!isBlockedTop(prevY, y) && a != 0) {
            offTop = true;
        }*/
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
        jumpStartX = getX();
        jumpStartY = getY();
        a = 0;
        offTop = false;
        prevY = 0;
        yGoal = 0;
        y = 0;
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
            
            if ((x * x) - (ARC * x) < ((x+diff) * (x+diff)) - (ARC * (x + diff))) 
                return false;
        }
        
        return isJumping;
    }
    
    public Direction getBlockedDirection() {
        setLocation(getX(), getY() - 1);
        if (!isBlocked()) {
            setLocation(getX(), getY() + 1);
            return Direction.Down;
        }
        return Direction.Left;
    }
}