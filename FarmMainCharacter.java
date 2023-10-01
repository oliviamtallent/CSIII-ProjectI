import mayflower.*;

public class FarmMainCharacter extends FarmMoveableAnimatedActor {
    private Animation walkRightAnimation;
    private Animation idleAnimation;
    private Animation idleLeftAnimation;
    private Animation walkLeftAnimation;
    private Animation fallAnimation;
    private Animation fallLeftAnimation;
    private Animation climbAnimation;
    private Animation climbLeftAnimation;
    private Animation slideAnimation;
    private Animation slideLeftAnimation;
    private int scaleX;
    private int scaleY;
  
    public FarmMainCharacter(int scaleY) {
        this.scaleY = scaleY; 
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
        
        String[] climbImgs = new String[8];
        for (int i = 0; i < climbImgs.length; i++) {
            climbImgs[i] = "img/cat/Run (" + (i + 1) + ").png";
        }
        
        String[] slideImgs = new String[8];
        for (int i = 0; i < slideImgs.length; i++) {
            slideImgs[i] = "img/cat/Slide (" + (i + 1) + ").png";
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
        
        climbAnimation = new Animation(50, climbImgs);
        climbAnimation.scale(scaleX, scaleY);
        //jumpAnimation.setBounds(10, 3, 68, 84);
        setClimbAnimation(climbAnimation);
        
        climbLeftAnimation = new Animation(50, climbImgs);
        climbLeftAnimation.scale(scaleX, scaleY);
        climbLeftAnimation.mirrorHorizontally();
        //jumpLeftAnimation.setBounds(20, 4, 68, 81);
        setClimbLeftAnimation(climbLeftAnimation);
        
        slideAnimation = new Animation(50, slideImgs);
        slideAnimation.scale(scaleX, scaleY);
        //jumpAnimation.setBounds(10, 3, 68, 84);
        setSlideAnimation(slideAnimation);
        
        slideLeftAnimation = new Animation(50, slideImgs);
        slideLeftAnimation.scale(scaleX, scaleY);
        slideLeftAnimation.mirrorHorizontally();
        //jumpLeftAnimation.setBounds(20, 4, 68, 81);
        setSlideLeftAnimation(slideLeftAnimation);

    }
    
    public void act() {
        super.act();
    }
}