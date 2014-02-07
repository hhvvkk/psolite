
package hhvvkk.neighbourhoodcreator;

public class PSOCreateStarTopology extends PSOCreateNeighbourhood{
        /**
         * Creates a string to represent a star topology for the specific amount of particles
         * @return Return a string representation for the particles and neighbors
         */
        public String create(int amountOfParticles){
                String swarmRepresentation = "";
                
                //create the neighborhood for each particle
                for(int i = 0; i < amountOfParticles; i++){
                        //A particle neighborhood
                        String newParticle = Integer.toString(i)+":";
                        
                        //All other particle count added
                        for(int otherCount = 0; otherCount < amountOfParticles; otherCount++){
                                if(otherCount == amountOfParticles-1)
                                    newParticle = newParticle + Integer.toString(otherCount);
                                else
                                    newParticle = newParticle + Integer.toString(otherCount)+",";
                        }
                        
                        swarmRepresentation = swarmRepresentation + newParticle + "\n\r";
                }
                
                return swarmRepresentation;
        }

}
