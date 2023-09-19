import mayflower.*;

public class MazeEnemy extends AnimatedActor2 {
    private Animation animation;
    private boolean isUp;
    private double add;
    private int direction;
    
    public MazeEnemy(double scale, int direction) {
        if (isTouching(Block.class)) {
            setLocation(getX() - 1, getY());
        }
        if (isTouching(Block.class)) {
            setLocation(getX() + 2, getY());
        }
        System.out.println(isTouching(Block.class));
        String[] imgFiles = new String[10];
        for (int i = 0; i < imgFiles.length; i++) {
            imgFiles[i] = "img/ninjagirl/Run__00" + i + ".png";
        }
        
        String[] attackImgFiles = new String[10];
        for (int i = 0; i < imgFiles.length; i++) {
            attackImgFiles[i] = "img/ninjagirl/Run__00" + i + ".png";
        }
        
        
        animation = new Animation(50, imgFiles);
        animation.scale(scale);
        animation.setTransparency(5);
        setAnimation(animation);
        add = 0;
        this.direction = direction;
    }
    
    public void act() {
        super.act();
        
        if (isTouching(Cat.class)) {
            // decrease health
            
        }
        
        if (isTouching(Block.class) && add == 0) {
            isUp = !isUp;
            add = 0;
            System.out.println(isUp);
        }
        
        add += isUp ? .5 : -.5;
        if ((int) Math.abs(add) == Math.abs(add)) {
            if (direction == 1)
                setLocation(getX(), getY() + add);
            else
                setLocation(getX() + add, getY());
            add = 0;
        }
    }
}