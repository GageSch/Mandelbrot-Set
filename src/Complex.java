
public class Complex {
	
	private double real = 0;
    private double complex = 0;
    private double realC;
    private double complexC;
    
	public Complex(double x, double y) {
		realC = x;
		complexC = y;
    }
	
	public void iterate() {
		double newReal = (real*real) - (complex*complex) + realC;
		double newComplex = 2 * (real*complex) + complexC;
		real = newReal;
		complex = newComplex;
	}
	
	public double getReal() {
		return real;
	}
	
	public double getComplex() {
		return complex;
	}
}
