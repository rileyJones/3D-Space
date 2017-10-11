import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class GraphicsPanel extends JPanel implements Runnable, Updatable {
    private int pixelWidth;
    private int pixelHeight;
    private Color[][] graphicsArray;
    private JFrame window;
    public GraphicsPanel(int width, int height){
        super();
        pixelWidth = width;
        pixelHeight = height;
        graphicsArray=null;
    }
    public void setScale(int width, int height){
        pixelWidth = width;
        pixelHeight = height;
    }
    public void resize(int scale){
        window.setSize(pixelWidth*scale,pixelHeight*scale);
    }
    public void setHeight(int height){
        pixelHeight = height;
    }
    public void setWidth(int width){
        pixelWidth = width;
    }
    public void passGraphics(Color[][] g){
        graphicsArray = g;
    }
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        if(graphicsArray!=null) {
            int width = this.getWidth();
            int height = this.getHeight();
            int scaleWidth = width / pixelWidth;
            int scaleHeight = height / pixelHeight;
            for (int x = 0; x < pixelWidth; x++) {
                for (int y = 0; y < pixelHeight; y++) {
                    g2d.setColor(graphicsArray[x][y]);
                    g2d.fill(new Rectangle(x * scaleWidth, y * scaleHeight, scaleWidth, scaleHeight));
                }
            }
        }
    }

    @Override
    public void run() {
        window = new JFrame();
        window.setSize(pixelWidth,pixelHeight);
        //window.setResizable(false);
        window.add(this);
        window.setVisible(true);
    }

    @Override
    public void update() {
        SwingUtilities.invokeLater( new Runnable(){
            @Override
            public void run() {
                repaint();
            }
        });
    }
}

