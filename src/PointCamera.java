
public class PointCamera extends Camera {

    public PointCamera(Point base, Point direction, Point up, int width, int height, double windowWidth, double windowHeight, double distance) {
        super(base, direction, up, width, height, windowWidth, windowHeight, distance);
    }
    @Override
    public Point getRay(int x, int y){
        Point ray = side.multiply(x*windowWidth/(width-1)-windowWidth/2);
        ray = ray.add(up.multiply(y*windowHeight/(height-1)-windowHeight/2));
        ray= ray.add(direction.multiply(distance));
        return ray;
    }
}
