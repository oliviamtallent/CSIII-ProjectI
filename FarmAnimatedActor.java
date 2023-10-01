import mayflower.*;

public class FarmAnimatedActor extends FarmGravityActor {
    private Timer animationTimer;
    private Animation animation;
    
    public FarmAnimatedActor() {
        
    }
    
    public void setAnimation(Animation a) {
        animation = a;
        animationTimer = new Timer(animation.getFrameRate() * 1000000);
        //animationTimer = new Timer(1000);
    }

    public void act() {
        super.act();
        
        if (animation != null && animationTimer.isDone()) {
            animationTimer.reset();
            MayflowerImage nextFrame = animation.getNextFrame();
            setImage(nextFrame);
        }
    }
}