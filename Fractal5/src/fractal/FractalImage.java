package fractal;

import java.awt.image.BufferedImage;

import tools.Info;

public class FractalImage
{
    private double SCALE, CENTER_X, CENTER_Y;
    private int WIDTH, HEIGHT;
    private Fractal fractal;
    private Shader shader;
    public FractalImage(Info info)
    {
	SCALE = (double)info.get("SCALE");
	CENTER_X = (double)info.get("CENTER_X");
	CENTER_Y = (double)info.get("CENTER_Y");
	WIDTH = (int)info.get("WIDTH");
	HEIGHT = (int)info.get("HEIGHT");
	
	SCALE *= 200;
	
	fractal = new Fractal(info);
	shader = new Shader(info);
    }
    
    private int[][] getEscapeValues()
    {
	int[][] values = new int[HEIGHT][WIDTH];
	for (int y = 0; y < HEIGHT; y++)
	{
	    for (int x = 0; x < WIDTH; x++)
	    {
		Complex c = new Complex(toCartX(x), toCartY(y));
		values[y][x] = fractal.getEscapeTime(c);
	    }
	}
	return values;
    }
    
    public BufferedImage getImage()
    {
	int[][] values = getEscapeValues();
	BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	for (int y = 0; y < HEIGHT; y++)
	{
	    for (int x = 0; x < WIDTH; x++)
	    {
		img.setRGB(x, y, shader.getColor(values[y][x]).getRGB());
	    }
	}
	return img;
    }
    
    public double toCartX(int x) 
    {
	return (x - WIDTH / 2) / SCALE + CENTER_X;
    }    
    public double toCartY(int y)
    {	
	return (HEIGHT / 2 - y) / SCALE + CENTER_Y;
    }
}
