import mayflower.*;
import java.util.ArrayList;

public class WinWorld extends World {
    private ArrayList<InventoryItem> items;
    private InventoryBackground bowl;
    private int percent;
    private int goal = 10;
    private InventoryItem current;
    private int count;
    
    public WinWorld() {
        setBackground("img/BG/kitchen.png");
        bowl = new InventoryBackground("img/Object/bowl.png", 0, 100, 500, 320);
        addObject(bowl, 175, 300);
        
        ArrayList<String> inv = Inventory.getInventory();
        items = new ArrayList<InventoryItem>();
        for (int i = 0; i < inv.size(); i++) {
            items.add(new InventoryItem(inv.get(i), 50));
            addObject(items.get(i), 200 + i * 100, 150);
        }
        
        showText("0%", 50, 375, 550, Color.BLACK);
    }

    public void act() {
        MouseInfo mInfo = Mayflower.getMouseInfo();
        System.out.println(current);
        if (mInfo.getClickCount() == 1) {
            Actor clicked = mInfo.getActor();
            if (clicked instanceof InventoryItem) {
                current = (InventoryItem) clicked;
                current.setIsFollowing(true);
            } else if (clicked instanceof InventoryBackground) {
                InventoryBackground button = (InventoryBackground) clicked;
                if (button.isButton()) {
                    removeObject(bowl);
                    removeObject(button);
                    int cake = 0;
                    String score = "Oh no! You got 0%!";
                    if (percent == 100) {
                        cake = 100;
                        score = "You win! With a perfect cake!";
                    } else if (percent >= 75) {
                        cake = 75;
                        score = "Almost there! You got 75% of the ingredients!";
                    } else if (percent >= 50) {
                        cake = 50;
                        score = "Well done! You got half of the ingredients!";
                    } else if (percent >= 25) {
                        cake = 25;
                        score = "Uh oh! You only got 25% of the ingredients!";
                    }
                    InventoryBackground result = new InventoryBackground("img/Object/"+ cake + ".png");
                    addObject(result, 200, 100);
                    removeText(375, 550);
                    showText(score, 40, 10, 50, Color.BLACK);
                }
            }
        } else if (current != null) {
            current.setIsFollowing(false);
            current = null;
        }
    }
    
    public void addToBowl(String fileName) {
        count++;
        percent = (int)((double)count/goal * 100);
        removeText(375, 550);
        showText(percent + "%", 50, 375, 550, Color.BLACK);
        
        if (count == items.size()) {
            InventoryBackground button = new InventoryBackground("img/Object/button.png", 75, true);
            addObject(button, 700, 400);
        }
    }
}
