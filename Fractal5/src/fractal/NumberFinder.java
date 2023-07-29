package fractal;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class NumberFinder implements MouseListener
{   
    private JFrame jframe;
    private FractalImage fractalImage;
    public NumberFinder()
    {
	
    }
    public void addJFrame(JFrame jframe)
    {
	this.jframe = jframe;
    }
    public void addFractal(FractalImage fractalImage)
    {
	this.fractalImage = fractalImage;
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
	Point frame = jframe.getLocation();
    	Point mouse = MouseInfo.getPointerInfo().getLocation();
    	double x = fractalImage.toCartX((int)(mouse.getX() - frame.getX()) - 8);
    	double y = fractalImage.toCartY((int)(mouse.getY() - frame.getY()) - 31);
    	System.out.println(x + ", " + y);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
	
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
	
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
	
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
	
    }
}
