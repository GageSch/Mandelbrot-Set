import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
 
public class Mandelbrot extends JFrame {
	
	public static final int HEIGHT = 1000;
	public static final int WIDTH = 1000;
	public static final int X_MIN = -2;
	public static final int X_MAX = 2;
	public static final int Y_MIN = -2;
	public static final int Y_MAX = 2;
	public static final double XRATIO = (double) WIDTH/(X_MAX - X_MIN);
	public static final double YRATIO = (double) HEIGHT/(Y_MAX - Y_MIN);
	public static final int ITERATIONS = 1000;
	
	private final int REAL = 0;
	private final int COMPLEX = 570;
	
    private final int MAX_ITER = 1000;
    private final double ZOOM = 300;
    private BufferedImage I;
    private double zx, zy, cX, cY, tmp;
 
    public Mandelbrot() {
        super("Mandelbrot Set");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
            	double real = (x - WIDTH/2) / ZOOM;
            	double complex = (y - HEIGHT/2) / ZOOM;
            	Complex coord = new Complex(real, complex);
                int iter = MAX_ITER;
                while (coord.getReal() * coord.getReal() + coord.getComplex() * coord.getComplex() < 4 && iter > 0) {
                    coord.iterate();
                    iter--;
                }
                I.setRGB(x, y, iter | (iter << 8));
            }
        }
    }
 
    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }
 
    public static void main(String[] args) {
        new Mandelbrot().setVisible(true);
    }
}