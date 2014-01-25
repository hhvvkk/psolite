package hhvvkk.psolite;


public class Particle   {
	
	//POSITION
	private double x[];
	
	//VELOCITY
	private double v[];
	
	//PERSONAL BEST(FITNESS) = bestPerformance
	private double pBest;
	
	//FITNESS = Performance
	private double fitness;
	
	Particle(){
		fitness = 10;
	}
	
	public void setData(double [] xVal, double [] vVal){
		x = xVal;
		v = vVal;
	}
	
	/**
	* Returns the position of the particle in the space
	* @return Position of particle(x)
	*/
	public double []getPosition(){
		return x;
	}
	
	
	public void move(){
		for(int i = 0; i < x.length; i++){
			x[i] = x[i] + v[i] ;
		}
	}
	
	
	public void updateFitness(double newValue, boolean maximize){
		if(maximize == true){
                    if(fitness > pBest){
                        fitness = newValue;
                    }
                }
                else{ // minimize
                    if(fitness > pBest){
                        fitness = newValue;
                    }
                }
                        
	}
	
}