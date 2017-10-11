import java.io.File;

public class Startup {
    public static void main(String[] args) {
        int width = 720;
        int height = 480;
        GraphicsPanel window = new GraphicsPanel(width, height);
        Environment environ = new Environment(width,height,20,20,10,window);
        Point primary = new Point(0,5,20);
        Point extra1 = new Point(-12,-12,20);
        Point extra2 = new Point(12,-12,20);
        Point vector3 = extra1.makeRelative(extra2);
        Point upVector=extra1.add(vector3.multiply(.5)).makeRelative(primary).multiply(-.5);
        File imageLocation =new File("insert file location here");
        Polygon main = new Polygon(primary,extra1,extra2,25,extra1.add(vector3.multiply(.1)),imageLocation,1);
        environ.addPolygon(main);
        new Thread(window).start();
        new Thread(new Timer(200,environ,window)).start();   //Pass objects in the order to be updated

    }
}
