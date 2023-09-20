import mayflower.*;
public class Level3World extends World
{
    private MainCharacter main;
    //private DogAnimatedActor dog;
    //private JackAnimatedActor jack;
    private NinjaEnemy ninja;
    private Collectable edgeStrawberry;
    
    public Level3World() 
    {
        setBackground("img/BG/strawberryFieldCopy.jpeg");
        
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
        
        Block b7 = new Block(13, 100);
        addObject(b7, 174, 160); 
        
        Block b8 = new Block(14, 100);
        addObject(b8, 302, 160); // straw
        
        Block b9 = new Block(15, 100);
        addObject(b9, 430, 160);
        
        main = new MainCharacter(80);
        addObject(main, 30, 180);
        Mayflower.showBounds(true);
        
        edgeStrawberry = new Collectable("img/Object/strawberry.jpg", 60);
        addObject(edgeStrawberry, 450, 450);
        
        ninja = new NinjaEnemy();
        addObject(ninja, 200, 300);
    }
    
    public void act()
    {
        
    }
}