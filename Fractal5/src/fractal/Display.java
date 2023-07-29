package fractal;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display extends JPanel
{   
    private BufferedImage frame;
    public JFrame jframe;
    public Display(int WIDTH, int HEIGHT, NumberFinder numberFinder)
    {
	jframe = new JFrame("Fractal");
	jframe.setSize(WIDTH, HEIGHT);
	jframe.setResizable(false);	
	jframe.setVisible(true);	
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.add(this);
	jframe.addMouseListener(numberFinder);
	jframe.setIconImage((new ImageIcon("C:\\Users\\Aidan\\Pictures\\Fractals\\icon4.png")).getImage());
	jframe.setLocation(new Point(-1600, 0));
	numberFinder.addJFrame(jframe);
    }
    
    public void setImage(BufferedImage frame)
    {
	this.frame = frame;
    }
    
    public void paintComponent(Graphics g)
    {
	g.drawImage(frame, 0, 0, null);
    }
}
