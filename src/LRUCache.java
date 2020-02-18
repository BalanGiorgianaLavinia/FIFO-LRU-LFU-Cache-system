import java.util.ArrayList;

/**
 *
 * @author Lavinia
 */
public class LRUCache implements Cache {
    ArrayList<Subscriptie> lru ;
    int lengthOfCache = 0;  //dimensiunea maxima a cache-ului
    
    /**
     *
     */
    public LRUCache(){
        
    }
    
    /**
     *
     * @param lengthOfCache
     */
    public LRUCache(int lengthOfCache) {
        lru = new ArrayList();
        this.lengthOfCache = lengthOfCache;
    }

    
    @Override
    public void add(Subscriptie myObject) {
        
        //daca obiectul este in cache il sterg si il adaug la final
        if(this.search(myObject.getObjName())){
            for(int i = 0; i < lru.size(); i++){
                if(lru.get(i).getObjName().equals(myObject.getObjName())){
                    lru.remove(i);
                    lru.add(myObject);
                    return;
                }
            } 
            
        //daca obiectul nu este in cache si acesta e plin
        //sterg primul obiect(cel mai vechi)
        }else if(lru.size() == this.lengthOfCache){
            remove();
            lru.add(myObject);
            return;
            
        }else{
            lru.add(myObject);
        } 
    }

    
    //metoda sterge primul element din cache
    @Override
    public void remove() {
        lru.remove(0);
    }

    
    //metoda sterge obiectul dat
    @Override
    public void removeObject(Subscriptie myObject) {
        for(int i = 0; i < lru.size(); i++){
            if(lru.get(i).getObjName().equals(myObject.getObjName())){
                lru.remove(i);
                return;
            }
        }
    }

    
    //metoda verifica daca obiectul cu numele cautat este in cache
    @Override
    public boolean search(String objName) {
        for(int i = 0; i < lru.size(); i++){
            if(lru.get(i).getObjName().equals(objName)){
                return true;
            }
        }
        
        return false;
    }

    
    //metoda intoarce referinta catre obiectul cu numele cautat
    @Override
    public Subscriptie obtain(String objName) {
        for(int i = 0; i < lru.size(); i++){
            if(lru.get(i).getObjName().equals(objName)){
                return lru.get(i);
            }
        }
        
        return null;
    }
    
}
