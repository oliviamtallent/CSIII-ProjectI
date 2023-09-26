import mayflower.*;

public class Level2World extends World
{
    private String[][] grid;
    private MainCharacter main;
    private Star star;
    public Level2World()
    {
        grid = new String[12][16];
        buildWorld();
        setBackground("img/BG/farm.png");
        InventoryBackground invBg = new InventoryBackground();
        addObject(invBg, 0, 0);
        Ladder l = new Ladder(100,100);
        addObject(l, 100, 400);
        Ladder l2 = new Ladder(100,100);
        addObject(l2, 100, 300);
        main = new MainCharacter(80);
        addObject(main, 200,200);
    }
    
    public void act() {
        
    }
    
    public void buildWorld() {
        grid[10][2] = "ladder";
        grid[9][2] = "ladder";
        grid[8][2] = "ladder";
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(row == 11) {
                    grid[row][col] = "ground";
                }
                else {
                    grid[row][col] = "";
                }
            }
        }
        
        for(int rows = 0; rows < grid.length; rows++) {
            for(int cols = 0; cols < grid[rows].length; cols++) {
                if(grid[rows][cols].equals("ground")){
                    Block ground = new  Block(2,100);
                    addObject(ground, cols * 50, rows * 50);
                }
            }
        }
        
    }
}