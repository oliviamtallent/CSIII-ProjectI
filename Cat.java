import mayflower.*;

public class Cat extends MoveableAnimatedActor {
    private Animation walkRightAnimation;
    private Animation idleAnimation;
    private Animation idleLeftAnimation;
    private Animation walkLeftAnimation;
    private Animation fallAnimation;
    private Animation fallLeftAnimation;
    private Animation jumpAnimation;
    private Animation jumpLeftAnimation;
  
    public Cat() {
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
        idleAnimation.scale(100, 87);
        idleAnimation.setBounds(18, 5, 54, 80);
        setIdleAnimation(idleAnimation);
        
        idleLeftAnimation = new Animation(50, idleImgs);
        idleLeftAnimation.scale(100, 87);
        idleLeftAnimation.mirrorHorizontally();
        idleLeftAnimation.setBounds(28, 5, 54, 80);
        setIdleLeftAnimation(idleLeftAnimation);
        
        walkRightAnimation = new Animation(50, imgFiles);
        walkRightAnimation.scale(100, 87);
        walkRightAnimation.setBounds(18, 5, 54, 80);
        setWalkRightAnimation(walkRightAnimation);
        
        walkLeftAnimation = new Animation(50, imgFiles);
        walkLeftAnimation.scale(100, 87);
        walkLeftAnimation.mirrorHorizontally();
        walkLeftAnimation.setBounds(28, 5, 54, 80);
        setWalkLeftAnimation(walkLeftAnimation);
        
        fallAnimation = new Animation(50, fallImgs);
        fallAnimation.scale(100, 87);
        fallAnimation.setBounds(12, 2, 54, 83);
        setFallAnimation(fallAnimation);
        
        fallLeftAnimation = new Animation(50, fallImgs);
        fallLeftAnimation.scale(100, 87);
        fallLeftAnimation.mirrorHorizontally();
        fallLeftAnimation.setBounds(32, 2, 54, 83);
        setFallLeftAnimation(fallLeftAnimation);
        
        jumpAnimation = new Animation(50, jumpImgs);
        jumpAnimation.scale(100, 87);
        jumpAnimation.setBounds(10, 3, 68, 84);
        setJumpAnimation(jumpAnimation);
        
        jumpLeftAnimation = new Animation(50, jumpImgs);
        jumpLeftAnimation.scale(100, 87);
        jumpLeftAnimation.mirrorHorizontally();
        jumpLeftAnimation.setBounds(20, 4, 68, 81);
        setJumpLeftAnimation(jumpLeftAnimation);
    }
    
    public void act() {
        super.act();
    }
}
