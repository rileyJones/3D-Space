import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

public class AllPolygonGroup extends Drawable{
    private ArrayList<Drawable> polygons;
    private double magnitude;
    public AllPolygonGroup(double scale, Point textureOrigin, File imageLocation, double upSkew) {
        super(scale, textureOrigin, imageLocation, upSkew);
        polygons = new ArrayList<Drawable>();
        magnitude=-1;
    }
    public void AddDrawable(Drawable polygon){
        polygons.add(polygon);
    }
    @Override
    public Color getPixel(Point ray,Point base) {
        double minMagnitude = Double.MAX_VALUE;
        Color pixel = Texture.BLANK_COLOR;
        for(Drawable polygon : polygons){
            Color tempPix= polygon.getPixel(ray,base);
            if(!tempPix.equals(Texture.BLANK_COLOR)) {
                if (polygon.magnitude(ray,base) < minMagnitude) {
                    minMagnitude=magnitude;
                    pixel=tempPix;
                }
            }
        }
        magnitude=minMagnitude;
        return pixel;
    }

    @Override
    public double magnitude(Point ray, Point base) {
        return magnitude;
    }
}
