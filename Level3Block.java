import mayflower.*;

public class Level3Block extends Block 
{
    public Level3Block(int tile) 
    {
        super(tile);
        MayflowerImage block = new MayflowerImage("img/Tiles/"+ tile + ".png");
        block.scale(100, 100);
        setImage(block);
    }
    
    public void act() {
    }
}
