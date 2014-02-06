package hhvvkk.psolite;

import java.util.ArrayList;


public class Particle   {
        
	private ArrayList<Particle>neighborhood = new ArrayList<Particle>();
        
	//POSITION
	private double x[] = null;
	
	//VELOCITY
	private double v[] = null;
	
	//PERSONAL BEST(FITNESS) = bestPerformance
	private double pBest;
	
	//FITNESS = Performance
	private double fitness;
	
	Particle(){
		fitness = 10;
	}
	
        /**
         * Adds a neighbor to this particle's neighborhood
         * @param newNeighbour : The new neighbor to add to this particle neighborhood
         */
        public void addNeighbour(Particle newNeighbour){
                if(newNeighbour == this){
                        return;
                        //do not add self
                }
                
                neighborhood.add(newNeighbour);
        }
        
        /**
         * Sets the particle position values and velocity values
         * @param xVal : The position values
         * @param vVal : The velocity values
         */
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
	
	/**
	* Move the particle for each dimension value the amount of the velocity
	*/
	public void move(){
		for(int i = 0; i < x.length; i++){
			x[i] = x[i] + v[i] ;
		}
	}
	
        
	
	/**
	* Get the fitness of the particle currently
        * @return Return fitness of the particle currently
	*/
        public double getFitness(){
                return fitness;
        }
        
        
	/**
	* Gets the personal best of this particle so far
        * @return Return the personal best pBest for the particle
	*/
        public double getPBest(){
                return pBest;
        }
        
	/**
	* Update the fitness for the particle by the new value specified
        * @param newValue : The new fitness value that has been updated
        * @param maximize : A boolean indicating whether the particle strive towards maximum fitness or minimum fitness
	*/
	public void updateFitness(double newValue, boolean maximize){
                fitness = newValue;
		if(maximize == true){
                    if(fitness > pBest){
                        pBest = newValue;
                    }
                }
                else{ // minimize
                    if(fitness < pBest){
                        pBest = newValue;
                    }
                }
                        
	}
	
}