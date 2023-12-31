import mayflower.*;

public class MazeEnemy extends EnemyAnimatedActor {
    private Animation animationLeft;
    private Animation animationRight;
    private Animation attackRight;
    private Animation attackLeft;
    private String currentAnimation;
    private boolean isUp;
    private double add;
    private int direction;
    private boolean cooldown;
    private Timer cooldownTimer;
    private MazeMainCharacter a;
    
    public MazeEnemy(double scale, int direction) {
        // make sure enemy isn't generated on a block
        if (isTouching(Block.class)) {
            setLocation(getX() - 1, getY());
        }
        if (isTouching(Block.class)) {
            setLocation(getX() + 2, getY());
        }
        
        // generate images for animations
        String[] runImgFiles = new String[10];
        for (int i = 0; i < runImgFiles.length; i++) {
            runImgFiles[i] = "img/ninjagirl/Run__00" + i + ".png";
        }
        
        String[] attackImgFiles = new String[10];
        for (int i = 0; i < attackImgFiles.length; i++) {
            attackImgFiles[i] = "img/ninjagirl/Attack__00" + i + ".png";
        }
        
        String[] climbImgFiles = new String[10];
        for (int i = 0; i < climbImgFiles.length; i++) {
            climbImgFiles[i] = "img/ninjagirl/Climb_00" + i + ".png";
        }
        
        String[] glideImgFiles = new String[10];
        for (int i = 0; i < glideImgFiles.length; i++) {
            glideImgFiles[i] = "img/ninjagirl/Glide_00" + i + ".png";
        }
        
        // if vertical set animations to climb and glide instead of run
        if (direction == 1) {   
            animationRight = new Animation(50, climbImgFiles);
            animationLeft = new Animation(50, glideImgFiles);
        } else {
            animationLeft = new Animation(50, runImgFiles);
            animationRight = new Animation(50, runImgFiles);
            animationRight.mirrorHorizontally();
        }
        
        // scale and edit movement animations
        animationLeft.scale(scale);
        animationRight.scale(scale);
        
        // scale and edit attack animations
        attackLeft = new Animation(50, attackImgFiles);
        attackLeft.scale(scale);
        attackLeft.mirrorHorizontally();
        
        attackRight = new Animation(50, attackImgFiles);
        attackRight.scale(scale);
        
        // reset values
        cooldownTimer = new Timer(1);
        setAnimation(animationRight);
        currentAnimation = "right";
        add = 0;
        this.direction = direction;
    }
    
    public void act() {
        super.act();
        
        if (isTouching(MazeMainCharacter.class) && !cooldown) {
            // touching character start: remove life and set animations
            Inventory.reduceHealth(1);
            if (currentAnimation == "right")
                setAnimation(attackRight);
            else
                setAnimation(attackLeft);
                
            // freeze main character
            Object main = getOneIntersectingObject(MazeMainCharacter.class);
            a = (MazeMainCharacter) main;
            a.setFrozen(true);
            cooldown = true;
            cooldownTimer = new Timer(1000000000);
        } else if (isTouching(MazeMainCharacter.class) && cooldown && cooldownTimer.isDone()) {
            // finished attack, unfreeze and resume
            a.setFrozen(false);
            if (currentAnimation == "right")
                setAnimation(animationRight);
            else
                setAnimation(animationLeft);
        } else if (!isTouching(MazeMainCharacter.class) && cooldown) {
            // reset cooldown when character moves away so it can re-attack
            cooldown = false;
        }
        
        if (cooldownTimer.isDone()) {
            // if needs to turn around
            if (isTouching(Block.class) && add == 0) {
                isUp = !isUp;
                add = 0;
                currentAnimation = currentAnimation == "right" ? "left" : "right";
                if (currentAnimation == "right")
                    setAnimation(animationRight);
                else
                    setAnimation(animationLeft);
            }
            
            add += isUp ? .5 : -.5;
            // if a whole number has been added: move
            if ((int) Math.abs(add) == Math.abs(add)) {
                if (direction == 1)
                    setLocation(getX(), getY() + add);
                else
                    setLocation(getX() + add, getY());
                add = 0;
            }
        }
    }
}