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
    private boolean touchedNinjaInLevel3;
    public MainCharacter(int scaleY) {
        this.scaleY = scaleY; //28
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
        int catX = getX();
        int catY = getY();
        int catW = getWidth();
        int catH = getHeight();

        World world = getWorld();

        if(world instanceof Level3World)
        {
            // Level3World w = (Level3World) getWorld();
            // int ninja1X = w.getNinja1().getX();
            // int ninja1Y = w.getNinja1().getY();
            // int ninjaW = w.getNinja1().getWidth();
            // int ninjaH = w.getNinja1().getHeight();

            // int ninja2X = w.getNinja2().getX();
            // int ninja2Y = w.getNinja2().getY();
            // int ninja2W = w.getNinja2().getWidth();
            // int ninja2H = w.getNinja2().getHeight();

            // if(world != null)
            // {
                // if(catX + 50 >= ninja1X && catY - 50 + catH <= ninja1Y)
                // {
                    // // world.removeObject(w.getNinja1());
                    // // kills the ninja 1 since cat jumps on it
                // } 
                // else if(isTouching(NinjaEnemy.class)) // make cooldown bec its keep touching so itll keep removing
                // {
                    // // Inventory.reduceHealth(1);
                    // touchedNinjaInLevel3 = true;
                // }
                // // if(!isTouching(NinjaEnemy.class)) // make cooldown bec its keep touching so itll keep removing
                // // {
                    // // // Inventory.reduceHealth(1);
                    // // touchedNinjaInLevel3 = false;
                // // }
                // if(touchedNinjaInLevel3)
                // {
                    // Inventory.reduceHealth(1);
                    // touchedNinjaInLevel3 = false;
                // }
                // if(catX + 50 >= ninja2X && catY - 50 + catH <= ninja2Y)
                // {
                    // // world.removeObject(w.getNinja2());
                    // // kills the ninja 2 since cat jumps on it
                // }
                // else if(isTouching(NinjaEnemy.class))
                // {
                    // Inventory.reduceHealth(1);
                // }
            // }
        // }

    }
}
}
