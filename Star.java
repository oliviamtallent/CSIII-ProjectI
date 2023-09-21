import mayflower.*;
public class Star extends Actor
{
    private String nextWorld;

    public Star(String next) {
        nextWorld = next;
        MayflowerImage star = new MayflowerImage("img/Object/star.png");
        star.scale(25,25);
        setImage(star);
    }

    public void act() {
        if(isTouching(MainCharacter.class) || isTouching(MazeMainCharacter.class)) {
            getWorld().removeObject(this);
            
            if (nextWorld == "Level1")
                Mayflower.setWorld(new Level1World());
            else if (nextWorld == "Level2")
                Mayflower.setWorld(new Level3World());
        }
    }
}