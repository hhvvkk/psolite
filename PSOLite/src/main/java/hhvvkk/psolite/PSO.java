package hhvvkk.psolite;


import java.util.Random;

public class PSO {
	boolean swarmsInitialized = false;
        
        //A few swarms contained in this cloud
        PSOCloud cloud = null;
        
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
        
        //the fitnessfunction that will be used in evaluating the fitness of a particle
	PSOCreateNeighbourhood psoUpdateFunction = null;
	
	//a boolean indicating whether it should be maximum or minimum obtained by fitness function
	boolean maximise = true;
        
        //A random generator
	Random r = new Random();
	
	PSO(PSOFitnessFunction fFunciton){
                //if fitnessfunction == null throw
		psoFitnessFunction  = fFunciton;                
	}
        
        /**
         * Set the amount of iterations the pso will run
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
	* A function to step the particle positions and evaluate them once
	*
	*/
	public void stepPSO(){//throws...
                //check if swarm is initialilsed
		if(!cloudIsIntialized()){
			//throw error, must be initialized
		}
                
                for(int cloudCount = 0; cloudCount < cloud.getCloudSize(); cloudCount++){
                        //move all particles 
                        for(int particleCount = 0; particleCount < cloud.getSwarmSize(); particleCount++ ){
                                Particle particle = cloud.getParticle(cloudCount, particleCount);
                                
                                //move particle
                                particle.move();                                
                        }
                }
                
                for(int cloudCount = 0; cloudCount < cloud.getCloudSize(); cloudCount++){
                        //move all particles 
                        for(int particleCount = 0; particleCount < cloud.getSwarmSize(); particleCount++ ){
                                Particle particle = cloud.getParticle(cloudCount, particleCount);
                                
                                //change velocity of particles
                                
                        }
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
         * Check whether the cloud is initialized and returns true if it is
         * @return Return true if cloud is initialized
         */
        public boolean cloudIsIntialized(){
                return cloud.cloudIsInitialised();
        }
	
        /**
         * Initialize the particles with the given amount of space
         * @param swarmSize : The amount of particles per swarm in the cloud
         * @param particleDimension : The amount of dimensions per particle(amount of values)
	 * @param xMaxs : the maximum value per x value that can be taken(I.e. the search space)
         * @param xMinx : the minimum value per x value that can be taken(I.e. the search space)
         */
	public void initializePSO(int particleDimension, int swarmSize, double []xMaxs, double []xMins){
                psoInitialized = true;
                
                
	}
}