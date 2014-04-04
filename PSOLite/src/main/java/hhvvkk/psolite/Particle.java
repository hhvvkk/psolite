package hhvvkk.psolite;

import hhvvkk.velocityclamp.VelocityClamper;
import java.util.Random;


public class Particle   {
        
        //INNERTIA WEIGHT
        double w = 0.72;
        
        //C1 - OWN VALUES
        double c1 = 1.4;
        
        //C2 - NEIGHBORHOOD VALUES
        double c2 = 1.4;
        
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
        
        //The velocity clamper that will clamp the velocity values
        VelocityClamper vClamper = null;
	
	Particle(){
		fitness = 10;
	}
        
        /**
         * Sets the c1 value of this particle
         * @param newC1Value : The new c1
         */
        public void setC1(double newC1Value){
                c1 = newC1Value;
        }
        
        
        /**
         * Gets the C1 value of the particle
         * @return Return the current C1 value for this particle
         */
        public double getC1(){
                return c1;
        }
        
        
        /**
         * Sets the c2 value of this particle
         * @param newC2Value : The new c2
         */
        public void setC2(double newC2Value){
                c2 = newC2Value;
        }
        
        
        /**
         * Gets the C2 value of the particle
         * @return Return the current C2 value for this particle
         */
        public double getC2(){
                return c2;
        }
        
        
        /**
         * Gets the W(Innertia Weight) value of the particle
         * @return Return the current W value for this particle
         */
        public double getW(){
                return w;
        }
        /**
         * Sets the new value for W(Innertia Weight) in the particle
         * @param newWValue : The new value for the particle
         */
        public void setW(double newWValue){
                w = newWValue;
        }
        
        /**
         * Sets the particle position values and velocity values
         * @param xVal : The position values
         * @param vVal : The velocity values
         */
	public void setData(double [] xVal, double [] vVal) throws NullPointerException{
                
                if(xVal == null || vVal == null){
                        throw new NullPointerException("Either the X values(position of particle) or V values(velocity of the particle) is null when trying to set it.");
                }
                
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
                if(xPbest == null){
                        pBest = fitness;
                        xPbest = getPosition();
                }
                        
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
                //if it has no assigned fitness then just assign it
                if(xPbest == null){
                        fitness = newValue;
                        xPbest = getPosition();
                        return;
                }
                //otherwise find out if it is better
                
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
        
        /**
         * Determine whether a fitness(firstFitness) is better than another(compareFitness)
         * @param maximize Determines whether a maximum value need to be obtained
         * @param firstFitness : The first fitness to compare to the other fitness
         * @param compareFitness : The fitness to compare the firstFitness to
         * @return Return true if the firstFitness is better than compareFitness
         */
        private boolean isBetterFitness(boolean maximize, double firstFitness, double compareFitness){
                //check to see if the new value is better
                if(maximize == true){
                        if(firstFitness > compareFitness){
                                return true;
                        }
                        return false;
                }
                else{ // minimize
                        if(firstFitness < compareFitness){
                                return true;
                        }
                        return false;
                }
        }
        
        /**
         * Set the velocity clamper that will clamp velocities when they exceed the values
         * @param theClamper : The velocity clamper that will clamp velocities
         */
        public void setVelocityClamper(VelocityClamper theClamper){
                vClamper = theClamper;
        }
        
        /**
         * Update the particle velocity using the social component
         * @param socialComponent 
         */
        public void updateVelocity(double []socialComponent) throws InvalidUpdateComponent{
                if(socialComponent == null){
                        throw new InvalidUpdateComponent("Update velocity attempt on particle using empty social component");
                }
                if(socialComponent.length != x.length){
                        throw new InvalidUpdateComponent("Update velocity attempt of Particle where the social component array size and x array size do not match in Particle");
                }
                
                for(int i = 0; i < x.length; i++){
                        double r1 = 0.1+r.nextDouble()*0.8;
                        double r2 = 0.1+r.nextDouble()*0.8;
                        double newVelocity = w*v[i] + r1*c1*(xPbest[i] - x[i]) + r2*c2*(socialComponent[i] - x[i]);
                        v[i] = newVelocity;
                }
        }
	
}