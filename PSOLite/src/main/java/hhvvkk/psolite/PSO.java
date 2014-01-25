package hhvvkk.psolite;


import java.util.Random;

public class PSO {
	
	//an arraylist of particles
	PSOSwarm swarm = null;
        
        //a boolean indicating if the particle is initialised
        boolean particlesInitialized = false;
        
	//the maximum number of iterations before stopping
	int maxIterations = 100;
	
	//the current operation count
	int currentIteration = 0;
	
	//the amount of individual values making up the position of a particle
	int dimension = 2;
	
        //the fitnessfunction that will be used in evaluating the fitness of a particle
	PSOFitnessFunction psoFitnessFunction = null;
        
        //the fitnessfunction that will be used in evaluating the fitness of a particle
	PSOUpdateFunction psoUpdateFunction = null;
	
	//a boolean indicating whether it should be maximum or minimum obtained by fitness function
	boolean maximise = true;
        
        //A random generator
	Random r = new Random();
	
	PSO(PSOFitnessFunction fFunciton){
                //if fitnessfunction == null throw
		psoFitnessFunction  = fFunciton;
		swarm = new PSOSwarm(100);		
	}
	
	/**
	* A function to run the PSO until it has finished or found a solution
	*
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
		if(!isInitialised()){
			//throw error, must be initialized
		}
                
                //move all particles 
                for(int i = 0; i < swarm.size(); i++){
                    Particle p = swarm.get(i);
                    p.move();
                }
                
                //change velocity of particles
                for(int i =0; i < swarm.size(); i++){
                    
                }
	}
	
	
	/**
	* A function to step the particle positions and evaluate them once
	* @return Return true if the PSO is over maximum iteration or fitness obtained
	*/
	
	public boolean isEnd(){
                //check for fitness is finished
                    
		if(currentIteration >= maxIterations)
			return true;
		else 
			return false;
	}
	
	
	private boolean isInitialised(){
		return false;
	}
	
	
        
	/**
	* A function to step the particle positions and evaluate them n amount of times
	* @param xMaxs : the maximum value per x value that can be taken(I.e. the search space)
        * @param xMinx : the minimum value per x value that can be taken(I.e. the search space)
	*
	*/
	public void initialisePSO(int particleDimension, int swarmSize, int maxIter, double []xMaxs, double []xMins){
                if(particleDimension != xMaxs.length || particleDimension != xMins.length){ 
                        //throw error
                }
                
		maxIterations = maxIter;
                initializeSwarm(swarmSize, xMaxs, xMins);
                particlesInitialized = true;
	}
	
	
	private void initializeSwarm(int swarmSize, double []xMaxs, double[] xMins){		
                //create a new swarm
		swarm = new PSOSwarm(swarmSize);
                
                //loop through the swarm and initialize random values for each particle
                for(int i = 0; i < swarm.size(); i++){
                                
                        //the position values
                        double [] xValues = new double[dimension];                        
                        
                        for(int xCount = 0; xCount < dimension; xCount++){
                                //make use of the maximum and minimum values for each x 
                                //value to generate random values
                                //the random x value...
                                double newXValue = r.nextDouble() * (xMaxs[xCount] - xMins[xCount]) + xMins[i];
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
}