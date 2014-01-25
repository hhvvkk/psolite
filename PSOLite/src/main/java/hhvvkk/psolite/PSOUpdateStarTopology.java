/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhvvkk.psolite;

/**
 * A function to update the particles using all the other particles
 * NOTE: Otherwise known as GBest - uses global best to update all the particle velocities
 */
public class PSOUpdateStarTopology extends PSOUpdateFunction{
        public void updateParticleVelocity(Particle p, PSOSwarm swarm, boolean maximize) throws SwarmEmptyException{
                //ensure that the swarm contains at least a particle
                if(swarm.size() <= 0)
                    throw new SwarmEmptyException();
            
                //initialize the pBest values to the first in the swarm
                Particle gBestParticle = swarm.get(0);
                double gBestPerformance = gBestParticle.getPBest();
                
                
                //loop through all to find the best particle(gBest)
                for(int i = 1; i < swarm.size(); i++){
                        Particle currentParticle = swarm.get(i);
                        double currentParticlePBest = currentParticle.getPBest();
                        
                        //compare the current gBest with the current particle 
                        if(maximize == true){
                                if(currentParticlePBest > gBestPerformance){
                                        gBestParticle = currentParticle;
                                        gBestPerformance = currentParticlePBest;
                                }
                        }
                        else{
                                if(currentParticlePBest < gBestPerformance){
                                        gBestParticle = currentParticle;
                                        gBestPerformance = currentParticlePBest;
                                }
                        }
                }
                
        }
}
