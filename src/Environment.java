import java.awt.Color;
import java.util.ArrayList;

public class Environment implements Updatable{
    //private ArrayList<Polygon> polygons;
    private Drawable polygon;
    private int width;
    private int height;
    private double windowWidth;
    private double windowHeight;
    private double windowDepth;
    private GraphicsPanel panel;
    private boolean xax;
    public Environment(int width, int height, double windowWidth, double windowHeight, double windowDepth,GraphicsPanel panel, Drawable polygon){
        this.polygon=polygon;
        setTable(width,height);
        setWindow(windowWidth,windowHeight,windowDepth);
        this.panel=panel;
        xax=false;
    }
    public void setTable(int width, int height){
        this.width=width;
        this.height=height;
    }
    public void setWindow(double width, double height){
        windowWidth=width;
        windowHeight=height;
    }
    public void setWindow(double width, double height, double depth){
        windowWidth=width;
        windowHeight=height;
        windowDepth=depth;
    }
    public Color[][] refreshImage(){
        Color[][] display = new Color[width][height];
        for(int x = 0; x<width; x++){
            for(int y = 0; y<height; y++){
                Point ray = new Point(0,0,0);
                ray=ray.makeRelative(new Point(x*windowWidth/(width-1)-windowWidth/2,y*windowHeight/(height-1)-windowHeight/2,windowDepth));
                display[x][y]=polygon.getPixel(ray);
            }
        }
        return display;
    }

    @Override
    public void update() {
        panel.passGraphics(refreshImage());
    }
}