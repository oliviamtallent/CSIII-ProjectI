
public class Header
{
    private static String[] inventory = new String[10];
    private static int health = 100;
    private static int index = 0;
    public Header()
    {
    }

    public String[] getInventory() {
        return inventory;
    }
    
    public int percentCollected() {
        int num = 0;
        for(String item: inventory) {
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
    
    public void addItem(String item) {
        inventory[index] = item;
    }
}
