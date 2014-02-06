
package hhvvkk.psolite;

public abstract class PSOCreateNeighbourhood {
        /**
         * Apply a specific cluster to a number of particles(i.e. create a ring for one bit and a star for the rest)
         * @param swarm The swarm to be used to create the neighborhood
         */
        public abstract void applyCluster(PSOSwarm swarm, int begin, int end)  throws SwarmEmptyException;
}
