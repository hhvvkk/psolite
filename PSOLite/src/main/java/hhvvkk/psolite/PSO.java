package hhvvkk.psolite;



public class PSO {
	
	//an arraylist of particles
	PSOSwarm swarm = null;
	
	//the maximum number of iterations before stopping
	int maxIterations = 100;
	
	//the current operation count
	int currentIteration = 0;
	
	//the amount of individual values making up the position of a particle
	int dimension = 2;
	
        //the fitnessfunction that will be used in evaluating the fitness of a particle
	PSOFitnessFunction psoFitnessFunction = null;
	
	//a boolean indicating whether it should be maximum or minimum obtained by fitness function
	boolean maximise = true;
	
	PSO(PSOFitnessFunction fFunciton){
		psoFitnessFunction  = fFunciton;
		swarm = new PSOSwarm(100);		
	}
	
	/**
	* A function to step the particle positions and evaluate them once
	*
	*/
	public void runPSO(){
		
		//check if swarm is initialilsed
		if(!isInitialised()){
			initialiseSwarm();
		}
		//inside
                while(!isEnd()){
                    stepPSO();
                }
	}
	
	/**
	* A function to step the particle positions and evaluate them once
	*
	*/
	public void stepPSO(){
                
	}
	
	
	/**
	* A function to step the particle positions and evaluate them n amount of times
	* @param amount : the amount to step by
	*
	*/
	public void stepPSO(int amount){
                
	}
	
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
	* @param xMaxs the maximum value per x value that can be taken(I.e. the search space)
        * @param xMinx the minimum value per x value that can be taken(I.e. the search space)
	*
	*/
	public void initialisePSO(int particleDimension, int swarmSize, int maxIter, double []xMaxs, double xMins){
                if(particleDimension != xMaxs.length || xMins.length){ 
                        
                }
                
		maxIterations = maxIter;
                initializeSwarm(swarmSize, xMaxs, xMins);
	}
	
	
	private void initializeSwarm(int swarmSize, double []xMaxs, double xMins){		
                //create a new swarm
		swarm = new PSOSwarm(swarmSize);
                
                //loop through the swarm and initialize random values for each particle
                for(int i = 0; i < swarm.size(); i++){
                        //make use of the maximum and minimum values for each x 
                        //value to generate random values
                        
                        for(int xCount = 0; xCount < dimension;xCount++){
                                //the random x value...
                                double newXValue = Math.random();
                            
                        }
                        
                }
	}
}