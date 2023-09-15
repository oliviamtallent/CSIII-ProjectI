import mayflower.*;

public class Block extends Actor {
    public Block(int tile) {
        MayflowerImage block = new MayflowerImage("img/Tiles/"+ tile + ".png");
        block.scale(16, 16);
        setImage(block);
    }
    
    public void act() {
    }
}
