public class Point {
    private double[] vector;
    private boolean isRelative;
    public Point(double[] vector){
        this.vector=vector;
    }
    public Point(double x, double y, double z){
        vector = new double[3];
        vector[0] = x;
        vector[1] = y;
        vector[2] = z;
    }
    public double[] getVector(){
        return vector;
    }
    public double get(int index){
        return vector[index-1];
    }
    public Point makeRelative(Point x){
        return new Point(x.get(1)-vector[0],x.get(2)-vector[1],x.get(3)-vector[2]);
    }
    public double magnitude(){
        return Math.sqrt(Math.pow(vector[0],2)+Math.pow(vector[1],2)+Math.pow(vector[2],2));
    }
}
