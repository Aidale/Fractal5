package fractal;

import java.awt.image.BufferedImage;

import tools.Giffer;
import tools.Info;

public class Animation
{
    public static void mainAnimation(Info info)
    {
	Animation animation = new Animation(info);
    }
    
    private Info info;
    private FractalImage fractalImage;
    private int FRAME_COUNT, DELAY;
    private String SAVE_GIF_PATH;
    public Animation(Info info)
    {
	this.info = info;
	FRAME_COUNT = (int)info.get("FRAME_COUNT");
	DELAY = (int)info.get("DELAY");
	SAVE_GIF_PATH = (String)info.get("SAVE_GIF_PATH");
	
	generateGIF(generateFrames());
    }
    
    private BufferedImage[] generateFrames()
    {
	BufferedImage[] frames = new BufferedImage[FRAME_COUNT];
	
	for (int i = 0; i < frames.length; i++)
	{
	    fractalImage = new FractalImage(info);
	    frames[i] = fractalImage.getImage();
	    alterInfo();
	    System.out.println(i + "/" + FRAME_COUNT);
	}
	
	return frames;
    }
    
    private void alterInfo()
    {
	double SCALE = (double)info.get("SCALE");
//	int WIDTH = (int)info.get("WIDTH");
	SCALE *= 1.06;
	
//	double CENTER_X = WIDTH / (400 * SCALE) - 1.5555596575;
	
//	info.set("CENTER_X", CENTER_X);
	info.set("SCALE", SCALE);
    }
    
    private void generateGIF(BufferedImage[] frames)
    {
	System.out.println("\nFrames generated. Converting to GIF format.");
	try
	{
	    Giffer.generateFromBI(frames, SAVE_GIF_PATH, 4, true);
	    System.out.println("GIF generated. View GIF file.");
	}
	catch (Exception e)
	{
	    System.out.println("Online code didn't work.");	
	    e.printStackTrace();
	}
    }
}
