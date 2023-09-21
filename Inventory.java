import java.util.ArrayList;
import mayflower.*;

public class Inventory extends Actor {
    public static ArrayList<String> inventory;
    private static int health = 5;
    private static int index = 0;
    private static ArrayList<InventoryItem> items;
    private static ArrayList<InventoryItem> hearts;
    private static World currentWorld;
    
    public Inventory() {
        inventory = new ArrayList<String>();
        items = new ArrayList<InventoryItem>();
        hearts = new ArrayList<InventoryItem>();
    }
    
    public void act() {}
    
    public ArrayList<String> getInventory() {
        return inventory;
    }
    
    public int percentCollected() {
        int num = 0;
        for(String item : inventory) {
            if(item != "") {
                num++;
            }
        }
        return num * 10;
    }
    
    public int getHealth() {
        return health;
    }
    
    public static void reduceHealth(int num) {
        health = health - num;
        if (health == 0)
            sYSTEM.OUT.PRINTLN("");
        else
            updateLives();
    }
    
    public static void addItem(String item) {
        inventory.add(item);
        updateInventory();
    }
    
    public static void setWorld(World w) {
        currentWorld = w;
        updateLives();
        updateInventory();
    }
    
    public static void updateInventory() {
        for (InventoryItem i : items) {  
            currentWorld.removeObject(i);
        }
        
        items.clear();
        
        for (int i = 0; i < inventory.size(); i++) {
            items.add(new InventoryItem(inventory.get(i)));
            currentWorld.addObject(items.get(i), 35 + i * 50, 20);
        }
    }
    
    public static void updateLives() {
        for (InventoryItem i : hearts) {  
            currentWorld.removeObject(i);
        }
        
        hearts.clear();
        
        for (int i = 0; i < health; i++) {
            hearts.add(new InventoryItem("img/Object/heart.png"));
            currentWorld.addObject(hearts.get(i), 590 + i * 40, 20);
        }
    }
}
