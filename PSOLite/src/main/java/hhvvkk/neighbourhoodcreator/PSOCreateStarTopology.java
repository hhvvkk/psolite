
package hhvvkk.neighbourhoodcreator;

import java.util.ArrayList;
import java.util.LinkedList;

public class PSOCreateStarTopology extends PSOCreateNeighbourhood{
        /**
         * Create an array list for a representation for specific particles which is in a star topology
         * @return Return an array list representation for the particles and neighbors
         */
         public ArrayList<LinkedList<Integer>> create(int amountOfParticles){
                
                if(amountOfParticles <= 0){
                        return new ArrayList<LinkedList<Integer>>();
                }
                
                ArrayList<LinkedList<Integer>> particles = new ArrayList<LinkedList<Integer>>();
                
                //for all particles
                for(int pCount = 0; pCount < amountOfParticles; pCount++){
                        LinkedList<Integer> neighbourhood = new LinkedList<Integer>();
                        for(int nCount = 0; nCount < amountOfParticles; nCount++){
                              if(pCount != nCount){//don't add yourself
                                    neighbourhood.add(nCount);
                              }
                        }
                        particles.add(neighbourhood);
                }
                
                return particles;
        }

}
