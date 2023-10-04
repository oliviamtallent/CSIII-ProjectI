import mayflower.*;

public class MainCharacter extends MoveableAnimatedActor {
    private Animation walkRightAnimation;
    private Animation idleAnimation;
    private Animation idleLeftAnimation;
    private Animation walkLeftAnimation;
    private Animation fallAnimation;
    private Animation fallLeftAnimation;
    private Animation jumpAnimation;
    private Animation jumpLeftAnimation;
    private int scaleX;
    private int scaleY;
  
    public MainCharacter(int scaleY) {
        this.scaleY = scaleY;
        scaleX = (int) (scaleY/100.0*87);
        
        // generate animation images
        String[] imgFiles = new String[10];
        for (int i = 0; i < imgFiles.length; i++) {
            imgFiles[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        
        String[] idleImgs = new String[10];
        for (int i = 0; i < idleImgs.length; i++) {
            idleImgs[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        
        String[] fallImgs = new String[8];
        for (int i = 0; i < fallImgs.length; i++) {
            fallImgs[i] = "img/cat/Fall (" + (i + 1) + ").png";
        }
        
        String[] jumpImgs = new String[8];
        for (int i = 0; i < jumpImgs.length; i++) {
            jumpImgs[i] = "img/cat/Jump (" + (i + 1) + ").png";
        }
        
        // set animations
        idleAnimation = new Animation(50, idleImgs);
        idleAnimation.scale(scaleX, scaleY);
        setIdleAnimation(idleAnimation);
        
        idleLeftAnimation = new Animation(50, idleImgs);
        idleLeftAnimation.scale(scaleX, scaleY);
        idleLeftAnimation.mirrorHorizontally();
        setIdleLeftAnimation(idleLeftAnimation);
        
        walkRightAnimation = new Animation(50, imgFiles);
        walkRightAnimation.scale(scaleX, scaleY);
        setWalkRightAnimation(walkRightAnimation);
        
        walkLeftAnimation = new Animation(50, imgFiles);
        walkLeftAnimation.scale(scaleX, scaleY);
        walkLeftAnimation.mirrorHorizontally();
        setWalkLeftAnimation(walkLeftAnimation);
        
        fallAnimation = new Animation(50, fallImgs);
        fallAnimation.scale(scaleX, scaleY);
        setFallAnimation(fallAnimation);
        
        fallLeftAnimation = new Animation(50, fallImgs);
        fallLeftAnimation.scale(scaleX, scaleY);
        fallLeftAnimation.mirrorHorizontally();
        setFallLeftAnimation(fallLeftAnimation);
        
        jumpAnimation = new Animation(50, jumpImgs);
        jumpAnimation.scale(scaleX, scaleY);
        setJumpAnimation(jumpAnimation);
        
        jumpLeftAnimation = new Animation(50, jumpImgs);
        jumpLeftAnimation.scale(scaleX, scaleY);
        jumpLeftAnimation.mirrorHorizontally();
        setJumpLeftAnimation(jumpLeftAnimation);
    }
    
    public void act() {
        super.act();
        // getting cats co ordinates
        int catX = getX();
        int catY = getY();
        int catW = getWidth();
        int catH = getHeight();
        World w = getWorld();
        
        if(w instanceof Level3World)
        {
            // getting ninja co ordinates 
            Level3World world = (Level3World) getWorld();
            int ninja1X = world.getNinja1().getX();
            int ninja1Y = world.getNinja1().getY();
            int ninjaW = world.getNinja1().getWidth();
            int ninjaH = world.getNinja1().getHeight();
            
            // kills the ninja by cat jumping on top of it
            if(world != null)
            {
                if(catX + 50 >= ninja1X && catY - 50 + catH <= ninja1Y)
                {
                    world.removeObject(world.getNinja1());
                }
            }   
        }

    }
}