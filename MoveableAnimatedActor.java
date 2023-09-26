import mayflower.*;

public class MoveableAnimatedActor extends AnimatedActor {
    private Animation walkRight;
    private Animation idle;
    private Animation idleLeft;
    private Animation walkLeft;
    private Animation fall;
    private Animation fallLeft;
    private Animation jump;
    private Animation jumpLeft;
    private Animation climb;
    private Animation climbLeft;
    private String currentAction;
    private String direction;
    private int jumping;
    private boolean isJumping;
    private boolean upClicked;
    
    public MoveableAnimatedActor() {
        
    }
    
    public void act() {
        super.act();
        
        String newAction = null;
        String newDirection = null;
        
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        if (currentAction == null) {
           newAction = "idle";
        }
        
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x + w < 800) {
            newDirection = "right";
            newAction = "walkRight";
            setLocation(x + 2, y);
            while (isBlocked())
                setLocation(getX() - 1, y);
        } 
        if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0) {
            newDirection = "left";
            newAction = "walkLeft";
            setLocation(x - 2, y); 
            while (isBlocked())
                setLocation(getX() + 1, y);
        } 
        if (Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0 && !upClicked) {
            upClicked = true;
            startJump(direction);
        } 
        if (newAction == null) {
            if (!Mayflower.isKeyDown(Keyboard.KEY_UP)) {
                upClicked = false;
            }
            newAction = "idle";
        }
        
        if (isFalling()) {
            newAction = "fall";
        } else if (isJumping()) {
            newAction = "jump";
        } else if (isFalling() && isJumping) {
            isJumping = false;
        } else if (isClimbing()) {
            newAction = "climb";
        }
        
      
        /*
        else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y + h < 600)
            setLocation(x, y + 1); 
        */
       if (newAction != null && (newAction != currentAction || 
       (newDirection != null && newDirection != direction))) {
           if (newDirection != null)
                direction = newDirection;
           if (newAction == "walkRight") {
                setAnimation(walkRight);
                currentAction = "walkRight";
            } else if (newAction == "idle") { 
               if (direction != null && direction == "left")
                    setAnimation(idleLeft);
               else
                    setAnimation(idle);
                currentAction = "idle";
            } else if (newAction == "walkLeft") {
                setAnimation(walkLeft);
                currentAction = "walkLeft";
            } else if (newAction == "fall") {
               if (direction != null && direction == "left")
                    setAnimation(fallLeft);
               else
                    setAnimation(fall);
                currentAction = "fall";
            } else if (newAction == "jump") {
               if (direction != null && direction == "left")
                    setAnimation(jumpLeft);
               else
                    setAnimation(jump);
                currentAction = "jump";
            } else if (newAction == "climb") {
                if (direction != null && direction == "left")
                    setAnimation(climbLeft);
                else
                    setAnimation(climb);
            }
        }
    }
    
    public void setAnimation(Animation a) {
        super.setAnimation(a);
    }
    
    public void setWalkRightAnimation(Animation a) {
        walkRight = a;
    }
    
    public void setIdleAnimation(Animation a) {
        idle = a;
    }
    
    public void setIdleLeftAnimation(Animation a) {
        idleLeft = a;
    }
    
    public void setWalkLeftAnimation(Animation a) {
        walkLeft = a;
    }
    
    public void setFallAnimation(Animation a) {
        fall = a;
    }
    
    public void setFallLeftAnimation(Animation a) {
        fallLeft = a;
    }
    
    public void setJumpAnimation(Animation a) {
        jump = a;
    }
    
    public void setJumpLeftAnimation(Animation a) {
        jumpLeft = a;
    }
    
    public void setClimbAnimation(Animation a) {
        climb = a;
    }
    
    public void setClimbLeftAnimation(Animation a) {
        climbLeft = a;
    }
}
    
