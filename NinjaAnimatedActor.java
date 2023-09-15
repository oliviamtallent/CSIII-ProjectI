public class NinjaAnimatedActor extends AnimatedActor {
    private Animation animation;
    
    public NinjaAnimatedActor() {
        String[] imgFiles = new String[10];
        for (int i = 0; i < imgFiles.length; i++) {
            imgFiles[i] = "img/ninjagirl/Run__00" + i + ".png";
        }
        
        animation = new Animation(50, imgFiles);
        animation.scale(.6);
        animation.setTransparency(5);
        setAnimation(animation);;
    }

    public void act() {
        super.act();
    }
}
