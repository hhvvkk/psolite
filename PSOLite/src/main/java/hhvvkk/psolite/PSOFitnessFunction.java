package hhvvkk.psolite;

public abstract class PSOFitnessFunction{	
	
	/**
	* @param particle : Particle to be evaluated
	* @return Fitness of a particle
	*/
	public double evaluate(Particle particle, boolean maximize) {
		double []position = particle.getPosition();
                double fitness = 0;
                try{
                        fitness = evaluate(position);
                }catch(Exception e){
                    
                }
		
		particle.updateFitness(fitness, maximize);
		return fitness;
	}
	
	//abstract 
	//make abstract for own imlementations
	protected abstract double evaluate(double [] xValue);
}