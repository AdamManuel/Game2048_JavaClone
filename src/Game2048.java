import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;


public class Game2048 
{
    public static void Start()
    {
        //Set Name
        JFrame frame = new JFrame("2048 - Adam Manuel");
        //Set Icon
        try {
            frame.setIconImage(ImageIO.read(Game2048.class.getResourceAsStream("resources/Tile1024.png")));
        } catch (IOException ex) {
            Logger.getLogger(Game2048.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setSize(605, 625);
        JApplet applet = new GUI();
        applet.init();
        applet.start();
        frame.add(applet);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
