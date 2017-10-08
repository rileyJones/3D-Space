import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Texture{
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
    public Color getPixel(int x, int y){
        if(!(x<0||y<0||x>=width||y>=height)){
            return new Color(image.getRGB(x,height-y-1));
        }
        return new Color(100,200,255);
    }
}
