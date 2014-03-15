
package hhvvkk.updatestrategy;

import java.util.ArrayList;

public class UpdatePool extends ArrayList<UpdateTopology>{
        UpdatePool(){
                
        }
        
        @Override
        public UpdateTopology get(int index) throws IndexOutOfBoundsException{
                if(index >= super.size() || index < 0)
                        throw new IndexOutOfBoundsException("Index supplied to the UpdatePool was invalid. Size("+super.size()+") and index supplied("+index+")");
                
                return super.get(index);
        }
        
        public void update()
}
