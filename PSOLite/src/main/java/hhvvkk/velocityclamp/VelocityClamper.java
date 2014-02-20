/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhvvkk.velocityclamp;

import java.util.ArrayList;


public abstract class VelocityClamper {
        
        //The maximum velocities for the particles
        private ArrayList<Double> maxV = new ArrayList<Double>();
        
        /**
         * Sets the maximum velocity values to test the violation with
         * @param maxVValues : The maximum velocity values
         */
        public void setMaxVelocities(double []maxVValues){
                for(int i = 0; i < maxVValues.length; i++){
                        maxV.add(Math.abs(maxVValues[i]));
                }
        }
        
        /**
         * Gets the maximum velocity at a specific index
         * @param index : The index for the maximum velocity to be obtained
         * @return Returns the maximum velocity at an index
         */
        public double getMaxVelocityAt(int index){
                if(index < 0 || index > maxV.size()){
                        throw new IndexOutOfBoundsException("Index out of bounds at retrieving the maximum velocity for an individual");
                }
                
                return maxV.get(index);
        }
        
        /**
         * Find out whether a velocity is in violation
         * @param velocities : The initial velocities to test
         * @return Return true if it is violating the velocities
         */
        public boolean violateVelocity(double []velocities){
                for(int i = 0; (i < velocities.length) && (i < maxV.size())  ; i++){
                        double absValue = Math.abs(velocities[i]);
                        if(absValue > maxV.get(i)){
                                return true;
                        }
                }
                return false;
        }
        
        /**
         * Finds out whether a velocity value for a dimension is in violation of maximum velocities
         * @param index : The index to compare to
         * @param velocityValue : The velocity value of 
         * @return Return true if the individual value is in violation of the other value
         */
        public boolean violateIndividual(int index, double velocityValue){
                if(index < 0 || index > maxV.size()){
                        throw new IndexOutOfBoundsException("Testing for individual violation of velocity");
                }
                
                if(Math.abs(velocityValue) > maxV.get(index)){
                        return true;
                }
                else 
                        return false;
        }
        
        /**
         * Gets the clamped velocity values depending on the 
         * @param velocities : The initial velocities that may be clamped
         * @return Returns the velocities that have been clamped
         */
        public double [] clampedVelocity(double []velocities){
                if(violateVelocity(velocities)){
                        return getClampedVelocity(velocities);
                }
                else{
                        return velocities;
                }
        }
        
        /**
         * Implementation should return the maximum velocity values after the velocities has been clamped
         * @param velocities : The current velocity values
         * @return Return the velocity values after it has been clamped
         */
        abstract public double [] getClampedVelocity(double []velocities);
}
