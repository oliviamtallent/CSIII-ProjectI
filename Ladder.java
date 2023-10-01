import mayflower.*;

public class Ladder extends Actor
{

    public Ladder(int x, int y)
    {
        MayflowerImage ladder = new MayflowerImage("img/Tiles/ladder.png");
        ladder.scale(x,y);
        setImage(ladder);
    }

    public void act() {

    }
}
