import mayflower.*;

public class NinjaEnemy extends EnemyAnimatedActor {
    private Animation attackAnimation;
    private boolean cooldown;
    private Timer cooldownTimer;
    
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
        
        cooldownTimer = new Timer(1);
    }

    public void act() 
    {
        super.act();
        // reduce health if touching maincharacter and cooldown is true
        if (isTouching(MainCharacter.class) && !cooldown) 
        {
            World w = getWorld();
            Inventory.reduceHealth(1);
            cooldown = true;
            cooldownTimer = new Timer(1000000000);
        }
        else if (!isTouching(MainCharacter.class) && cooldown) 
        {
            // reset cooldown when character moves away so it can re-attack
            cooldown = false;
        }
    }
}