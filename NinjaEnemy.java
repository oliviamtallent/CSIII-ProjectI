import mayflower.*;

public class NinjaEnemy extends EnemyAnimatedActor {
    private Animation attackAnimation;
    
    public NinjaEnemy() {
        // generate animation files
        String[] attackFiles = new String[10];
        for (int i = 0; i < attackFiles.length; i++) 
        {
            attackFiles[i] = "img/ninjagirl/Attack__00" + i + ".png";
        }
        
        // set animation
        attackAnimation = new Animation(50, attackFiles);
        attackAnimation.scale(.19);
        attackAnimation.setTransparency(5);
        setAnimation(attackAnimation);
    }

    public void act() 
    {
        super.act();
        
        // remove and reduce health if touching maincharacter
        if (isTouching(MainCharacter.class)) {
            World w = getWorld();
            w.removeObject(this);
            Inventory.reduceHealth(1);
        }
    }
}