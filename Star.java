import mayflower.*;
public class Star extends Actor
{

    public Star()
    {
        MayflowerImage star = new MayflowerImage("img/Object/star.png");
        star.scale(25,25);
        setImage(star);
    }

    public void act() {
        if(isTouching(Cat.class)) {
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            getWorld().removeObject(this);
            Mayflower.setWorld(new MyWorld());
        }
    }
}
