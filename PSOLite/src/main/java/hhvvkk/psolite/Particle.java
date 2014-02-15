package hhvvkk.psolite;

import java.util.ArrayList;
import java.util.Random;


public class Particle   {
        
	private ArrayList<Integer>neighborhood = new ArrayList<Integer>();
        
        //INNERTIA WEIGHT
        double inertiaWeight = 0.72;
        
        //C1 - OWN VALUES
        double c1 = 1.4;
        double c1MinValue = 0.5;//The value c1 will be reduced to if it is reduced
        
        //C2 - NEIGHBORHOOD VALUES
        double c2 = 1.4;
        double c2MinValue = 0.5;//The value c2 will be reduced to if it is reduced
        
        //A DOUBLE USED TO REDUCE THE C1 VALUE
        double reduceC1Value = 0;
        
        //A DOUBLE USED TO REDUCE THE C2 VALUE
        double reduceC2Value = 0;
        
        
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
        
        //RANDOM for updating velocity
        Random r = new Random();
        
        boolean reduceC1C2Values = false;
	
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
         * Sets the inertia weight to the selected value
         * @param newInertia : The new inertia weight
         */
        public void setInertiaWeight(double newInertia){
                inertiaWeight = newInertia;
        }
        
        /**
         * Sets the c1 value(The amount of influence old values has)
         * @param newC1 : The new c1 value
         */
        public void setC1(double newC1){
                c1 = newC1;
        }
        
        
        /**
         * Sets the c2 value(The amount of influence neighborhood values has)
         * @param newC2 : The new c2 value
         */
        public void setC2(double newC2){
                c2 = newC2;
        }
        
        /**
         * A function to set the amount of steps must be taken to reach the minimum c1 value and minimum c2 value
         * @param amountSteps : The amount of steps before minimum reached
         * @param minimumC1Value : the minimum value for c1
         * @param minimumC2Value : the minimum value for c2
         */
        public void setReductionAmount(int amountSteps, double minimumC1Value, double minimumC2Value){
                //asdasf
           // asfasfcalculate amount
                c1MinValue = minimumC1Value;
                c2MinValue = minimumC2Value;
                
                
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
         * Update velocity values using the swarm to find neighbors for values
         * @param swarm : The 
         */
        public void updateVelocity(PSOSwarm swarm, boolean maximize){
            
                //find the best in the neighbourhood
                double []neighbourhoodBestX = null;
                
                //if it does not find a neighbourhood(no neighbours) then just use normal update
                if(neighborhood.isEmpty()){
                    
                        for(int i = 0; i < x.length; i++){
                                double r1 = 0.1+r.nextDouble()*0.8;
                                double newVelocity = inertiaWeight*v[i] + r1*c1*(xPbest[i] - x[i]);
                                v[i] = newVelocity;
                        }
                        return;
                }
                
                //create the value holding the neighbourhood best values
                neighbourhoodBestX = new double[x.length];
                
                //a boolean indicating if the first value was set or not
                boolean justStarted = true;
                double currentBest = 0;
                
                //find the best in the neighborhood
                for(int i = 0; i < neighborhood.size(); i++){
                        int neighbourIndex = neighborhood.get(i);
                        
                        Particle neighbour = swarm.get(neighbourIndex);
                        
                        if(justStarted == true){
                                currentBest = neighbour.getPBest();
                                neighbourhoodBestX = neighbour.getBestPosition();
                        }
                        else{//if it has started check previous with next
                                //check to see if the new value is better
                                if(maximize == true){
                                        if(currentBest > neighbour.getPBest()){
                                                currentBest = neighbour.getPBest();
                                                neighbourhoodBestX = neighbour.getBestPosition();                                                
                                        }
                                }
                                else{ // minimize
                                        if(currentBest < neighbour.getPBest()){
                                                currentBest = neighbour.getPBest();
                                                neighbourhoodBestX = neighbour.getBestPosition();                                                
                                        }
                                }
                        }
                }
                
                if(neighbourhoodBestX == null)
                        return;
                
                for(int i = 0; i < x.length; i++){
                        double r1 = 0.1+r.nextDouble()*0.8;
                        double r2 = 0.1+r.nextDouble()*0.8;
                        double newVelocity = inertiaWeight*v[i] + r1*c1*(xPbest[i] - x[i]) + r2*c2*(neighbourhoodBestX[i] - x[i]);
                        v[i] = newVelocity;
                }
                
                //finally check if the c1 & c2 values needs to change(It can be changed over time)
                if(reduceC1C2Values){
                        reduceTheC1C2Values();
                }
                
        }
        
        /**
         * A function to reduce the values of c1 and c2 in order to try and ensure convergence of the particles
         */        
        private void reduceTheC1C2Values(){
                //reduce values
                c1 = c1 - reduceC1Value;
                if(c1 < c1MinValue){
                        reduceC1C2Values = false;
                        c1 = c1MinValue;
                }
                
                c2 = c2 - reduceC2Value;
                if(c2 < c2MinValue){
                        reduceC1C2Values = false;
                        c2 = c2MinValue;
                }
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