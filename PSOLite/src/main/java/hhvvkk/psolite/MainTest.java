package hhvvkk.psolite;



public class MainTest{
	public static void main(String [] args){
		System.out.println("BEGIN--MAIN");
		System.out.println("////////////////////");
		
		double []data = {15,1,11,9,8,7,6,3,2,4,5,20,16,0,1};
		
		System.out.println("SetValues(size)== "+data.length);
		
		
		Particle p = new Particle()  ;
		
		p.setData(data, data);
		
		p.print();
		
		System.out.println("////////////////////");
		System.out.println("END--MAIN");
	}	
}