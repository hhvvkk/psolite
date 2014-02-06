
package hhvvkk.psolite;

public class PSOCreateStarTopology extends PSOCreateNeighbourhood{
    
            /**
             * Applies a cluster to the swarm which creates a neighborhood from the beginning to the end of specified integers
             * @param swarm : All the particles to use to create the cluster
             * @param begin : The begin integer value of the cluster to be created
             * @param end : The end value of the cluster to be created
             * @throws SwarmEmptyException 
             */
            public void applyCluster(PSOSwarm swarm, int begin, int end)  throws SwarmEmptyException, IndexOutOfBoundsException{
                    if((begin < 0) || (end >= swarm.size()) || (begin > end))
                            throw new IndexOutOfBoundsException("Index supplied is invalid");
                    
                    for(int i = begin; i < end; i++){
                            Particle p = swarm.get(i);
                            for(int swarmCount = 0; swarmCount < swarm.size(); swarmCount++){
                                    if(p != swarm.get(swarmCount))
                                            p.addNeighbour(swarm.get(swarmCount));
                            }
                    }
            }
//        public void updateParticleVelocity(Particle p, PSOSwarm swarm, boolean maximize) throws SwarmEmptyException{
//                //ensure that the swarm contains at least a particle
//                if(swarm.size() <= 0)
//                    throw new SwarmEmptyException();
//            
//                //initialize the pBest values to the first in the swarm
//                Particle gBestParticle = swarm.get(0);
//                double gBestPerformance = gBestParticle.getPBest();
//                
//                
//                //loop through all to find the best particle(gBest)
//                for(int i = 1; i < swarm.size(); i++){
//                        Particle currentParticle = swarm.get(i);
//                        double currentParticlePBest = currentParticle.getPBest();
//                        
//                        //compare the current gBest with the current particle 
//                        if(maximize == true){
//                                if(currentParticlePBest > gBestPerformance){
//                                        gBestParticle = currentParticle;
//                                        gBestPerformance = currentParticlePBest;
//                                }
//                        }
//                        else{
//                                if(currentParticlePBest < gBestPerformance){
//                                        gBestParticle = currentParticle;
//                                        gBestPerformance = currentParticlePBest;
//                                }
//                        }
//                }
//                
//                //after you've found the best particle you use it to update the velocities of all the particles
//                for(int i = 0; i < swarm.size(); i++){
//                        Particle currentParticle = swarm.get(i);
//                        
//                        
//                }
//                
//                
//        }
}
