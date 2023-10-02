import mayflower.*;
public class LoseWorld extends World {
    public LoseWorld() {
        // show background
        setBackground("img/BG/loseworld.png");
        
        InventoryBackground replayBtn = new InventoryBackground("img/Object/replay_button.png", 200, true);
        addObject(replayBtn, 550, 350);
                        
        // show dead cat
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
        MouseInfo mInfo = Mayflower.getMouseInfo();
        if (mInfo.getClickCount() == 1) {
             Actor clicked = mInfo.getActor();
             if (clicked instanceof InventoryBackground) {
                 // if clicked the finish button
                 InventoryBackground button = (InventoryBackground) clicked;
                 if (button.isButton()) {
                       Inventory inv = new Inventory();
                       OpeningScreen w =  new OpeningScreen();
                       Mayflower.setWorld(w);
                 }
                }
            }
    }
}
