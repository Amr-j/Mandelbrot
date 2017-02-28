public class Complex {
	
	private double re,im ;
	
	public Complex(double re, double im){
		this.re = re;
		this.im = im;
	}
	
	public double getRe(){
		return this.re;
	}
	public double getIm(){
		return this.im;
	}
	public double getAbs2(){
		return Math.pow(re, 2) + Math.pow(im, 2);
	}
	public void add(Complex c){
		re = re + c.re;
		im = im + c.im;
	}
	public void mul(Complex c){
		double retemp = (this.re * c.re) - (this.im * c.im);
		im = (this.re * c.im) + (this.im * c.re);
		re = retemp;
	}

}
