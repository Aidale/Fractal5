package fractal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tools.Info;

public class Shader
{
    private boolean FILL_BLACK;
    private double R_FACTOR, G_FACTOR, B_FACTOR;
    private int MAX_ITERATION, COLOR_PERIOD, COLOR_OFFSET;
    private String PALETTE_PATH;
    private Color[] COLORS, BASE;
    public Shader(Info info)
    {
	FILL_BLACK = (boolean)info.get("FILL_BLACK");
	R_FACTOR = (double)info.get("R_FACTOR");
	G_FACTOR = (double)info.get("G_FACTOR");
	B_FACTOR = (double)info.get("B_FACTOR");
	MAX_ITERATION = (int)info.get("MAX_ITERATION");
	COLOR_PERIOD = (int)info.get("COLOR_PERIOD");
	COLOR_OFFSET = (int)info.get("COLOR_OFFSET");
	PALETTE_PATH = (String)info.get("PALETTE_PATH");
	
	generateBase();
	generatePalette();
    }
    
    public Color getColor(int iter)
    {
	if (FILL_BLACK && iter == MAX_ITERATION - 1) return Color.black;
	
	return COLORS[(iter + COLOR_OFFSET) % COLORS.length];
    }
    
    private void generateBase()
    {
	BufferedImage palette;
	try
	{
	    palette = ImageIO.read(new File(PALETTE_PATH));
	}
	catch (IOException ex) 
	{
	    System.out.println("Error fetching palette image.");
	    return;
	}
	
	BASE = new Color[palette.getWidth()];
	for (int i = 0; i < BASE.length; i++)
	{
	    BASE[i] = new Color(palette.getRGB(i, 0));
	}
    }
    
    private void generatePalette()
    {
	int colorsPerBase = COLOR_PERIOD / BASE.length;
	int totalColors = colorsPerBase * BASE.length;
	int index = 0;
	
	COLORS = new Color[totalColors];
	for (int i = 0; i < BASE.length; i++)
	{
	    Color base1 = BASE[i];
	    Color base2 = BASE[(i + 1) % BASE.length];
	    
	    double dr = (base2.getRed() - base1.getRed()) / (double)colorsPerBase;
	    double dg = (base2.getGreen() - base1.getGreen()) / (double)colorsPerBase;
	    double db = (base2.getBlue() - base1.getBlue()) / (double)colorsPerBase;

	    double r = base1.getRed();
	    double g = base1.getGreen();
	    double b = base1.getBlue();
	    for (int j = 0; j < colorsPerBase; j++)
	    {
		COLORS[index] = processColor(r, g, b);
		r += dr;
		g += dg;
		b += db;
		
		index++;
	    }
	}
    }
    
    private Color processColor(double r, double g, double b)
    {
	if (R_FACTOR < 0) r = (255 - r);
	if (G_FACTOR < 0) g = (255 - g);
	if (B_FACTOR < 0) b = (255 - b);
	
	int ir = colorBound(r / Math.abs(R_FACTOR));
	int ig = colorBound(g / Math.abs(G_FACTOR));
	int ib = colorBound(b / Math.abs(B_FACTOR));
	return new Color(ir, ig, ib);
    }
    
    private int colorBound(double d)
    {
	int x = (int)d;
	return x > 255 ? 255 : x < 0 ? 0 : x;
    }
}