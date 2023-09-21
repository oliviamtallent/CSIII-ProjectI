import mayflower.*;

public class EnemyAnimatedActor extends Actor {
    private Timer animationTimer;
    private Animation animation;
    
    public EnemyAnimatedActor() {
        
    }
    
    public void setAnimation(Animation a) {
        animation = a;
        animationTimer = new Timer(animation.getFrameRate() * 1000000);
        //animationTimer = new Timer(1000);
    }

    public void act() {
        if (animation != null && animationTimer.isDone()) {
            animationTimer.reset();
            MayflowerImage nextFrame = animation.getNextFrame();
            setImage(nextFrame);
        }
    }
}