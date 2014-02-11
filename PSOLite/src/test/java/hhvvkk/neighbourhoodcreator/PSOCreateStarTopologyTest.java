
package hhvvkk.neighbourhoodcreator;

import java.util.ArrayList;
import java.util.LinkedList;
import junit.framework.TestCase;


public class PSOCreateStarTopologyTest extends TestCase {
    
    int largeBound = 1000;
    int smallBound = 2;
    int nullAmount = 0;
    
    public PSOCreateStarTopologyTest(String testName) {
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
     * Test create function of PSOCreateStarTopology.
     */
    public void testCreate() {
            PSOCreateStarTopology instance = new PSOCreateStarTopology();

            assertNotNull(instance);
            
            //should create a ArrayList<LinkedList>> which has 0 elements in it
            ArrayList<LinkedList<Integer>> array = instance.create(nullAmount);
            assertEquals(array.size(), 0);
            
            //test a small bound
            array = instance.create(smallBound);
            assertTrue(array.size() == smallBound);
            assertEquals(array.get(0).size(), smallBound -1);
            assertEquals(array.get(smallBound-1).size(), smallBound -1);
            
            
            //test a large bound
            array = instance.create(largeBound);
            assertTrue(array.size() == largeBound);            
            assertEquals(array.get(0).size(), largeBound -1);
            assertEquals(array.get(largeBound-1).size(), largeBound -1);
            
            //test it is a star topology(Added all other neighbours at each particle)
            for(int i = 0; i < array.size(); i++){
                    //current item is i
                    for(int otherCount = 0; otherCount < array.size(); otherCount++){
                            //if other item index is not the same as current item and other item 

                            if(otherCount == i){
                                    //A particle may not contain itself as a neighbor
                                    if(array.get(i).contains(i))
                                            assertTrue(false);
                            }
                    }
            }
            
    }
    
    
    
    
}
