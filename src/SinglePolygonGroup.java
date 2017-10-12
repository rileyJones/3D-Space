import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class SinglePolygonGroup extends Drawable{
    private HashMap<String,Drawable> polygonMap;
    private String key;
    private double magnitude;
    public SinglePolygonGroup(double scale, Point textureOrigin, File imageLocation, double upSkew) {
        super(scale, textureOrigin, imageLocation, upSkew);
        polygonMap = new HashMap<String,Drawable>();
        key=null;
        magnitude = -1;
    }
    public void put(String key,Drawable polygon){
        polygonMap.put(key,polygon);
    }
    public void set(String key){
        this.key=key;
    }
    @Override
    public Color getPixel(Point ray) {
        return polygonMap.get(key).getPixel(ray);
    }

    @Override
    public double magnitude(Point ray) {
        return polygonMap.get(key).magnitude(ray);
    }
}
