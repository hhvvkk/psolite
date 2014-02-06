package hhvvkk.psolite;

import java.util.ArrayList;



public class PSOSwarm extends ArrayList<Particle>{
	
        /**
         * Constructs a swarm with Particles in it using the default particle construction
         * @param amount The amount of particles which will be in the swarm
         */
	PSOSwarm(int amount){
		super(amount);
		
		for(int i = 0; i < amount; i++){
			add(new Particle());
		}
	}
        
        
        @Override
        public Particle get(int index) throws IndexOutOfBoundsException{
                if(index >= super.size() || index < 0)
                        throw new IndexOutOfBoundsException("Index supplied to the PSOSwarm was invalid. Size("+super.size()+") and index supplied("+index+")");
                
                return super.get(index);
        }
        
        
	
}