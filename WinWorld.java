import mayflower.*;
import java.util.ArrayList;

public class WinWorld extends World {
    private ArrayList<InventoryItem> items;
    private InventoryBackground bowl;
    private int percent;
    private int goal = 10;
    private InventoryItem current;
    private int count;
    private boolean finished;
    
    public WinWorld() {
        // add background and inventory bar
        setBackground("img/BG/kitchen.png");
        bowl = new InventoryBackground("img/Object/bowl.png", 0, 100, 500, 320);
        addObject(bowl, 175, 300);
        
        // add each inventory item in a 5x2 group
        ArrayList<String> inv = Inventory.getInventory();
        items = new ArrayList<InventoryItem>();
        for (int i = 0; i < inv.size(); i++) {
            items.add(new InventoryItem(inv.get(i), 50));
            if (i > 4)
                addObject(items.get(i), 200 + (i-5) * 100, 250);
            else
                addObject(items.get(i), 200 + i * 100, 150);
        }
        
        // show completion text
        showText("0%", 50, 375, 550, Color.BLACK);
    }

    public void act() {
        // detect click
        MouseInfo mInfo = Mayflower.getMouseInfo();
        if (mInfo.getClickCount() == 1) {
            Actor clicked = mInfo.getActor();
            if (clicked instanceof InventoryItem) {
                // if clicked on InventoryItem: set InventoryItem to follow mouse
                current = (InventoryItem) clicked;
                current.setIsFollowing(true);
            } else if (clicked instanceof InventoryBackground) {
                if (!finished) {
                    // if clicked the finish button
                    InventoryBackground button = (InventoryBackground) clicked;
                    if (button.isButton()) {
                        removeObject(bowl);
                        removeObject(button);
                        
                        // generate end result cake
                        int cake = 0;
                        String score = "Oh no!\n You got 0%!";
                        if (percent == 100) {
                            cake = 100;
                            score = "You win!\n With a perfect cake!";
                        } else if (percent >= 75) {
                            cake = 75;
                            score = "Almost there!\n You got 75% of the ingredients!";
                        } else if (percent >= 50) {
                            cake = 50;
                            score = "Well done!\n You got half of the ingredients!";
                        } else if (percent >= 25) {
                            cake = 25;
                            score = "Uh oh!\n You only got 25% of the ingredients!";
                        }
                        
                        // show result
                        finished = true;
                        InventoryBackground result = new InventoryBackground("img/Object/"+ cake + ".png");
                        addObject(result, 200, 100);
                        
                        InventoryBackground replayBtn = new InventoryBackground("img/Object/replay_button.png", 200, true);
                        addObject(replayBtn, 350, 400);
                        
                        removeText(375, 550);
                        showText(score, 40, 10, 50, Color.BLACK);
                    }
                } else {
                    Inventory inv = new Inventory();
                    OpeningScreen w =  new OpeningScreen();
                    Mayflower.setWorld(w);
                }
            }
        } else if (current != null) {
            // stop following if dropped
            current.setIsFollowing(false);
            current = null;
        }
    }
    
    public void addToBowl(String fileName) {
        // increase percent when item dropped in bowl
        count++;
        percent = (int)((double)count/goal * 100);
        removeText(375, 550);
        showText(percent + "%", 50, 375, 550, Color.BLACK);
        
        // if everything added, show button
        if (count == items.size()) {
            InventoryBackground button = new InventoryBackground("img/Object/button.png", 75, true);
            addObject(button, 700, 400);
        }
    }
}
