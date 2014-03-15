
package hhvvkk.updatestrategy;

import hhvvkk.psolite.InvalidUpdateComponent;
import hhvvkk.psolite.PSOSwarm;
import hhvvkk.psolite.Particle;
import hhvvkk.psolite.SwarmNullException;

public abstract class UpdateTopology {
        /**
         * A function to call the update velocities
         * @param swarm : The swarm that is used for the update process
         * @param index : The particle index that will be updated
         * @param maximize : An indicator showing whether function maximizes or minimizes
         */
        public void updateVelocity(PSOSwarm swarm, int index, boolean maximize) throws SwarmNullException{
                if(swarm == null){
                        throw new SwarmNullException("Swarm is null in attempt to update velocities in UpdateTopology");
                }
                
                if(index >= swarm.size() || index < 0){
                        throw new IndexOutOfBoundsException("Index is out of bounds in UpdateTopology");
                }
                
                update(swarm, index, maximize);
        }
    
        /**
         * An abstract function to indicate the update of a particle velocity
         * @param swarm : The swarm that is used for the update process
         * @param index : The particle index that will be updated
         * @param maximize : An indicator showing whether function maximizes or minimizes
         */
        abstract void update(PSOSwarm swarm, int index, boolean maximize);
        
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
                try{
                        particle.updateVelocity(socialComponent);
                }catch(InvalidUpdateComponent iUException){
                        
                }
        }
}
