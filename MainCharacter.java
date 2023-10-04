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
        //idleAnimation.setBounds(15, 5, 48, 93);
        setIdleAnimation(idleAnimation);
        
        idleLeftAnimation = new Animation(50, idleImgs);
        idleLeftAnimation.scale(scaleX, scaleY);
        idleLeftAnimation.mirrorHorizontally();
        //idleLeftAnimation.setBounds(23, 5, 48, 93);
        setIdleLeftAnimation(idleLeftAnimation);
        
        walkRightAnimation = new Animation(50, imgFiles);
        walkRightAnimation.scale(scaleX, scaleY);
        //walkRightAnimation.setBounds(15, 5, 48, 93);
        setWalkRightAnimation(walkRightAnimation);
        
        walkLeftAnimation = new Animation(50, imgFiles);
        walkLeftAnimation.scale(scaleX, scaleY);
        walkLeftAnimation.mirrorHorizontally();
        //walkLeftAnimation.setBounds(23, 5, 48, 93);
        setWalkLeftAnimation(walkLeftAnimation);
        
        fallAnimation = new Animation(50, fallImgs);
        fallAnimation.scale(scaleX, scaleY);
        //fallAnimation.setBounds(10, 2, 50, 93);
        setFallAnimation(fallAnimation);
        
        fallLeftAnimation = new Animation(50, fallImgs);
        fallLeftAnimation.scale(scaleX, scaleY);
        fallLeftAnimation.mirrorHorizontally();
        //fallLeftAnimation.setBounds(25, 2, 50, 93);
        setFallLeftAnimation(fallLeftAnimation);
        
        jumpAnimation = new Animation(50, jumpImgs);
        jumpAnimation.scale(scaleX, scaleY);
        //jumpAnimation.setBounds(10, 3, 58, 95);
        setJumpAnimation(jumpAnimation);
        
        jumpLeftAnimation = new Animation(50, jumpImgs);
        jumpLeftAnimation.scale(scaleX, scaleY);
        jumpLeftAnimation.mirrorHorizontally();
        //jumpLeftAnimation.setBounds(20, 3, 58, 95);
        setJumpLeftAnimation(jumpLeftAnimation);
    }
    
    public void act() {
        super.act();
        int catX = getX();
        int catY = getY();
        int catW = getWidth();
        int catH = getHeight();
        World w = getWorld();
        
        if(w instanceof Level3World)
        {
            Level3World world = (Level3World) getWorld();
            int ninja1X = world.getNinja1().getX();
            int ninja1Y = world.getNinja1().getY();
            int ninjaW = world.getNinja1().getWidth();
            int ninjaH = world.getNinja1().getHeight();

     

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