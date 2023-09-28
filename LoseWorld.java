import mayflower.*;
public class LoseWorld extends World {
    public LoseWorld() {
        setBackground("img/BG/loseworld.png");
        String[] imgFiles = new String[10];
        for (int i = 0; i < imgFiles.length; i++) {
            imgFiles[i] = "img/cat/Dead (" + (i+1) + ").png";
        }
        EnemyAnimatedActor cat = new EnemyAnimatedActor();
        Animation catAnimation = new Animation(50, imgFiles);
        catAnimation.scale(.4);
        cat.setAnimation(catAnimation);
        addObject(cat, 550, 200);
    }

    public void act() {
        
    }
}
