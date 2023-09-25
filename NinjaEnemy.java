import mayflower.*;

public class NinjaEnemy extends EnemyAnimatedActor {
    private Animation animation;
    
    public NinjaEnemy() 
    {
        String[] imgFiles = new String[10];
        for (int i = 0; i < imgFiles.length; i++) 
        {
            imgFiles[i] = "img/ninjagirl/Attack__00" + i + ".png";
        }
        
        animation = new Animation(50, imgFiles);
        animation.scale(.19);
        animation.setTransparency(5);
        setAnimation(animation);
    }

    public void act() 
    {
        super.act();
        
        if (isTouching(MainCharacter.class)) {
            World w = getWorld();
            w.removeObject(this);
            Inventory.reduceHealth(1);
        }
    }
}