
package hhvvkk.neighbourhoodcreator;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class PSOCreateNeighbourhood {
        /**
         * Creates a string to represent a star topology for the specific amount of particles
         * @return Return a string representation for the particles and neighbors
         */
        public abstract ArrayList<LinkedList<Integer>> create(int amountOfParticles);
}
