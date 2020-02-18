
/**
 *
 * @author Lavinia
 */
public class Free extends Subscriptie {

    /**
     *
     */
    public Free(){
        
    }
    
    /**
     *
     * @param name
     */
    public Free(String name){
        this.name = name;
    }

    @Override
    public String getTypeObj() {
        return "Free";
    }

    @Override
    public void consume() {
        //nimic de scazut, free e nelimitat
    }
}
