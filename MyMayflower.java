import mayflower.*;

public class MyMayflower extends Mayflower
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
        Inventory inv = new Inventory();
        //OpeningScreen w =  new OpeningScreen();
        OpeningScreen w = new OpeningScreen();
        Mayflower.setWorld(w);
    }
}