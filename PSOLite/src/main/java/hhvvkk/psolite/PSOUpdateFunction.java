
package hhvvkk.psolite;

public abstract class PSOUpdateFunction {
        /**
         * Update the particle velocity using the swarm and the particle
         * @param p : the particle to be updated
         * @param swarm : the whole swarm
         * @param maximize : a boolean indicating whether to strive to maximum value or minimum value
         */
        public abstract void updateParticleVelocity(Particle p, PSOSwarm swarm, boolean maximize)  throws SwarmEmptyException;
}
