package hhvvkk.psolite;

import hhvvkk.velocityclamp.VelocityClamper;
import java.util.Random;

public class PSO {
	boolean swarmsInitialized = false;
        
        //A swarm consisting of multiple particles
        PSOSwarm swarm = null;
        
        //a boolean indicating if the particle is initialised
        boolean psoInitialized = false;
        
	//the maximum number of iterations before stopping
	int maxIterations = 100;
	
	//the current operation count
	int currentIteration = 0;
	
	//the amount of individual values making up the position of a particle
	int dimension = 2;
	
        //the fitnessfunction that will be used in evaluating the fitness of a particle
	PSOFitnessFunction psoFitnessFunction = null;
	
	//a boolean indicating whether it should be maximum or minimum obtained by fitness function
	boolean maximize = true;
        
        //A random generator
	Random r = new Random();
        
        /**
         * Create a particle swarm optimizer with a swarm already created
         * @param fFunciton : A fitness function to evaluate the fitness of particles
         * @param maxToFind : A boolean which determines if fitness should strive towards maximum
         */
	public PSO(PSOSwarm newSwarm, PSOFitnessFunction fFunciton, boolean maximisePSO){
                maximize = maximisePSO;
                if(newSwarm == null)
                        throw new NullPointerException("Swarm is null in the construction of PSO");
                else 
                        swarm = newSwarm;
                
                if(fFunciton == null)
                        throw new NullPointerException("Fitness function is null in construction of PSO");
                
		psoFitnessFunction  = fFunciton;                
	}
        
        /**
         * Set the amount of iterations the PSO will run
         * @param iterationsAmount : The amount of iterations to set it to
         */
        public void setMaxIteration(int iterationsAmount){
                maxIterations = iterationsAmount;
        }
        
        /**
         * Get the maximum amount of iterations 
         * @return Return the maximum amount of iterations the PSO will run
         */
        public int getMaxIterations(){
                return maxIterations;
        }
        
        /**
         * Get the current iteration count for the PSO
         * @return Returns the current iteration count
         */
        public int getCurrentIteration(){
                return currentIteration;
        }
	
        /**
         * A function to run the PSO until it has finished or found a solution
         */
	public void runPSO(){
		//inside
                while(!isEnd()){
                    stepPSO();
                }
	}
        
        /**
         * Set the fitness function to the new fitness function
         * @param newFitnessFunction The new fitness function to use
         */
        public void setFitnessFunction(PSOFitnessFunction newFitnessFunction){
                if(newFitnessFunction == null)
                            throw new NullPointerException("The new fitness function to set is null");
                psoFitnessFunction = newFitnessFunction;
        }
	
        
        /**
	* A function to step the particle positions and evaluate them n amount of times
	* @param amount : the amount of steps to be taken
	*/
	public void stepPSO(int amount){
                //if amount <= 0 throw error
                int stepCounter = 0;
                
                //inside
                while(!isEnd() && stepCounter < amount){
                    stepPSO();
                    
                    stepCounter++;
                }
	}
        
	/**
	* A function to step the particle positions and evaluate their fitness and update velocity once
	*
	*/
	public void stepPSO(){//throws...
                //check if swarm is initialilsed
		if(!psoIsIntialized()){
			//throw error, must be initialized
		}
                
                for(int swarmCount = 0; swarmCount < swarm.size(); swarmCount++){
                        //get a particle
                        Particle particle = swarm.get(swarmCount);
                        //move particle
                        particle.move();
                }
                
                for(int swarmCount = 0; swarmCount < swarm.size(); swarmCount++){
                        Particle particle = swarm.get(swarmCount);
                        //update particle fitness
                        psoFitnessFunction.evaluate(particle, maximize);
                }
                
                for(int swarmCount = 0; swarmCount < swarm.size(); swarmCount++){
                        Particle particle = swarm.get(swarmCount);
                        //update particle velocity
                        particle.updateVelocity(swarm, maximize);
                }
	}
	
	
	/**
	* A function to step the particle positions and evaluate them once
	* @return Return true if the PSO is over maximum iteration or fitness obtained
	*/
	
	public boolean isEnd(){
                //check for fitness is finished
                
            
                //check for iteration done
		if(currentIteration >= maxIterations)
			return true;
		else 
			return false;
	}
	
	
        /**
         * Check whether the PSO is initialized
         * @return Return true if PSO is initialized
         */
        public boolean psoIsIntialized(){
                return psoInitialized;
        }
	
        /**
         * Initialize the particles with the given amount of space(dimension sizes - maximum and minimum values)
         * @param particleDimension : The amount of dimensions per particle(amount of values)
	 * @param xMaxs : the maximum value per x value that can be taken(I.e. the search space)
         * @param xMinx : the minimum value per x value that can be taken(I.e. the search space)
         */
	public void initializePSO(int particleDimension, double []xMaxs, double []xMins){
                
                //swarm must exist and not be null
                if(swarm == null)
                        throw new NullPointerException("Swarm non existent in initialization of PSO");
                
                currentIteration = 0;
                dimension = particleDimension;
                psoInitialized = true;
                
                
                //loop through the swarm and initialize random values for each particle
                for(int i = 0; i < swarm.size(); i++){
                        //the position values
                        double [] xValues = new double[dimension];                        
                        for(int xCount = 0; xCount < dimension; xCount++){
                                //make use of the maximum and minimum values for each x 
                                //value to generate random values
                                //the random x value...
                                double newXValue = r.nextDouble() * (xMaxs[xCount] - xMins[xCount]) + xMins[xCount];
                                xValues[xCount] = newXValue;
                        }
                        
                        //the velocity values per each dimension set to zero
                        double [] vValues = new double[dimension];
                        for(int vCount = 0; vCount < dimension; vCount++){
                                //initialize to zero velocity
                                vValues[vCount] = 0;
                        }
                        
                        
                        
                        Particle p = swarm.get(i);
                        //set the particle values
                        p.setData(xValues, vValues);
                }
	}
        
        /**
         * Gets the particle as it currently is
         * @return Return the selected particle position
         */
        public double[] getParticlePostion(int index){
                if(index >= swarm.size() || index < 0)
                        throw new IndexOutOfBoundsException("Index does not exist in get particle position("+Integer.toString(index));
                
                return swarm.get(index).getPosition();
        }
        
        /**
         * Gets the amount of particles in a swarm
         * @return Return the amount of particles contained in the swarm
         */
        public int getSwarmCount(){
                return swarm.size();
        }
        
        /**
         * Sets the velocity clamper for each of the particles and throws error if it is not initialized
         * @param theClamper : The selected velocity clamper that will clamp the velocities of the particles
         */
        public void setVelocityClamper(VelocityClamper theClamper) throws SwarmNotInitializedException{
                if(!psoInitialized){
                        throw new SwarmNotInitializedException("Swarm is not initialized when trying to set the velocity clamper");
                }
                
                for(int i = 0; i < swarm.size(); i++){
                        swarm.get(i).setVelocityClamper(theClamper);
                }
        }
}