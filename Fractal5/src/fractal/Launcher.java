package fractal;

import java.awt.EventQueue;

import tools.Info;

public class Launcher
{
    public static void main(String[] args)
    {
	Info info = readInfo();
	Settings.mainImage(info);
//	Animation.mainAnimation(info);
    }
    
    public static Info readInfo()
    {
	Info info = new Info();
	try
	{
	    info.readFile("C:\\Users\\Aidan\\Documents\\Fractal\\fields.txt");
	}
	catch (Exception ex)
	{
	    System.out.println("Fields could not be read");
	}
	return info;
    }
}
