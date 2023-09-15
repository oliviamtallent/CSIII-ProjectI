public class JackAnimatedActor extends AnimatedActor {
    private Animation animation;
    
    public JackAnimatedActor() {
        String[] imgFiles = new String[7];
        for (int i = 0; i < imgFiles.length; i++) {
            imgFiles[i] = "img/jack/Walk (" + (i + 1) + ").png";
        }
        
        animation = new Animation(50, imgFiles);
        animation.scale(.55);
        animation.setTransparency(25);
        setAnimation(animation);
    }

    public void act() {
        super.act();
    }
}
