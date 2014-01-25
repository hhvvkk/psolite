package hhvvkk.psolite;

public abstract class PSOFitnessFunction{
	
	
	PSOFitnessFunction(){
		
	}
	
	
	
	/**
	* @param particle : Particle to be evaluated
	* @return Fitness of a particle
	*/
	public double evaluate(Particle particle, boolean maximize) {
		double []position = particle.getPosition();
		double fitness = evaluate(position);
		particle.updateFitness(fitness, maximize);
		return fitness;
	}
	
	//abstract 
	///@todo make abstract for own imlementations
	public abstract double evaluate(double [] xValue);
}