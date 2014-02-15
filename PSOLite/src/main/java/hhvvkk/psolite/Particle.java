package hhvvkk.psolite;

import java.util.ArrayList;


public class Particle   {
        
	private ArrayList<Integer>neighborhood = new ArrayList<Integer>();
        
	//POSITION
	private double x[] = null;
	
	//VELOCITY
	private double v[] = null;
	
	//PERSONAL BEST(FITNESS) = bestPerformance
	private double pBest;
        
        //PERSONAL BEST(POSITION)
        private double xPbest[] = null;
	
	//FITNESS = Performance
	private double fitness;
	
	Particle(){
		fitness = 10;
	}
	
        /**
         * Adds a neighbor to this particle's neighborhood using the index supplied
         * @param newNeighbourIndex : The new neighbor index to add to this particle neighborhood
         */
        public void addNeighbour(int newNeighbourIndex) throws IndexOutOfBoundsException{
                if(newNeighbourIndex < 0){
                        throw new IndexOutOfBoundsException("Adding a particle index must be within bounds ("+Integer.toString(newNeighbourIndex) +"");
                }
                
                //simply do not add something twice
                if(neighborhood.contains(newNeighbourIndex))
                        return;
                
                neighborhood.add(newNeighbourIndex);
        }
        
        /**
         * Removes a particle from the neighborhood
         * @param particleIndex : A particle index to be removed
         */
        public void removeNeighbour(int particleIndex){
                neighborhood.remove(particleIndex);
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
                double [] tempPosition = new double[x.length];
                
                System.arraycopy(x, 0, tempPosition, 0, tempPosition.length);
                
		return tempPosition;
	}
        
        /**
         * Gets the best position the particle was in at a previous stage
         * @return Return the double array of the best position of the particle
         */
        public double []getBestPosition(){
		double [] tempPosition = new double[xPbest.length];
                
                System.arraycopy(xPbest, 0, tempPosition, 0, tempPosition.length);
                
		return tempPosition;
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
                            xPbest = copyDouble(x);
                        }
                }
                else{ // minimize
                        if(fitness < pBest){
                            pBest = newValue;
                            xPbest = copyDouble(x);
                        }
                }
                        
	}
        
        /**
         * Copy a double array to a new array
         * @param valueToCopy The double array you want a new array of
         * @return Returns a new array of doubles with same values as the parameter value array
         */
        private double [] copyDouble(double []valueToCopy){
                double []doubleDuplicateInator = new double[valueToCopy.length];
                
                System.arraycopy(valueToCopy, 0, doubleDuplicateInator, 0, valueToCopy.length);
                
                return doubleDuplicateInator;
        }
	
}