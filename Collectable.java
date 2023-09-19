
import mayflower.*;

public class Collectable extends Actor {
    private String id;
    public Collectable(String file) {
        id = file;
        MayflowerImage item = new MayflowerImage("img/Object/"+file+".png");
        item.scale(16, 16);
        setImage(item);
    }
    
    public void act() {
        if (isTouching(Cat.class)) {
            // collect object
            setImage("");
        }
    }
}
