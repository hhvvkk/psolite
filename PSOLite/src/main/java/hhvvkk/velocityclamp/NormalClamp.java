
package hhvvkk.velocityclamp;

public class NormalClamp extends VelocityClamper {
        
        public NormalClamp(double []velocities){
                setMaxVelocities(velocities);
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
                                if(violateIndividual(i, currentVelocity[i])){
                                        currentVelocity[i] = getMaxVelocityAt(i);
                                }
                        }
                }
                return currentVelocity;
        }
}
