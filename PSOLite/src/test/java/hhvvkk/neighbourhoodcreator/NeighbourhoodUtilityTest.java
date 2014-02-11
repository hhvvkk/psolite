/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhvvkk.neighbourhoodcreator;

import java.util.ArrayList;
import java.util.LinkedList;
import junit.framework.TestCase;

/**
 *
 * @author root
 */
public class NeighbourhoodUtilityTest extends TestCase {
    int numberOfParticles = 100;
    public NeighbourhoodUtilityTest(String testName) {
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
     * Test of getSize method, of class NeighbourhoodUtility.
     */
    public void testGetSize() {
            NeighbourhoodUtility nh = new NeighbourhoodUtility(numberOfParticles);
            assertEquals(nh.getSize(), numberOfParticles);
    }
    
    /**
     * Test of setSize method, of class NeighbourhoodUtility.
     */
    public void testSetSize() {
            NeighbourhoodUtility nh = new NeighbourhoodUtility(numberOfParticles);
            
            
            //Test invalid new size
            int newInvalidSize = -1;
            
            boolean caughtException = false;
            try{
                    nh.setSize(newInvalidSize);
            }catch(IndexOutOfBoundsException iob){
                    caughtException = true;
            }
            
            assertTrue(caughtException);
            
            //test a valid new size
            int validNewSize = 85;
            
            nh.setSize(validNewSize);
            assertEquals(nh.getSize(), validNewSize);
            
    }

    /**
     * Test of addNeigbour method, of class NeighbourhoodUtility.
     */
    public void testAddNeigbour() {
            
    }

    /**
     * Test of removeParticle method, of class NeighbourhoodUtility.
     */
    public void testRemoveParticle() {
            
    }

    /**
     * Test of getParticles method, of class NeighbourhoodUtility.
     */
    public void testGetParticles() {
            
    }
}
