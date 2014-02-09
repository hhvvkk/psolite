/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhvvkk.neighbourhoodcreator;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A class to create neighborhoods for the particles in order to create a specialized topology
 */
public class NeighbourhoodUtility {
        //The particles with their
        private ArrayList<LinkedList<Integer>>particles = null;
      
        
        /**
         * Constructs a neighborhood of particles of size specified
         * @param numberOfParticles The amount of particles in the neighborhood
         */
        public NeighbourhoodUtility(int numberOfParticles){
                particles = new ArrayList<LinkedList<Integer>>(numberOfParticles);
                
                for(int i = 0; i < numberOfParticles; i++){
                        //add all particles with no neighbors initially
                        particles.add(new LinkedList<Integer>());
                }
        }
        
        /**
         * Get the amount of particles
         * @return Return the amount of particles
         */
        public int getSize(){
                return particles.size();
        }
        
        /**
         * Adds a particle as a neighbor of another particle
         * @param particleIndex
         * @param particleNeighbourIndex
         */
        public void addNeigbour(int particleIndex, int particleNeighbourIndex){
                particles.get(particleIndex).add(particleNeighbourIndex);
        }
        
        /**
         * Removes a particle from a particle neighborhood
         * @param indexOfParticle : The particle to remove from the list
         */
        public void removeParticle(int indexOfParticle){
                particles.remove(indexOfParticle);
        }
        
        /**
         * Gets the particle linked list showing
         * @return Returns a new array list containing the same particle neighborhoods as created
         */
        public ArrayList<LinkedList<Integer>> getParticles(){
                
                if(particles == null)
                        return null;
                
                return new ArrayList<LinkedList<Integer>>(particles);
        }
}
