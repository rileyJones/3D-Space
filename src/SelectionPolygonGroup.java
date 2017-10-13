import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class SelectionPolygonGroup extends Drawable{
    private HashMap<String,Drawable> polygonMap;
    private ArrayList<String> selectionStrings;
    private double magnitude;
    public SelectionPolygonGroup(double scale, Point textureOrigin, File imageLocation, double upSkew) {
        super(scale, textureOrigin, imageLocation, upSkew);
        polygonMap = new HashMap<String,Drawable>();
        selectionStrings = new ArrayList<String>();
        magnitude = -1;
    }
    public void put(String key,Drawable polygon){
        polygonMap.put(key,polygon);
    }
    public boolean add(String key){
        if(selectionStrings.indexOf(key)==-1) {
            selectionStrings.add(key);
            return true;
        }
        return false;
    }
    public boolean remove(String key){
        return selectionStrings.remove(key);
    }
    @Override
    public Color getPixel(Point ray) {
        double minMagnitude = Double.MAX_VALUE;
        Color pixel = Texture.BLANK_COLOR;
        for(String polygon : selectionStrings){
            Color tempPix= polygonMap.get(polygon).getPixel(ray);
            if(!tempPix.equals(Texture.BLANK_COLOR)) {
                if (polygonMap.get(polygon).magnitude(ray) < minMagnitude) {
                    minMagnitude=magnitude;
                    pixel=tempPix;
                }
            }
        }
        magnitude=minMagnitude;
        return pixel;
    }

    @Override
    public double magnitude(Point ray) {
        return magnitude;
    }
}
