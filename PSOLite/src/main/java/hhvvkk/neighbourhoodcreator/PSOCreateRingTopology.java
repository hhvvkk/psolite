
package hhvvkk.neighbourhoodcreator;

public class PSOCreateRingTopology extends PSOCreateNeighbourhood{
        /**
         * Creates a string to represent a star topology for the specific amount of particles
         * @return Return a string representation for the particles and neighbors
         */
        public String create(int amountOfParticles){
                String swarmRepresentation = "";
                
                //create the neighborhood for each particle
                for(int i = 0; i < amountOfParticles; i++){
                        //each particle is connected to the next or previous
                        String newParticle = Integer.toString(i) + ":";
                    
                        //get previous(or jump to end)
                        int previous = i -1;
                        
                        if(previous < 0){//which means the previous is the last
                                previous = amountOfParticles -1;
                        }
                        
                        
                        //get next or jump to beginning
                        int next = i +1;
                        if(next >= amountOfParticles){
                                next = 0;
                        }
                        
                        newParticle = Integer.toString(previous)+ "," + Integer.toString(next);
                        swarmRepresentation = swarmRepresentation + newParticle + "\n\r";
                }
                
                return swarmRepresentation;
        }

}
