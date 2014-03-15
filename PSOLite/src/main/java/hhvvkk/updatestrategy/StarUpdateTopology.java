
package hhvvkk.updatestrategy;

import hhvvkk.psolite.PSOSwarm;
import hhvvkk.psolite.Particle;


public class StarUpdateTopology extends UpdateTopology {
    
        /**
         * GBest : Update the particles using the star topology(global best used)
         * @param swarm : The swarm which is used in the update
         * @param index : The index used to find the particle to update
         * @param maximize : A boolean indicating if maximized or minimized
         */
        protected void update(PSOSwarm swarm, int index, boolean maximize){
                
                //loop through all to find the global best
                Particle gBest = swarm.get(0);
                
                Particle current;
                for(int i = 1; i < swarm.size(); i++){
                       current = swarm.get(i);
                       if(isBetterFitness(maximize, current.getPBest(), gBest.getPBest())){
                                //then it should replace
                                gBest = current;                                
                       }                        
                }
                
                //then update
                updateVelocity(swarm.get(index), gBest.getBestPosition());
        }
}
