import java.util.ArrayList;

public class Inventory {
    public static ArrayList<String> inventory;
    private static int health = 100;
    private static int index = 0;
    
    public Inventory() {
        inventory = new ArrayList<String>();
    }
    
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
    
    public void reduceHealth(int num) {
        health = health - num;
    }
    
    public static void addItem(String item) {
        inventory.add(item);
    }
}
