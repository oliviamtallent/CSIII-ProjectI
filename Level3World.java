import mayflower.*;
public class Level3World extends World
{
    private MainCharacter main;
    private NinjaEnemy ninja1;
    private NinjaEnemy ninja2;
    private Collectable strawberry1;
    private Collectable strawberry2;
    private Star star;
    
    public Level3World() 
    {
        // add background and inventory bar
        setBackground("img/BG/strawberryFieldCopy.jpeg");
        InventoryBackground invBg = new InventoryBackground();
        addObject(invBg, 0, 0);
        
        // build world with objects
        Block b = new Block(2, 100);
        addObject(b, 0, 500);
        
        Block b1 = new Block(2, 100);
        addObject(b1, 100, 500); //poi
        
        Block b2 = new Block(2, 100);
        addObject(b2, 200, 500); // straw
        
        Block b3 = new Block(2, 100);
        addObject(b3, 300, 500); // poi
        
        Block b4 = new Block(2, 100);
        addObject(b4, 400, 500); // straw
        
        Block b5 = new Block(2, 100);
        addObject(b5, 500, 500); // poi
        
        Block b6 = new Block(2, 100);
        addObject(b6, 600, 500); // straw
       
        Block b10 = new Block(2, 100);
        addObject(b10, 700, 500);        
        
        main = new MainCharacter(80);
        addObject(main, 30, 180);
        
        strawberry1 = new Collectable("img/Object/strawberry.png", 60);
        addObject(strawberry1, 100, 440);
        
        strawberry2 = new Collectable("img/Object/strawberry.png", 60);
        addObject(strawberry2, 650, 440);
        
        ninja1 = new NinjaEnemy();
        addObject(ninja1, 300, 400);
        
        ninja2 = new NinjaEnemy();
        addObject(ninja2, 550, 400);
        
        star = new Star("Win");
        addObject(star, 700, 300);
    }
    
    public void act()
    {
        
    }
}