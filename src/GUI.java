import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JApplet;

public class GUI extends JApplet implements KeyListener{

    
    Image Tiles[];
    Image youWin;
    Board board;
    public void init() 
    {
        Tiles = new Image[11];
        for (int i = 0; i < Tiles.length; i++) 
        {
            try {
                Tiles[i] = ImageIO.read(getClass().getResourceAsStream("resources/"+getTileName(i)));
            } catch (IOException e) 
            {
                System.err.println("Error: Error loading images");
            }
        }
        try
        {
            youWin = ImageIO.read(getClass().getResourceAsStream("resources/YouWin.png"));
        } catch (IOException e)
        {
            System.err.println("Error: Error loading images");
        }
        board = new Board();
        board.newBoard();
        this.addKeyListener(this);
        this.setFocusable(true);
    }
    
    private String getTileName(int num)
    {
        if(num == 0)
            return "Tile0.png";
        String toReturn = "Tile";
        int temp = 2;
        for (int i = 1; i < num; i++) {
            temp *=2;
        }
        toReturn+=temp;
        toReturn+=".png";
        return toReturn;
    }
    
    private int getTileNum(int num)
    {
        if(num == 0)
            return 0;
        int tot = 1;
        while(num != 2)
        {
            tot+=1;
            num/=2;
        }
        return tot;
    }
    
    public void paint(Graphics g)
    {
        if(board.hasWon())
        {
            g.drawImage(youWin, 0, 0, rootPane);
            this.repaint();
        }
        else
        {
            int tile = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    g.drawImage(Tiles[getTileNum(board.getTile(j, i))], i*150, j*150, rootPane);
                }
            }
            this.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) 
    {
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        switch(e.getKeyChar())
        {
            case 'w':board.Move('U');
                break;
            case 's':board.Move('D');
                break;
            case 'a':board.Move('L');
                break;
            case 'd':board.Move('R');
                break;
            case 'r':board.newBoard();
                break;
        }
        //up - 38 left - 37 right - 39 douwn - 40
        switch(e.getKeyCode())
        {
            case 38:board.Move('U');
                break;
            case 40:board.Move('D');
                break;
            case 37:board.Move('L');
                break;
            case 39:board.Move('R');
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
    }
}

