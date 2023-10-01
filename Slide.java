import mayflower.*;

public class Slide extends Actor
{

    public Slide(int x, int y)
    {
        MayflowerImage slide = new MayflowerImage("img/Tiles/slide.png");
        slide.scale(x,y);
        setImage(slide);
    }

    public void act() {

    }
}