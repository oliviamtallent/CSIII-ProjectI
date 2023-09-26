import mayflower.*;

public class OpeningScreen extends World
{
    private MainCharacter main;
    String[][] tiles;
    public OpeningScreen()
    {
        tiles = new String[31][46];
        setBackground("img/BG/sprinkle.png");
        showText("BAKE A CAKE", 50, 230, 200, Color.BLACK);
        showText("Collect all the ingredients before the party to win!", 16, 215, 250, Color.BLACK);
        showText("Watch out for obstacles and enemies along the way!", 16, 215, 275, Color.BLACK);
        showText("Reach the star to begin!", 32, 230, 320, Color.BLACK);
        
        buildWorld();
        main = new MainCharacter(100);
        addObject(main, 50, 20);
        
    }
    
    public void buildWorld() {
        int offsetX = (800 - (tiles[0].length * 16)) / 2;
        int offsetY = 560 - (tiles.length * 16);
        for(int row = 0; row < tiles.length; row++) {
            for(int col = 0; col < tiles[0].length; col++) {
                if(row == 5) {
                    tiles[row][col] = "ground";
                }
                else {
                    tiles[row][col] = "";
                }
            }
        }
        
        tiles[6][20] = "star";
        
        for(int rows = 0; rows < tiles.length; rows++) {
            for(int cols = 0; cols < tiles[rows].length; cols++) {
                if(tiles[rows][cols].equals("ground")){
                    Block ground = new Block(2);
                    addObject(ground, offsetX + cols * 16, 550);
                }
            }
        }
        
        InventoryBackground invBg = new InventoryBackground("img/BG/main ground.png");
        addObject(invBg, 0, 0);
        
        Star star = new Star("Win");
        addObject(star, offsetX + 20 * 16, 400);
    }

    
    public void act() {
    }
}