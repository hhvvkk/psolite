package hhvvkk.neighbourhoodcreator;

import java.util.ArrayList;
import java.util.LinkedList;
import junit.framework.TestCase;

/**
 *
 * @author root
 */
public class PSOCreateRingTopologyTest extends TestCase {
    
    int largeBound = 1000;
    int smallBound = 2;
    int nullAmount = 0;
    
    public PSOCreateRingTopologyTest(String testName) {
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
     * Test of create method, of class PSOCreateRingTopology.
     */
    public void testCreate() {
            PSOCreateRingTopology instance = new PSOCreateRingTopology();

            assertNotNull(instance);
            //should create a ArrayList<LinkedList>> which has 0 elements in it
            ArrayList<LinkedList<Integer>> array = instance.create(nullAmount);
            assertEquals(array.size(), 0);
            
            //test a small bound (1)--(0) one and zero is connected
            array = instance.create(smallBound);
            assertTrue(array.size() == smallBound);
            assertEquals(array.get(0).size(), 1);
            assertEquals(array.get(1).size(), 1);
            
            
            //test a large bound
            array = instance.create(largeBound);
            assertTrue(array.size() == largeBound);
            
            //test it is a ring topology(Added all other neighbours at each particle)
            for(int i = 0; i < array.size(); i++){
                    int next = i+1;
                    int previous = i-1;
                    
                    if(next >= array.size())
                            next = 0;
                    
                    if(previous <= -1){
                            previous = array.size()-1;
                    }
                    
                    //contains only the required items(thus it is a size of 2
                    assertTrue(array.get(i).contains(next));
                    assertTrue(array.get(i).contains(previous));
                    assertTrue(array.get(i).size() == 2);
                    
            }
    }
}
