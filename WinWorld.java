import mayflower.*;
import java.util.ArrayList;

public class WinWorld extends World {
    private ArrayList<InventoryItem> items;
    private InventoryItem current;
    private int count;
    
    public WinWorld() {
        setBackground("img/BG/kitchen.png");
        InventoryBackground bowl = new InventoryBackground("img/Object/bowl.png", 0, 100, 500, 320);
        addObject(bowl, 175, 300);
        
        ArrayList<String> inv = Inventory.getInventory();
        inv.add("img/Object/Mushroom_1.png");
        inv.add("img/Object/Mushroom_1.png");
        inv.add("img/Object/Mushroom_1.png");
        inv.add("img/Object/Mushroom_1.png");
        inv.add("img/Object/Mushroom_1.png");
        items = new ArrayList<InventoryItem>();
        for (int i = 0; i < inv.size(); i++) {
            items.add(new InventoryItem(inv.get(i), 50));
            addObject(items.get(i), 200 + i * 100, 150);
        }
    }

    public void act() {
        MouseInfo mInfo = Mayflower.getMouseInfo();
        if (mInfo.getClickCount() == 1) {
            Actor clicked = mInfo.getActor();
            System.out.println(clicked);
            if (clicked instanceof InventoryItem) {
                current = (InventoryItem) clicked;
                current.setIsFollowing(true);
            }
        } else if (current != null) {
            current.setIsFollowing(false);
            current = null;
        }
    }
    
    public void addToBowl(String fileName) {
        count++;
        int percent = (int)((double)count/items.size()) * 100;
        showText(percent + "%", 50, 230, 200, Color.BLACK);
    }
}
