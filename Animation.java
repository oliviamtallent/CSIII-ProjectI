import mayflower.*;

public class Animation {
    private MayflowerImage[] frames;
    private int frameRate;
    private int currentFrame;
    
    public Animation(int frameRate, String[] imgFiles) 
    {
        this.frameRate = frameRate;
        frames = new MayflowerImage[imgFiles.length];
        for (int i = 0; i < imgFiles.length; i++) {
            frames[i] = new MayflowerImage(imgFiles[i]);
        }
    } 
    
    public int getFrameRate() {
        return frameRate;
    }
    
    public MayflowerImage getNextFrame() {
       MayflowerImage current = frames[currentFrame % frames.length];
       currentFrame++;
       return current;
    }
    
    public void scale(int w, int h) {
        for (MayflowerImage img : frames) {
            img.scale(w, h);
        }
    }
    
    public void scale(double scale) {
        for (MayflowerImage img : frames) {
            img.scale(scale);
        }
    }
    
    public void setTransparency(int percent) {
        for (MayflowerImage img : frames) {
            img.setTransparency(percent);
        }
    }
    
    public void mirrorHorizontally() {
        for (MayflowerImage img : frames) {
            img.mirrorHorizontally();
        }
    }
    
    public void setBounds(int x, int y, int w, int h) {
        for (MayflowerImage img : frames) {
            img.crop(x, y, w, h);
        }
    }
}