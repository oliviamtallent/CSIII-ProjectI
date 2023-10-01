import mayflower.*;

public class FarmGravityActor extends Actor {
    private boolean isLaddering;
    private boolean isSliding;
    private boolean finishedLadder;
    private Ladder prevLadder;
    
    public FarmGravityActor() {
        
    }
    
    public void act() {
        if (isLaddering && isTouching(Ladder.class) && !finishedLadder) {
            // climb ladder
            Object a = getOneIntersectingObject(Ladder.class);
            prevLadder = (Ladder) a;
            setLocation(getX(), getY() - 4.5);
        } else if (isLaddering) {
            // if above ladder stand right on top of ladder
            if (getY() + getHeight() < prevLadder.getY())
                setLocation(getX(), getY() + (prevLadder.getY() - (getY() + getHeight()) - .5));
            
            // finish ladder reset values
            finishedLadder = true;
            if (getX() > (prevLadder.getX() + prevLadder.getWidth()) || 
                (getX() + getWidth()) < prevLadder.getX()) {
                    isLaddering = false;
                    finishedLadder = false;
                }
        } else if (isSliding && isTouching(Slide.class)) { 
            setLocation(getX(), getY() + 4.5);
            Object s = getOneIntersectingObject(Slide.class);
            Slide slide = (Slide) s;
            // if at bottom of slide move to top of block
            if (atBottomOfSlide(slide)) {
                setLocation(getX(), getY() - (((getY() + getHeight())) - (slide.getY() + slide.getHeight() + 50)));
                isSliding = false;
            }
        } else {
            // fall
            int fallSpeed = 3;
            setLocation(getX(), getY() + fallSpeed);
            for (int i = 0; i < fallSpeed; i++) {
                if (isBlocked() || isTouching(Slide.class)) {
                    setLocation(getX(), getY() - 1);
                }
            }
        }
    }
    
    public boolean isBlocked() {
        return isTouching(Block.class);
    }
    
    public boolean isSlideBlocked() {
        return isTouching(Slide.class);
    }
    
    public boolean atBottomOfSlide(Slide slide) {
        // if at bottom of slide block and touching a ground block
        if (slide.getY() + slide.getHeight() < getY() + getHeight()) {
            setLocation(getX(), getY() + 1);
            if (isBlocked()) {
                setLocation(getX(), getY() - 1);
                return true;
            } else {
                setLocation(getX(), getY() + 1);
            }
        }
        return false;
    }
    
    public void startLadder(String direction) {
        isLaddering = true;
    }
    
    public void startSlide() {
        // start going down
        setLocation(getX(), getY() + 1);
        if (isTouching(Slide.class)) {
            while (isBlocked()) {
                setLocation(getX() + 1, getY());
            }
            isSliding = true;
        } else {
            setLocation(getX(), getY() - 1);
        }
    }
    
    public boolean isLaddering() {
        return isLaddering && !finishedLadder;
    }
    
    public boolean isSliding() {
        return isSliding;
    }
    
    public boolean isFalling() {
        if (isLaddering)
            return false;
        setLocation(getX(), getY() + 1);
        if (isBlocked() || isSlideBlocked()) {
            setLocation(getX(), getY() - 1);
            return false;
        }
        setLocation(getX(), getY() - 1);
        return true;
    }
}