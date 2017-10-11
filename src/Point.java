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
        return vector[index];
    }
    public Point makeRelative(Point x){
        return new Point(x.get(0)-vector[0],x.get(1)-vector[1],x.get(2)-vector[2]);
    }
    public double magnitude(){
        return Math.sqrt(Math.pow(vector[0],2)+Math.pow(vector[1],2)+Math.pow(vector[2],2));
    }
    public Point multiply(double constant){
        return new Point(
        vector[0]*constant,
        vector[1]*constant,
        vector[2]*constant);
    }
    public Point add(Point relativeVector){
        return new Point(
        vector[0]+relativeVector.get(0),
        vector[1]+relativeVector.get(1),
        vector[2]+relativeVector.get(2));
    }
}
