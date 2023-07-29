package fractal;

public class Complex
{
    private double re, im;
    public Complex(double re, double im)
    {
	this.re = re;
	this.im = im;
    }
    
    public Complex add(Complex c)
    {	
	return new Complex(re + c.re, im + c.im);
    }
    
    public Complex square()
    {
	return new Complex(re * re - im * im, 2 * re * im);
    }
    
    public double dist()
    {
	return Math.sqrt(re * re + im * im);
    }
    
    public String toString()
    {
	return re + ", " + im; 
    }
    
    public Complex multiply(Complex c)
    {
	return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }
    
    public Complex divide(Complex c)
    {
	double denom = c.re * c.re + c.im * c.im;
	return new Complex((re * c.re + + im * c.im) / denom, (im * c.re - re * c.im) / denom);
    }
    
    public Complex pow(double exp)
    {
	double theta = Math.atan2(im, re);
	double dist = dist();
	re = Math.pow(dist, exp) * Math.cos(theta * exp);
	im = Math.pow(dist, exp) * Math.sin(theta * exp);
	return new Complex(re, im);
    }
}
