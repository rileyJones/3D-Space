import java.io.File;

public class Startup {
    public static void main(String[] args) {
        int width = 720;
        int height = 480;
        GraphicsPanel window = new GraphicsPanel(width, height);
        Point primary = new Point(0,5,20);
        Point extra1 = new Point(-12,-12,20);
        Point extra2 = new Point(12,-12,20);
        Point vector3 = extra1.makeRelative(extra2);
        Point upVector=extra1.add(vector3.multiply(.5)).makeRelative(primary).multiply(-.5);
        File imageLocation =new File("Insert file directory here");
        Polygon main = new Polygon(primary,extra1,extra2,25,extra1.add(vector3.multiply(.1)),imageLocation,1);
        Point cameraBase = new Point(10,10,10);
        Point direction = new Point(-1,-1,1);
        Point up = new Point(-1,-1,-2);
        Camera viewPort = new PointCamera(cameraBase,direction,up,width,height,20,20,10);
        Environment environ = new Environment(viewPort,window,main);
        new Thread(window).start();
        new Thread(new Timer(200,environ,window)).start();   //Pass objects in the order to be updated

    }
}
