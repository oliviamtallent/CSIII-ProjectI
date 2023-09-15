public class DogAnimatedActor extends AnimatedActor {
    private Animation animation;
    
    public DogAnimatedActor() {
        String[] imgFiles = new String[10];
        
        for (int i = 0; i < imgFiles.length; i++) {
            imgFiles[i] = "img/dog/Walk (" + (i + 1) + ").png";
        }
        
        animation = new Animation(50, imgFiles);
        animation.scale(200, 174);
        animation.setTransparency(75);
        setAnimation(animation);
    }
    
    public void act() {
        super.act();
    }
}
