
/**
 *
 * @author Lavinia
 */
public class Basic extends Free {
    int basic_request;
    
    /**
     *
     */
    public Basic(){
        
    }
    
    /**
     *
     * @param name
     * @param basic_request
     */
    public Basic(String name, int basic_request){
        super(name);
        this.basic_request = basic_request;
    }

    
    //daca are cereri basic obiectul e basic, daca nu, e free
    @Override
    public String getTypeObj() {
        if(basic_request > 0){
            return "Basic";
        }else{
            return super.getTypeObj();
        }
    }
    
    
    //metoda scade numarul de cereri basic (daca exista)
    @Override
    public void consume(){
        if(this.basic_request > 0){
            this.basic_request--;
        }
    }
}
