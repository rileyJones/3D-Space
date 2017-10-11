import java.awt.Color;
import java.io.File;

public abstract class Drawable{
    protected Point textureOrigin;
    protected Texture image;
    protected double scale;
    protected double upSkew;    //Angle the texture is off of directly up, measured clockwise and between 0 and 1
    public Drawable(double scale, Point textureOrigin, File imageLocation, double upSkew){
        this.scale = scale;
        this.textureOrigin=textureOrigin;
        image = new Texture(imageLocation);
        this.upSkew=upSkew;
    }
    public abstract Color getPixel(Point POI);

}
