package fractal;

import tools.Info;

public class Fractal
{
    private int MAX_ITERATION;
    public Fractal(Info info)
    {
	MAX_ITERATION = (int)info.get("MAX_ITERATION");
    }
    
    public int getEscapeTime(Complex c)
    {
	int escapeIter = 0;
	Complex z = new Complex(0, 0);
	for (int iter = 0; iter < MAX_ITERATION; iter++)
	{
	    //formula
	    z = z.square();
	    z = z.add(c);
	    if (z.dist() > 2 || iter == MAX_ITERATION - 1)
	    {
		escapeIter = iter;
		break;
	    }
	}
	//if in set, return MAX_ITERATION - 1, if out of set return 0
	return escapeIter;
    }
    
    //todo: add julia set
}
