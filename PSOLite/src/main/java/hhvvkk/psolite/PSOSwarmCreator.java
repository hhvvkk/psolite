/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhvvkk.psolite;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A class to parse and create a swarm of particles with the neighborhoods specified
 */
public class PSOSwarmCreator {
    
        /**
         * Creates a swarm using the representation consisting of an array list of particles
         * @param swarmRepresentation The swarm representation consisting of particles
         * @return Returns a PSOSwarm with the represented particle neighborhoods
         * @throws NullPointerException 
         */
        public PSOSwarm createSwarm(ArrayList<LinkedList<Integer>>swarmRepresentation) throws NullPointerException{
                if(swarmRepresentation == null)
                        throw new NullPointerException();
                
                int amount = swarmRepresentation.size();
                
                PSOSwarm swarm = new PSOSwarm(amount);
                
                //for each particle add their neighborhood to them
                for(int i = 0; i < amount; i++){
                        Particle particle = null;
                        
                        try{
                                particle = swarm.get(i);
                        }catch(IndexOutOfBoundsException indexBoundsBroken){
                                
                        }
                        
                        LinkedList<Integer> neighbourhood = swarmRepresentation.get(i);
                        
                        if(neighbourhood != null){//no particle is added as neighbors if it is null
                                for(int nCount = 0; nCount < neighbourhood.size(); nCount++){
                                        int newNeighbour = neighbourhood.get(nCount);
                                        //add neighbor
                                        particle.addNeighbour(newNeighbour);

                                }
                        }
                        
                }
                
                return swarm;
        }
}
