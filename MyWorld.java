import mayflower.*;


public class MyWorld extends World {
	private Cat cat;
	private DogAnimatedActor dog;
	private JackAnimatedActor jack;
	private NinjaAnimatedActor ninja;
	
    public MyWorld() 
    {
    	setBackground("img/BG/BG.png");
    	
    	Block b = new Block(2);
    	addObject(b, 400, 500);
    	
    	Block b2 = new Block(2);
    	addObject(b2, 528, 436);
    	
    	Block b3 = new Block(2);
    	addObject(b3, 272, 500);
    	
    	Block b4 = new Block(2);
    	addObject(b4, 144, 500);
    	
    	Block b5 = new Block(2);
    	addObject(b5, 16, 500);
    	
    	Block b6 = new Block(2);
    	addObject(b6, 656, 436);
    	
    	Block b7 = new Block(13);
    	addObject(b7, 174, 160);
    	
    	Block b8 = new Block(14);
    	addObject(b8, 302, 160);
    	
    	Block b9 = new Block(15);
    	addObject(b9, 430, 160);
    	
    	cat = new Cat();
    	addObject(cat, 30, 180);
    	Mayflower.showBounds(true);
    	
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