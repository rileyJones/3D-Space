import java.awt.Color;
import java.util.ArrayList;

public class Environment implements Updatable{
    //private ArrayList<Polygon> polygons;
    private Drawable polygon;
    private Camera viewPort;
    private GraphicsPanel panel;
    private boolean xax;
    public Environment(Point cameraBase, Point cameraDirection, Point cameraUp, int width, int height, double windowWidth, double windowHeight, double windowDepth,GraphicsPanel panel, Drawable polygon){
        this.polygon=polygon;
        viewPort = new Camera(cameraBase, cameraDirection, cameraUp, width, height, windowWidth, windowHeight, windowDepth);
        this.panel=panel;
        xax=false;
    }
    public Environment(Camera viewPort,GraphicsPanel panel, Drawable polygon){
        this.polygon=polygon;
        this.viewPort=viewPort;
        this.panel=panel;
        xax=false;
    }
    public Color[][] refreshImage(){
        Color[][] display = new Color[viewPort.getWidth()][viewPort.getHeight()];
        for(int x = 0; x<viewPort.getWidth(); x++){
            for(int y = 0; y<viewPort.getHeight(); y++){
                display[x][y]=polygon.getPixel(viewPort.getRay(x,y),viewPort.getBase());
            }
        }
        return display;
    }

    @Override
    public void update() {
        panel.passGraphics(refreshImage());
    }
}