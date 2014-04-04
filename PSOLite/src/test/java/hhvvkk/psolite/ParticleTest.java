/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhvvkk.psolite;

import hhvvkk.velocityclamp.VelocityClamper;
import junit.framework.TestCase;

/**
 *
 * @author root
 */
public class ParticleTest extends TestCase {
    Particle aParticle = new Particle();
    
    public ParticleTest(String testName) {
            super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
            super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
            super.tearDown();
    }

    /**
     * Test of setC1 method, of class Particle.
     */
    public void testSetC1() {
            //test first set c1
            double c1Value = 1.33;
            aParticle.setC1(c1Value);
            
            double afterC1Set = aParticle.getC1();
            
            assertEquals(c1Value, afterC1Set);
            
            //test second set c1
            c1Value = 3;
            aParticle.setC1(c1Value);
            
            c1Value = aParticle.getC1();
            
            assertEquals(c1Value, c1Value);
    }

    /**
     * Test of setC2 method, of class Particle.
     */
    public void testSetC2() {
            //test first set c2
            double c2Value = 1.55;
            aParticle.setC2(c2Value);
            
            double afterC2Set = aParticle.getC2();
            
            assertEquals(c2Value, afterC2Set);
            
            //test second set c2
            c2Value = 3;
            aParticle.setC2(c2Value);
            
            afterC2Set = aParticle.getC2();
            
            assertEquals(c2Value, afterC2Set);
    }

    /**
     * Test of setW method, of class Particle.
     */
    public void testSetW() {
            
            //test first set c2
            double wValue = 1.55;
            aParticle.setW(wValue);
            
            double afterWSet = aParticle.getW();
            
            assertEquals(wValue, afterWSet);
            
            //test second set c2
            wValue = 3;
            aParticle.setC2(wValue);
            
            afterWSet = aParticle.getW();
            
            assertEquals(wValue, afterWSet);
            
    }

    /**
     * Test of setData method, of class Particle.
     */
    public void testSetData() {
            double[] xNullVal = null;
            double[] vNullVal = null;
            double[] xValueSize6 = new double[6];
            double[] vValueSize6 = new double[6];
            double[] xValueSize4 = new double[4];
            double[] vValueSize4 = new double[4];
            
            
            boolean correct = false;
            
            
            /////////TEST whether set may have null values
            try{
                    aParticle.setData(xNullVal, vNullVal);
            }catch(NullPointerException ne){
                    correct = true;
            }
            
            checkFailSettingData(correct);
            
            correct = false;
            
            ///////TEST whether xValue is null
            try{
                    aParticle.setData(xNullVal, vValueSize6);
            }catch(NullPointerException ne){
                    correct = true;
            }
            
            checkFailSettingData(correct);
            
            correct = false;
            ///////TEST whether xValue is null
            try{
                    aParticle.setData(xValueSize6, vNullVal);
            }catch(NullPointerException ne){
                    correct = true;
            }
            
            checkFailSettingData(correct);
            
            //////TEST check set dissimilar items
            correct = false;
            try{
                    aParticle.setData(xValueSize6, vValueSize4);
            }catch(NullPointerException ne){
                    correct = true;
            }
            
            checkFailSettingData(correct);
            
            correct = true;
            //////TEST check setting is correct
            //////Different from above, it must be true
            //////Otherwise test fails
            for(int i = 0; i < xValueSize6.length; i++){
                    xValueSize6[i] = i*i;
            }
            
            for(int i = 0; i < vValueSize6.length; i++){
                    vValueSize6[i] = i+i;
            }
            
            try{
                    aParticle.setData(xValueSize6, vValueSize6);
            }catch(NullPointerException ne){
                    correct = false;
            }
            
            checkFailSettingData(correct);
            
            //////TEST check if X data is set correctly
            correct = true;
            double []gottenXValue = aParticle.getPosition();
            for(int i = 0; i < gottenXValue.length; i++){
                    if(gottenXValue[i] != xValueSize6[i]){
                            correct = false;
                    }
            }
            
            checkFailSettingData(correct);
    }
    
    /**
     * Checks whether the set data is correct, else fails the test.
     * @param correct The parameter if it is correct or not
     */
    private void checkFailSettingData(boolean correct){
        
            if(!correct){
                    fail("Setting particle velocities(v values) and position(x values) values may not be null and should throw exception.");
            }
            
    }
    
    /**
     * Test of getBestPosition method, of class Particle.
     */
    public void testGetBestPosition() {
            //Currently not implemented
    }

    /**
     * Test of move method, of class Particle.
     */
    public void testMove() {
            int size = 15;
            double []velocities = new double[size];
            double []position = new double [size];
            
            for(int i =0; i < size; i++){
                    velocities[i] = i;
                    position[i] = i*i;
            }
        
            //set velocities and position
            aParticle.setData(position, velocities);
            //get particle position
        
            //move particle
            aParticle.move();
            
            //get new position
            double []currentPosition = aParticle.getPosition();
            
            //create success move
            double []shouldBePosition = new double[size];
            
            for(int i = 0; i < size; i++){
                    shouldBePosition[i] = position[i] + velocities[i];
            }
            
            boolean success = true;
            
            for(int i = 0; i< size; i++){
                    if(shouldBePosition[i] != currentPosition[i]){
                            success = false;
                            break;
                    }
            }
            
            assertTrue(success);
    }

    /**
     * Test of getFitness method, of class Particle.
     */
    public void testGetFitness() {
        System.out.println("getFitness");
        Particle instance = new Particle();
        double expResult = 0.0;
        double result = instance.getFitness();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPBest method, of class Particle.
     */
    public void testGetPBest() {
            //get pBest not currently implemented
    }

    /**
     * Test of updateFitness method, of class Particle.
     */
    public void testUpdateFitness() {
        System.out.println("updateFitness");
        double newValue = 0.0;
        boolean maximize = false;
        Particle instance = new Particle();
        instance.updateFitness(newValue, maximize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVelocityClamper method, of class Particle.
     */
    public void testSetVelocityClamper() {
        //blah
    }

}
