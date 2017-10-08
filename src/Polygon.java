import java.util.ArrayList;

public class Polygon {
    private Point primary;
    private Point extra1;
    private Point extra2;
    private Point normal;
    private Point vector1;
    private Point vector2;
    private Point vector3;	// From extra1 to extra2
    public Polygon(Point primary, Point extra1, Point extra2){
        this.primary = primary;
        this.extra1 = extra1;
        this.extra2 = extra2;
        setVectors();
        setNormal();
    }
    public Polygon(ArrayList<Point> points){
        this.primary = points.get(1);
        this.extra1 = points.get(2);
        this.extra2 = points.get(3);
        setVectors();
        setNormal();
    }
    private void setVectors(){
        vector1=primary.makeRelative(extra1);
        vector2=primary.makeRelative(extra2);
        vector3=extra1.makeRelative(extra2);
    }
    private void setNormal(){
        normal = Polygon.crossProduct(vector1,vector2);
    }
    public Point POI(Point ray){
        double d =Polygon.dotProduct(primary,normal) / Polygon.dotProduct(ray,normal);
        return new Point(ray.get(1)*d,ray.get(2)*d,ray.get(3)*d);
    }
    public boolean isInside(Point POI){
        ArrayList<Point> quickPoints = new ArrayList<Point>();
        quickPoints.add(POI.makeRelative(extra1));
        quickPoints.add(POI.makeRelative(extra2));
        quickPoints.add(POI.makeRelative(primary));
        double sum = 0;
        for(int x=0;x<3;x++){
            double numerator = Polygon.dotProduct(quickPoints.get((x-1+3)%3),quickPoints.get(x));
            double denominator = quickPoints.get((x-1+3)%3).magnitude()*quickPoints.get(x).magnitude();
            double angle = Math.acos(numerator/denominator);
            sum+=angle;
        }
        return (sum>=Math.PI*.95*2)&&(sum<=Math.PI*1.05*2);
    }
    public static Point crossProduct(Point vector1,Point vector2){
        double numerator = Polygon.dotProduct(vector1,vector2);
        double denominator = vector1.magnitude()*vector2.magnitude();
        double angle = Math.sin(Math.acos(numerator/denominator));
        return new Point(angle*(vector1.get(2)*vector2.get(3)-vector1.get(3)*vector2.get(2)),-1*angle*(vector1.get(1)*vector2.get(3)-vector1.get(3)*vector2.get(1)),angle*(vector1.get(1)*vector2.get(2)-vector1.get(2)*vector2.get(1)));
    }
    public static double dotProduct(Point vector1, Point vector2){
        return vector1.get(1)*vector2.get(1)+vector1.get(2)*vector2.get(2)+vector1.get(3)*vector2.get(3);
    }
}