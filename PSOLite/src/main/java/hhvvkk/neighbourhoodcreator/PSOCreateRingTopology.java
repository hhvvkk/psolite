
package hhvvkk.neighbourhoodcreator;


import java.util.ArrayList;
import java.util.LinkedList;

public class PSOCreateRingTopology extends PSOCreateNeighbourhood{
        /**
         * Create an array list for a representation for specific particles
         * @return Return an array list representation for the particles and neighbors
         */
        public ArrayList<LinkedList<Integer>> create(int amountOfParticles){
                if(amountOfParticles <= 0){
                        return new ArrayList<LinkedList<Integer>>();
                }
                
                
                ArrayList<LinkedList<Integer>> particles = new ArrayList<LinkedList<Integer>>();
                //for all particles
                for(int pCount = 0; pCount < amountOfParticles; pCount++){
                        LinkedList<Integer> neighbourhood = new LinkedList();
                        //Each particle is connected to the previous or the next
                        
                        
                        //connect neighbour to the next 
                        int next = pCount + 1;
                        
                        //next should be in set
                        if(next >= amountOfParticles){
                                next = 0;
                        }
                        neighbourhood.add(next);
                        
                        
                        //connect neighbour to the previous
                        int previous = pCount - 1;
                        
                        //next should be in set
                        if(previous <= -1){
                                previous = amountOfParticles -1;
                        }
                        
                        //it can happen that previous is next(number of particles is 2)
                        if(previous != next)
                                neighbourhood.add(previous);
                        
                        particles.add(neighbourhood);
                }
                
                return particles;
        }

}
