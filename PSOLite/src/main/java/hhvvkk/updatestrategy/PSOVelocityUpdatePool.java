
package hhvvkk.updatestrategy;

import hhvvkk.psolite.PSOSwarm;
import hhvvkk.psolite.SwarmEmptyException;
import java.util.Random;



public class PSOVelocityUpdatePool {
    
        private UpdatePool updatePool = null;
        
        /**
         * A random to choose the update strategy randomly from the pool
         */
        Random random = new Random();
        
        public PSOVelocityUpdatePool(){
                updatePool = new UpdatePool();
        }        
        
        /**
         * Adds a selected update topology to the pool
         * @param updater : The update topology to add
         */
        public void addUpdateToplogy(UpdateTopology updater){
                updatePool.add(updater);
        }
        
        
        /**
         * Removes the update topology from the pool at a specific index
         * @param index : the index of the update topology to remove
         * @return Returns true if the removal was successful and false if not
         */
        public boolean removeUpdateTopology(int index){
                if(index >= updatePool.size() || index < 0){
                        return false;
                }
                
                UpdateTopology aupdater = updatePool.remove(index);
                
                if(aupdater != null)
                    return true;
                
                
                return false;
        }
        
        /**
         * Removes the update topology from the pool
         * @param updater : The update topology to remove
         * @return Returns true if the removal was successful and false if not
         */
        public boolean removeUpdateToplogy(UpdateTopology updater){
                if(updatePool.size() == 0){
                        return false;
                }
                
                
                return updatePool.remove(updater);
        }
        
        /**
         * Gets a random index for a random update strategy
         * @return Returns an index within the range of the pool
         */
        private int getRandomUpdaterIndex(){
                return random.nextInt(updatePool.size());
        }
        
        /**
         * Updates the velocity of the particle selected for the update using the pool
         * @param swarm : The swarm to be updated
         * @param index : The index of the particle to be updated
         * @param maximize : The indicator determining if function maximizes or minimizes
         */
        public void updateVelocity(PSOSwarm swarm, int index, boolean maximize) throws SwarmEmptyException, UpdatePoolEmptyException {
                if(updatePool.isEmpty()){
                        throw new UpdatePoolEmptyException("Update pool is empty apon trying to update velocity");
                }
            
                if(swarm == null){
                        throw new NullPointerException("Updating velocity in PSOVelocityUpdatePool with no swarm object.");
                }
                
                if(swarm.isEmpty()){
                        throw new SwarmEmptyException("Swarm is empty apon trying to update the velocities in PSOVelocityUpdatePool");
                }
                
                int randomUpdater = getRandomUpdaterIndex();
                
                UpdateTopology updater = updatePool.get(randomUpdater);
                
                updater.update(swarm, index, maximize);
                
        }
}
