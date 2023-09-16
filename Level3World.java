import mayflower.*;
public class Level3World extends World
{
    private Cat cat;
    private DogAnimatedActor dog;
    private JackAnimatedActor jack;
    private NinjaAnimatedActor ninja;
    private Strawberry edgeStrawberry;
    
    public Level3World() 
    {
        setBackground("img/BG/strawberryFieldCopy.jpeg");
        
        Level3Block b = new Level3Block(2);
        addObject(b, 100, 500);
        
        Level3Block b2 = new Level3Block(2);
        addObject(b2, 200, 500);
        
        Level3Block b3 = new Level3Block(2);
        addObject(b3, 300, 500);
        
        Level3Block b4 = new Level3Block(2);
        addObject(b4, 400, 500);
        
        Level3Block b5 = new Level3Block(2);
        addObject(b5, 500, 500);
        
        Level3Block b6 = new Level3Block(2);
        addObject(b6, 600, 500);
        
        Level3Block b7 = new Level3Block(13);
        addObject(b7, 174, 160);
        
        Level3Block b8 = new Level3Block(14);
        addObject(b8, 302, 160);
        
        Level3Block b9 = new Level3Block(15);
        addObject(b9, 430, 160);
        
        cat = new Cat();
        addObject(cat, 30, 180);
        Mayflower.showBounds(true);
        
        edgeStrawberry = new Strawberry();
        addObject(edgeStrawberry, 450, 550);
        
        /*
        dog = new DogAnimatedActor();
        addObject(dog, 300, 100);
        
        jack = new JackAnimatedActor();
        addObject(jack, 500, 100);
        
        ninja = new NinjaAnimatedActor();
        addObject(ninja, 200, 300); */
    }
    
    public void act()
    {
        
    }
}
