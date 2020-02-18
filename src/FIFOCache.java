import java.util.ArrayList;

/**
 *
 * @author Lavinia
 */
public class FIFOCache implements Cache {
    ArrayList<Subscriptie> fifo ;
    int lengthOfCache = 0;  //dimensiunea maxima a cache-ului
    
    /**
     *
     */
    public FIFOCache(){
        
    }
    
    /**
     *
     * @param lengthOfCache
     */
    public FIFOCache(int lengthOfCache){
        fifo = new ArrayList();
        this.lengthOfCache = lengthOfCache;
    }
    
    
    @Override
    public void add(Subscriptie myObject) {
        //daca obiectul se gaseste deja in cache, nu fac nimic
        if(this.search(myObject.getObjName())){
            return;
        }
        
        //daca cache-ul e plin sterg elementul de la inceput
        if(fifo.size() == this.lengthOfCache){
            remove();
        }
        
        //adaug obiectul in cache
        fifo.add(myObject);
    }

    
    //functia sterge primul obiect din lista
    @Override
    public void remove() {
        if(fifo.size() > 0){
            fifo.remove(0);
        }
    }

    
    //metoda sterge obiectul dat
    @Override
    public void removeObject(Subscriptie myObject) {
        for(int i = 0; i < fifo.size(); i++){
            if(fifo.get(i).getObjName().equals(myObject.getObjName())){
                fifo.remove(i);
                return;
            }
        }
    }

    
    //metoda cauta obiectul cu numele dat
    @Override
    public boolean search(String objName) {
        for(int i = 0; i < fifo.size(); i++){
            if(fifo.get(i).getObjName().equals(objName)){
                return true;
            }
        }
        
        return false;
    }

    
    //metoda cauta obiectul cu numele dat si returneaza referinta
    @Override
    public Subscriptie obtain(String objName) {
        for(int i = 0; i < fifo.size(); i++){
            if(fifo.get(i).getObjName().equals(objName)){
                return fifo.get(i);
            }
        }
        
        return null;
    }


    
}
