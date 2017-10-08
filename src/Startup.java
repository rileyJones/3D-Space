public class Startup {
    public static void main(String[] args) {
        GraphicsPanel window = new GraphicsPanel(50, 50);
        new Thread(window).start();
        new Thread(new Timer(200,window)).start();   //Pass objects in the order to be updated
    }
}
