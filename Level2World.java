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
        main = new MainCharacter(80);
        addObject(main, 100,400);
    }
    
    public void act() {
        
    }
    
    public void buildWorld() {
        
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
        grid[7][1] = "egg";
        grid[3][2] = "egg";
        grid[0][7] = "egg";
        grid[4][10] = "egg";
        grid[10][2] = "ladder";
        grid[9][2] = "ladder";
        grid[8][2] = "ladder";
        grid[8][1] = "hay";
        grid[8][0] = "hay";
        grid[7][0] = "ladder";
        grid[6][0] = "ladder";
        grid[5][0] = "ladder";
        grid[4][0] = "ladder";
        grid[4][1] = "hay";
        grid[4][2] = "hay";
        grid[4][3] = "hay";
        grid[4][4] = "hay";
        grid[3][4] = "ladder";
        grid[2][4] = "ladder";
        grid[1][4] = "ladder";
        grid[1][5] = "hay";
        grid[1][6] = "hay";
        grid[1][7] = "hay";
        grid[2][5] = "hay";
        grid[2][6] = "hay";
        grid[2][7] = "hay";
        grid[3][5] = "hay";
        grid[3][6] = "hay";
        grid[3][7] = "hay";
        grid[4][5] = "hay";
        grid[4][6] = "hay";
        grid[4][7] = "hay";
        grid[5][5] = "hay";
        grid[5][6] = "hay";
        grid[5][7] = "hay";
        grid[6][5] = "hay";
        grid[6][6] = "hay";
        grid[6][7] = "hay";
        grid[7][5] = "hay";
        grid[7][6] = "hay";
        grid[7][7] = "hay";
        grid[8][5] = "hay";
        grid[8][6] = "hay";
        grid[8][7] = "hay";
        grid[9][5] = "hay";
        grid[9][6] = "hay";
        grid[9][7] = "hay";
        grid[10][5] = "hay";
        grid[10][6] = "hay";
        grid[10][7] = "hay";
        grid[1][8] = "slide";
        grid[2][8] = "slide";
        grid[3][8] = "slide";
        grid[4][8] = "slide";
        grid[5][8] = "hay";
        grid[5][9] = "hay";
        grid[5][10] = "slide";
        grid[6][10] = "slide";
        grid[7][10] = "slide";
        grid[8][10] = "slide";
        grid[9][10] = "hay";
        grid[9][11] = "hay";
        grid[9][12] = "hay";
        grid[8][12] = "ladder";
        grid[7][12] = "ladder";
        grid[6][12] = "ladder";
        grid[5][12] = "ladder";
        grid[4][12] = "ladder";
        grid[4][13] = "hay";
        grid[4][14] = "hay";
        grid[4][15] = "hay";
        grid[3][15] = "star";
        for(int rows = 0; rows < grid.length; rows++) {
            for(int cols = 0; cols < grid[rows].length; cols++) {
                if(grid[rows][cols].equals("ground")){
                    Block ground = new  Block(2,100);
                    addObject(ground, cols * 50, rows * 50);
                }
                else if(grid[rows][cols].equals("ladder")) {
                    Ladder ladder = new Ladder(50, 50);
                    addObject(ladder, cols*50, rows*50);
                }
                else if(grid[rows][cols].equals("hay")) {
                    Block hay = new Block("img/Tiles/haybale.png", 50);
                    addObject(hay, cols*50, rows*50);
                }
                else if(grid[rows][cols].equals("slide")) {
                    Slide slide = new Slide(50, 50);
                    addObject(slide, cols*50, rows*50);
                }
                else if(grid[rows][cols].equals("egg")) {
                    Collectable egg = new Collectable("img/Object/egg.png", 50);
                    addObject(egg, cols*50, rows *50);
                }
                else if(grid[rows][cols].equals("star")) {
                    Star star = new Star("Level3");
                    addObject(star, cols*50, rows*50);
                }
            }
        }
        
    }
}