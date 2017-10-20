public class ForwardCamera extends Camera{
    public ForwardCamera(Point base, Point direction, Point up, int width, int height, double windowWidth, double windowHeight, double distance) {
        super(base, direction, up, width, height, windowWidth, windowHeight, distance);
    }

    @Override
    public Point getRay(int x, int y) {
        return direction;
    }
}
