import java.util.Scanner;

public class DisplayText {
    public static void main(String[] args){
        int width = 41;
        int height = 41;
        Environment environ = new Environment(width,height,10,10,10);
        Scanner stdin = new Scanner(System.in);
        boolean[][] data;
        while(stdin.hasNext()){
            if(stdin.next().toLowerCase().equals("refresh")){
                data = environ.refreshTable();
                System.out.println();
                for(int x=0;x<width;x++){
                    for(int y=0;y<height;y++){
                        if(data[y][x])
                            System.out.print("0");
                        else
                            System.out.print(" ");
                    }
                    System.out.println();
                }
            }
            if(stdin.next().toLowerCase().equals("polygon")){
                environ.addPolygon(new Polygon(new Point(stdin.nextDouble(),stdin.nextDouble(),stdin.nextDouble()), new Point(stdin.nextDouble(),stdin.nextDouble(),stdin.nextDouble()), new Point(stdin.nextDouble(),stdin.nextDouble(),stdin.nextDouble())));
            }
        }
    }
}