
/**
 *
 * @author Lavinia
 */
public class Premium extends Basic{
    int premium_request = 0;
    
    /**
     *
     */
    public Premium(){
        
    }
    
    /**
     *
     * @param name
     * @param basic_request
     * @param premium_request
     */
    public Premium(String name, int basic_request, int premium_request){
        super(name, basic_request);
        this.premium_request = premium_request;
    }
    
    
    //obiectul e premium daca are nr de cereri premium nenul
    //in caz contrar verifca daca e basic
    @Override
    public String getTypeObj(){
        if(premium_request > 0){
            return "Premium";
        }else{
            return super.getTypeObj();
        }
    }
    
    
    //metoda scade numarul de cereri premium pentru un obiect premium
    //daca nu mai are cereri premium, apeleaza functia din superclasa 
    @Override
    public void consume(){
        if(this.premium_request > 0){
            this.premium_request--;
        }else{
            super.consume();
        }
    }
    
}
