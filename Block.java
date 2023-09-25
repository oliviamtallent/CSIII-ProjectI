import mayflower.*;

public class Block extends Actor {
    public Block(int tile) {
        MayflowerImage block = new MayflowerImage("img/Tiles/"+ tile + ".png");
        block.scale(16, 16);
        setImage(block);
    }
    
    public Block(int tile, int scale) {
        MayflowerImage block = new MayflowerImage("img/Tiles/"+ tile + ".png");
        block.scale(100, 100); //scale, scale
        setImage(block);
    }
    
    public Block(String file) {
        MayflowerImage block = new MayflowerImage(file);
        block.scale(16, 16);
        setImage(block);
    }
    
    public void act() {
    }
}