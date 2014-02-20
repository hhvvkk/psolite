/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VelocityClamp;
   

public class MultiplyClamper extends VelocityClamper {
        //the multiplier used in order to set the value 
        private double reductionMultiplier = 0.9;
        
        public MultiplyClamper(double []velocities){
                setMaxVelocities(velocities);
        }
        
        public MultiplyClamper(double [] velocities, double multiplier){
                setMaxVelocities(velocities);
                reductionMultiplier = multiplier;
        }
        
        /**
         * Gets the clamped velocity by multiplying all velocities by the reductionMultiplier until all velocity values are correct
         * @param currentVelocity : The current velocity
         * @return Returns the clamped velocity after clamping the current velocity entered
         */
        @Override
        public double [] getClampedVelocity(double []currentVelocity){
                //while it is in violation of maximum velocity
                //clamp the current velocity
                while(violateVelocity(currentVelocity)){
                        for(int i = 0; i < currentVelocity.length; i++){
                                currentVelocity[i] = currentVelocity[i] * reductionMultiplier;
                        }
                }
                return currentVelocity;
        }
}
