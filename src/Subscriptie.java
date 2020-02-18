
/**
 *
 * @author Lavinia
 */
public abstract class Subscriptie {

    /**
     *
     */
    protected String name;
    
    /**
     *
     */
    protected Subscriptie(){
        
    }
    
    /**
     *
     * @param name
     */
    protected Subscriptie(String name){
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getObjName() {
        return this.name;
    }

    /**
     *
     * @return
     */
    protected abstract String getTypeObj();

    /**
     *
     */
    protected abstract void consume();
}
