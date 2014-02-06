/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhvvkk.psolite;

import java.util.ArrayList;
import java.util.Random;

/**
 * The class is a group of swarms which communicate with each other
 * @author root
 */
public class PSOCloud {
        //A boolean indicating whether the swarms a initialized
        private boolean cloudInitialized = false;
        
        //the amount of swarms in the cloud
        int cloudSize = 0;
        
        //the amount of particles per swarm
        int swarmSize = 0;
        
        //A cloud consist of multiple swarms
        ArrayList<PSOSwarm> cloud = null;
        
        
        //A random generator
	Random r = new Random();
        
        /**
         * Creates a cloud made up off swarms
         * @param particleAmountPerSwarm The amount of particles in each cloud
         * @param amountOfSwarms The amount of swarms
         */
        PSOCloud(int amountOfSwarms, int particleAmountPerSwarm){
                cloudSize = amountOfSwarms;
                swarmSize = particleAmountPerSwarm;
                cloud = new ArrayList<PSOSwarm>(amountOfSwarms);
        }
        
        /**
         * Gets the number of swarms 
         * @return Return the cloud size(number of swarms)
         */
        public int getCloudSize(){
                return cloudSize;
        }
        
        /**
         * Gets the amount of particles per swarm
         * @return Returns the amount of particles per swarm in the cloud
         */
        public int getSwarmSize(){
                return swarmSize;
        }
        
        /**
         * Get the boolean which indicates whether the function is initialized or not
         * @return Return true if the particle swarm is initialized or false if it is not
         */
	public boolean cloudIsInitialised(){
		return cloudInitialized;
	}
	
        
        /**
         * Gets a specific particle from a swarm
         * @param cloudNumber The number of the swarm to obtain the particle from
         * @param particleNumber The number of the particle to get
         * @return Returns the particle specified by the two parameters
         */
        public Particle getParticle(int cloudNumber, int particleNumber){
                //go and get the particle at the specified parameters
                return cloud.get(cloudNumber).get(particleNumber);
        }
        
        public void initializeCloud(int dimension, double []xMaxs, double[] xMins){
                cloudInitialized = true;
                
                for(int swarmCount = 0; swarmCount < cloudSize; swarmCount++){
                        //create a new swarm
                        PSOSwarm newSwarm = new PSOSwarm(swarmSize);

                        //loop through the swarm and initialize random values for each particle
                        for(int i = 0; i < newSwarm.size(); i++){

                                //the position values
                                double [] xValues = new double[dimension];                        

                                for(int xCount = 0; xCount < dimension; xCount++){
                                        //make use of the maximum and minimum values for each x 
                                        //value to generate random values
                                        //the random x value...
                                        double newXValue = r.nextDouble() * (xMaxs[xCount] - xMins[xCount]) + xMins[i];
                                        xValues[xCount] = newXValue;
                                }


                                //the velocity values per each dimension set to zero
                                double [] vValues = new double[dimension];
                                for(int vCount = 0; vCount < dimension; vCount++){
                                        //initialize to zero velocity
                                        vValues[vCount] = 0;
                                }


                                Particle p = newSwarm.get(i);

                                //set the particle values
                                p.setData(xValues, vValues);
                        }
                        
                        cloud.add(newSwarm);
                }
	}
}
