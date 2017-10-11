import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Texture{
    public static Color BLANK_COLOR = new Color(255, 0, 255);
    private int height;
    private int width;
    private BufferedImage image;
    public Texture(File imageLocation){
        try {
            image = ImageIO.read(imageLocation);
            height = image.getHeight();
            width = image.getWidth();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public Color getPixel(double upSkew, double xA, double yA){
        int x=(int) (xA*Math.cos(upSkew*2*Math.PI)+yA*Math.sin(upSkew*2*Math.PI));
        int y= (int) (yA*Math.cos(upSkew*2*Math.PI)+xA*Math.sin(upSkew*2*Math.PI));
        if(!(x<0||y<0||x>=width||y>=height)){
            return new Color(image.getRGB(x,height-y-1));
        }
        return BLANK_COLOR;
    }
}
