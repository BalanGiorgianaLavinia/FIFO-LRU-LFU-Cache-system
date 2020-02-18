
/**
 *
 * @author Lavinia
 */
public class LFUSubscriptie {
    Subscriptie subscriptie;
    int access; //nr de accesari ale unui obiect din LFUCache
    
    /**
     *
     */
    public LFUSubscriptie(){
        
    }
    
    /**
     *
     * @param subscriptie
     */
    public LFUSubscriptie(Subscriptie subscriptie){
        this.subscriptie = subscriptie;
        this.access = 0;
    }

    /**
     *
     * @return
     */
    public Subscriptie getSubscriptie() {
        return subscriptie;
    }

    /**
     *
     * @param subscriptie
     */
    public void setSubscriptie(Subscriptie subscriptie) {
        this.subscriptie = subscriptie;
    }

    /**
     *
     * @return
     */
    public int getAccess() {
        return access;
    }

    /**
     *
     * @param access
     */
    public void setAccess(int access) {
        this.access = access;
    }

    /**
     *
     */
    public void incrementAccesses() {
        this.access++;
    }
    
    
}
