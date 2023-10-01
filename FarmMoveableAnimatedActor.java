import mayflower.*;

public class FarmMoveableAnimatedActor extends FarmAnimatedActor {
    private Animation walkRight;
    private Animation idle;
    private Animation idleLeft;
    private Animation walkLeft;
    private Animation fall;
    private Animation fallLeft;
    private Animation climb;
    private Animation climbLeft;
    private Animation slide;
    private Animation slideLeft;
    private String currentAction;
    private String direction;
    private int jumping;
    private boolean isJumping;
    private boolean upClicked;
    private boolean downClicked;
    
    public FarmMoveableAnimatedActor() {
        
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
        
        // if moving right
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x + w < 800) {
            newDirection = "right";
            newAction = "walkRight";
            setLocation(x + 2, y);
            while (isBlocked())
                setLocation(getX() - 1, y);
        } 
        
        // if moving left
        if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0) {
            newDirection = "left";
            newAction = "walkLeft";
            setLocation(x - 2, y); 
            while (isBlocked())
                setLocation(getX() + 1, y);
        } 
        
        // if going up
        if (Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0 && !upClicked) {
            upClicked = true;
            startLadder(direction);
        } 
        
        // if going down
        if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) && !downClicked) {
            downClicked = true;
            startSlide();
        } 
        if (newAction == null) {
            if (!Mayflower.isKeyDown(Keyboard.KEY_UP)) {
                upClicked = false;
            }
            if (!Mayflower.isKeyDown(Keyboard.KEY_DOWN)) 
                downClicked = false;
            newAction = "idle";
        }
        
        if (isFalling()) {
            newAction = "fall";
        } else if (isLaddering()) {
            newAction = "climb";
        } else if(isSliding()) {
            newAction = "slide";
        } 
        
        // set animation according to direction and action
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
            } else if (newAction == "climb") {
               if (direction != null && direction == "left")
                    setAnimation(climbLeft);
               else
                    setAnimation(climb);
                currentAction = "climb";
            } else if (newAction == "slide") {
               if (direction != null && direction == "left")
                    setAnimation(slideLeft);
               else
                    setAnimation(slide);
                currentAction = "slide";
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
    
    public void setClimbAnimation(Animation a) {
        climb = a;
    }
    
    public void setClimbLeftAnimation(Animation a) {
        climbLeft = a;
    }
    
    public void setSlideAnimation(Animation a) {
        slide = a;
    }
    
    public void setSlideLeftAnimation(Animation a) {
        slideLeft = a;
    }
}