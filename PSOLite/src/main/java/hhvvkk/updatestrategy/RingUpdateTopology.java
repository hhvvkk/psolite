
package hhvvkk.updatestrategy;

import hhvvkk.psolite.PSOSwarm;
import hhvvkk.psolite.Particle;

public class RingUpdateTopology extends UpdateTopology{
        /**
         * Update the particles using the ring topology(local best with 2 neighbors)
         * @param swarm : The swarm which is used in the update
         * @param index : The index used to find the particle to update
         * @param maximize : A boolean indicating if maximized or minimized
         */
        protected void update(PSOSwarm swarm, int index, boolean maximize){
                
                int leftIndex, rightIndex = -1;
                
                leftIndex = index -1;
                
                if(leftIndex < 0){
                        
                }
                
                rightIndex = index +1;
                
                if(rightIndex >= swarm.size()){
                        
                }
                
                Particle leftParticle = swarm.get(leftIndex);
                
                Particle rightParticle = swarm.get(rightIndex);
                
                Particle lBest = findBest(leftParticle, rightParticle, maximize);
                
                updateVelocity(swarm.get(index), lBest.getBestPosition());
        }
        
        /**
         * Evaluate the particles and finds the particle with the best fitness
         * @param first : The first particle to evaluate
         * @param second : The second particle to evaluate
         * @return Returns the best particle based on fitness
         */
        private Particle findBest(Particle first, Particle second, boolean maximize){
                if(isBetterFitness(maximize, first.getPBest(), second.getPBest())){
                        return first;
                }
                else{
                        return second;
                }
        }
        
        
}
