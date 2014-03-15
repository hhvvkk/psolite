
package hhvvkk.updatestrategy;

import hhvvkk.psolite.PSOSwarm;
import hhvvkk.psolite.Particle;

public abstract class UpdateTopology {
        /**
         * An abstract function to indicate the update of a particle velocity
         * @param swarm : The swarm that is used for the update process
         * @param index : The particle index that will be updated
         * @param maximize : An indicator showing whether function maximizes or minimizes
         */
        public abstract void update(PSOSwarm swarm, int index, boolean maximize);
        
        /**
         * A function to determine whether the first fitness is better than the second
         * @param maximize : A boolean indicating if the function should maximize or minimize
         * @param fitness1 : The first fitness
         * @param fitness2 : The second fitness
         * @return Returns true if the first fitness is better than the second fitness and false if otherwise.
         */
        protected boolean isBetterFitness(boolean maximize, double fitness1, double fitness2){
                if(maximize){
                        if(fitness1 > fitness2)
                                return true;
                        else 
                                return false;
                }
                else{
                        //minimize..
                        if(fitness1 < fitness2)
                                return true;
                        else
                            return false;
                }
        }
        
        /**
         * Updates the particle position by sending through the social component to the particle
         * @param particle : The particle to be updated
         * @param socialComponent : The social component to be used in updating the particle
         */
        protected void updateVelocity(Particle particle, double []socialComponent){
                particle.updateVelocity(socialComponent);
        }
        
        /**
         * @note 
         * OLD UPDATE:*
                for(int i = 0; i < x.length; i++){
                        double r1 = 0.1+r.nextDouble()*0.8;
                        double r2 = 0.1+r.nextDouble()*0.8;
                        double newVelocity = w*v[i] + r1*c1*(xPbest[i] - x[i]) + r2*c2*(neighbourhoodBestX[i] - x[i]);
                        v[i] = newVelocity;
                }
                
         */
}
