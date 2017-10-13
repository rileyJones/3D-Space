import java.awt.*;
import java.io.File;

public class ForwardPolygon extends Drawable{   //Not supported with moving cameras currently
    public ForwardPolygon(double scale, Point textureOrigin, File imageLocation,double upSkew){
        super(scale,textureOrigin,imageLocation,upSkew);
    }
    @Override
    public Color getPixel(Point POI) {
        int height = image.getHeight();
        int width = image.getWidth();
        if(POI.get(0)<(textureOrigin.get(0)-width/2)*scale || POI.get(1)<(textureOrigin.get(1)-height/2)*scale || POI.get(0)>=(textureOrigin.get(0)+(width+1)/2)*scale || POI.get(1)>=(textureOrigin.get(1)+(height+1)/2)*scale)
            return Texture.BLANK_COLOR;
        return image.getPixel(upSkew,(POI.get(0)+(width/2-textureOrigin.get(0))*scale),(POI.get(1)+(height/2-textureOrigin.get(1))*scale));
    }

    @Override
    public double magnitude(Point ray) {
        return 0;
    }
}
