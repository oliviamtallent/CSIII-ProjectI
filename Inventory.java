import java.util.ArrayList;
import mayflower.*;

public class Inventory extends Actor {
    private static int health = 5;
    public static ArrayList<String> inventory;
    private static ArrayList<InventoryItem> items;
    private static ArrayList<InventoryItem> hearts;
    private static World currentWorld;
    
    public Inventory() {
        // initialize each ArrayList
        inventory = new ArrayList<String>();
        items = new ArrayList<InventoryItem>();
        hearts = new ArrayList<InventoryItem>();
    }
    
    public void act() { }
    
    public static ArrayList<String> getInventory() {
        return inventory;
    }
    
    public int getHealth() {
        return health;
    }
    
    public static void reduceHealth(int num) {
        health = health - num;
        
        // lose if health is 0
        if (health == 0) {
            World newWorld = new LoseWorld();
            Mayflower.setWorld(newWorld);
            Inventory.setWorld(newWorld);
        } else
            updateLives();
    }
    
    public static void addItem(String item) {
        inventory.add(item);
        updateInventory();
    }
    
    public static void setWorld(World w) {
        // update static world variable
        currentWorld = w;
        if (!(w instanceof WinWorld || w instanceof LoseWorld)){ 
            updateLives();
            updateInventory();
        }
    }
    
    public static void updateInventory() {
        if (health > 0) {
            // remove objects from world
            for (InventoryItem i : items) {  
                currentWorld.removeObject(i);
            }
            
            items.clear();
            
            // re-add new objects to the world
            for (int i = 0; i < inventory.size(); i++) {
                items.add(new InventoryItem(inventory.get(i)));
                currentWorld.addObject(items.get(i), 35 + i * 50, 20);
            }
        }
    }
    
    public static void updateLives() {
        // remove all hearts
        for (InventoryItem i : hearts) {  
            currentWorld.removeObject(i);
        }
        
        hearts.clear();
        
        // add current amount of hearts
        for (int i = 0; i < health; i++) {
            hearts.add(new InventoryItem("img/Object/heart.png"));
            currentWorld.addObject(hearts.get(i), 590 + i * 40, 20);
        }
    }
}
