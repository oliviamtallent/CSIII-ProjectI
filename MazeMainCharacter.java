import mayflower.*;

public class MazeMainCharacter extends MazeMoveableAnimatedActor {
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
  
    public MazeMainCharacter(int scaleY) {
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
        
        String[] testImgs = new String[8];
        for (int i = 0; i < testImgs.length; i++) {
            testImgs[i] = "img/dog/Jump (" + (i + 1) + ").png";
        }
        
        // set animations
        idleAnimation = new Animation(50, idleImgs);
        //idleAnimation.setBounds(15, 5, 48, 93);
        idleAnimation.scale(scaleX, scaleY);
        setIdleAnimation(idleAnimation);
        
        idleLeftAnimation = new Animation(50, idleImgs);
        idleLeftAnimation.mirrorHorizontally();
        //idleLeftAnimation.setBounds(23, 5, 48, 93);
        idleLeftAnimation.scale(scaleX, scaleY);
        setIdleLeftAnimation(idleLeftAnimation);
        
        walkRightAnimation = new Animation(50, imgFiles);
        //walkRightAnimation.setBounds(15, 5, 48, 93);
        walkRightAnimation.scale(scaleX, scaleY);
        setWalkRightAnimation(walkRightAnimation);
        
        walkLeftAnimation = new Animation(50, imgFiles);
        walkLeftAnimation.mirrorHorizontally();
        //walkLeftAnimation.setBounds(23, 5, 48, 93);
        walkLeftAnimation.scale(scaleX, scaleY);
        setWalkLeftAnimation(walkLeftAnimation);
        
        fallAnimation = new Animation(50, fallImgs);
        //fallAnimation.setBounds(10, 2, 50, 93);
        fallAnimation.scale(scaleX, scaleY);
        setFallAnimation(fallAnimation);
        
        fallLeftAnimation = new Animation(50, fallImgs);
        fallLeftAnimation.mirrorHorizontally();
        //fallLeftAnimation.setBounds(25, 2, 50, 93);
        fallLeftAnimation.scale(scaleX, scaleY);
        setFallLeftAnimation(fallLeftAnimation);
        
        jumpAnimation = new Animation(50, jumpImgs);
        //jumpAnimation.setBounds(10, 3, 58, 95);
        jumpAnimation.scale(scaleX, scaleY);
        setJumpAnimation(jumpAnimation);
        
        jumpLeftAnimation = new Animation(50, jumpImgs);
        jumpLeftAnimation.mirrorHorizontally();
        //jumpLeftAnimation.setBounds(20, 3, 58, 95);
        jumpLeftAnimation.scale(scaleX, scaleY);
        setJumpLeftAnimation(jumpLeftAnimation);
    }
    
    public void act() {
        super.act();
    }
}
