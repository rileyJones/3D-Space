public class Camera {
    private Point base;
    private Point direction;
    private Point up;
    private Point side;
    private double distance;
    private int width;
    private int height;
    private double windowWidth;
    private double windowHeight;
    public Camera(Point base, Point direction, Point up, int width, int height, double windowWidth, double windowHeight, double distance){
        this.base=base;
        this.direction=direction.multiply(1/direction.magnitude());
        this.up=up.multiply(1/up.magnitude());
        this.distance=distance;
        this.width=width;
        this.height=height;
        this.windowWidth=windowWidth;
        this.windowHeight=windowHeight;
        set90();
    }
    private void set90(){
        side = Polygon.crossProduct(direction, up);
        up=Polygon.crossProduct(side,direction);
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
        distance=depth;
    }
    public Point getRay(int x, int y){
        Point ray = side.multiply(x*windowWidth/(width-1)-windowWidth/2);
        ray = ray.add(up.multiply(y*windowHeight/(height-1)-windowHeight/2));
        ray= ray.add(direction.multiply(distance));
        return ray;
    }
    public Point getBase(){
        return base;
    }
    public Point getDirection(){
        return direction;
    }
    public Point getUp(){
        return up;
    }
    public void setBase(Point base){
        this.base=base;
    }
    public void setDirection(Point direction){
        this.direction=direction;
        set90();
    }
    public void setUp(Point up){
        this.up=up;
        set90();
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}
