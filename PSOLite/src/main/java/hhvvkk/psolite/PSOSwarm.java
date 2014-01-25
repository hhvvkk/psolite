package hhvvkk.psolite;

import java.util.ArrayList;



public class PSOSwarm extends ArrayList<Particle>{
	
	PSOSwarm(int amount){
		super(amount);
		
		for(int i = 0; i < amount; i++){
			add(new Particle());
		}
	}
	
}