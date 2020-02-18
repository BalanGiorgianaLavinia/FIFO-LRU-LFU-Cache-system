
/**
 *
 * @author Lavinia
 */
public interface Cache {

    /**
     *
     * @param myObject
     */
    public abstract void add(Subscriptie myObject);
    
    /**
     *
     */
    public abstract void remove();

    /**
     *
     * @param myObject
     */
    public abstract void removeObject(Subscriptie myObject);

    /**
     *
     * @param objName
     * @return
     */
    public abstract boolean search(String objName);

    /**
     *
     * @param objName
     * @return
     */
    public abstract Subscriptie obtain(String objName);
}
