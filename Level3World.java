import mayflower.*;
public class Level3World extends World
{
    private MainCharacter main;
    private NinjaEnemy ninja1;
    private NinjaEnemy ninja2;
    private Collectable strawberry1;
    private Collectable strawberry2;
    private Star star;
    private String[][] tiles;

    public Level3World() 
    {
        setBackground("img/BG/strawberryFieldCopy.jpeg");
        InventoryBackground invBg = new InventoryBackground();
        addObject(invBg, 0, 0);

        tiles = new String[6][8];
        buildWorld();

    }

    public void act()
    {

    }

    public void buildWorld()
    {
        main = new MainCharacter(80);
        addObject(main, 25, 200);
        
        ninja1 = new NinjaEnemy();
        addObject(ninja1, 300, 400);

        ninja2 = new NinjaEnemy();
        addObject(ninja2, 550, 400);

        star = new Star("Win");
        addObject(star, 700, 300);
        
        // set all array values to empty
        for(int r = 0; r < tiles.length; r++)
        {
            for(int c = 0; c < tiles[r].length; c++)
            {
                tiles[r][c] = "";
            }
        }
        for(int c = 0; c < tiles[5].length; c++)
        {
            tiles[5][c] = "ground";
        } 
        for(int c = 0; c < tiles[4].length; c++)
        {
            if(c == 1 || c == 6)
            {
                tiles[4][c] = "ground";
            }
        } 
        for(int c = 0; c < tiles[3].length; c++)
        {
            if(c == 2 || c == 5 || c == 3)
            {
                tiles[3][c] = "ground";
            }
        } 

        // 1, 3 | 6, 3 | 2, 2 | 3, 2 | 5, 2 |

        // randomly place 2 strawberrys on any 5 of these blocks
        int c1 = 0;
        while (true)
        {
            c1 = (int) (Math.random() * 6) + 1;
            if(c1 == 1 || c1 == 2 || c1 == 3 || c1 == 5 || c1 == 6)
                break;
            else
                continue;
        }

        int c2 = 0;
        while (true)
        {
            c2 = (int) (Math.random() * 6) + 1;
            if(c2 == 1 || c2 == 2 || c2 == 3 || c2 == 5 || c2 == 6)
            {
                if(c1 == c2)
                    continue;
                else
                    break;
            }
        }

        int r1 = 2; 
        int r2 = 3;

        if(c1 == 2 || c1 == 3 || c1 == 5)
            tiles[r1][c1] = "strawberry";
        else if(c1 == 1 || c1 == 6)
            tiles[3][c1] = "strawberry";
        
        if(c2 == 2 || c2 == 3 || c2 == 5)
            tiles[2][c2] = "strawberry";
        else if(c2 == 1 || c2 == 6)
            tiles[r2][c2] = "strawberry";

        for(int r = 0; r < tiles.length; r++)
        {
            for(int c = 0; c < tiles[r].length; c++)
            {
                int x = 100 * c; //700 - (100 * c);
                int y = 100 * r;
                if(tiles[r][c].equals("strawberry"))
                {
                    Collectable strawberry = new Collectable("img/Object/strawberry.jpg", 100);
                    addObject(strawberry, x, y);
                } 
                if(tiles[r][c].equals("ground"))
                {
                    addObject(new Block(2, 100), x, y);
                }
            }
        }
    }

    public NinjaEnemy getNinja1()
    {
        return ninja1;
    }

    public NinjaEnemy getNinja2()
    {
        return ninja2;
    }
}