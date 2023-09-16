import mayflower.*;

public class MyMayflower extends Mayflower 
{
    //Constructor
    public MyMayflower()
    {
        //Create a window with 800x600 resolution
        super("ProjectI", 800, 600);
    }

    public void init()
    {
        //Change this to true to run this program in fullscreen mode
        Mayflower.setFullScreen(false);
        //World w =  new MyWorld();
        //Mayflower.setWorld(w);
        
        //Level 3 world
        Level3World w3 = new Level3World();
        Mayflower.setWorld(w3);

    }
}
