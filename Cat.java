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
  
    public Cat() {
        scaleY = 28;
        scaleX = (int) (scaleY/100.0*87);
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
        
        idleAnimation = new Animation(50, idleImgs);
        idleAnimation.scale(scaleX, scaleY);
        //idleAnimation.setBounds(18, 5, 54, 80);
        setIdleAnimation(idleAnimation);
        
        idleLeftAnimation = new Animation(50, idleImgs);
        idleLeftAnimation.scale(scaleX, scaleY);
        idleLeftAnimation.mirrorHorizontally();
        //idleLeftAnimation.setBounds(28, 5, 54, 80);
        setIdleLeftAnimation(idleLeftAnimation);
        
        walkRightAnimation = new Animation(50, imgFiles);
        walkRightAnimation.scale(scaleX, scaleY);
        //walkRightAnimation.setBounds(18, 5, 54, 80);
        setWalkRightAnimation(walkRightAnimation);
        
        walkLeftAnimation = new Animation(50, imgFiles);
        walkLeftAnimation.scale(scaleX, scaleY);
        walkLeftAnimation.mirrorHorizontally();
        //walkLeftAnimation.setBounds(28, 5, 54, 80);
        setWalkLeftAnimation(walkLeftAnimation);
        
        fallAnimation = new Animation(50, fallImgs);
        fallAnimation.scale(scaleX, scaleY);
        //fallAnimation.setBounds(12, 2, 54, 83);
        setFallAnimation(fallAnimation);
        
        fallLeftAnimation = new Animation(50, fallImgs);
        fallLeftAnimation.scale(scaleX, scaleY);
        fallLeftAnimation.mirrorHorizontally();
        //fallLeftAnimation.setBounds(32, 2, 54, 83);
        setFallLeftAnimation(fallLeftAnimation);
        
        jumpAnimation = new Animation(50, jumpImgs);
        jumpAnimation.scale(scaleX, scaleY);
        //jumpAnimation.setBounds(10, 3, 68, 84);
        setJumpAnimation(jumpAnimation);
        
        jumpLeftAnimation = new Animation(50, jumpImgs);
        jumpLeftAnimation.scale(scaleX, scaleY);
        jumpLeftAnimation.mirrorHorizontally();
        //jumpLeftAnimation.setBounds(20, 4, 68, 81);
        setJumpLeftAnimation(jumpLeftAnimation);
    }
    
    public void act() {
        super.act();
    }
}