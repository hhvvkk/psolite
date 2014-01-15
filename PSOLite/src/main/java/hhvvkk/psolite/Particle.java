package hhvvkk.psolite;


public class Particle   {
	
	//POSITION
	private double x[];
	
	//VELOCITY
	private double v[];
	
	//PERSONAL BEST
	private double pBest;
	
	//FITNESS
	private double fitness;
	
	Particle(){
		
	}
	
	public void setData(double [] xVal, double [] vVal){
		x = xVal;
		v = vVal;
	}
	
	
	public void move(){
		for(int i = 0; i < x.length; i++){
			x[i] = x[i] + v[i] ;
		}
	}
	
	public void updateFitness(){
		
	}
	
	public void print(){
		System.out.println("Printing");
		System.out.println("------------BEGIN");
		for(int i = 0; i < x.length; i++){
			System.out.println(x[i]);
		}
		System.out.println("-------------END");
	}
	
	
}