import java.util.ArrayList;

/**
 *
 * @author Lavinia
 */
public class LFUCache implements Cache {
    ArrayList<LFUSubscriptie> lfu ;
    int lengthOfCache = 0;  //dimensiunea maxima a cache-ului
    
    /**
     *
     */
    public LFUCache(){
        
    }
    
    /**
     *
     * @param lengthOfCache
     */
    public LFUCache(int lengthOfCache) {
        lfu = new ArrayList();
        this.lengthOfCache = lengthOfCache;
    }

    
    @Override
    public void add(Subscriptie myObject) {
        LFUSubscriptie newSub = new LFUSubscriptie(myObject);
        
        //daca obiectul e in cache, il sterg, incrementez accesarile
        if(this.search(myObject.getObjName())){
            LFUSubscriptie LFUtmp = obtainLFU(myObject.getObjName());
            this.removeObject(myObject);
            LFUtmp.incrementAccesses();
            //il adaug la finalul listei
            lfu.add(LFUtmp);
            return;
            
        //daca lista e plina sterg primul obiect(cel mai vechi)
        }else if(lfu.size() == this.lengthOfCache){
            remove();
            
            //il adaug la finalul listei
            lfu.add(newSub);
            return;
            
        //daca lista e goala    
        }else{
            lfu.add(newSub);
        }
        
    }

    
    @Override
    public void remove() {
        if(lfu.size() == 0){
            return;
        }
        
        int minAccess = Integer.MAX_VALUE;
        int minIndex = -1;
        
        //caut elementul cu cele mai putine accesari
        for(int i = 0; i < lfu.size(); i++){
            if(lfu.get(i).getAccess() < minAccess){
                minAccess = lfu.get(i).getAccess();
                minIndex = i;
            }
        }
        
        //il sterg
        lfu.remove(minIndex);
    }

    
    //metoda sterge din cache obiectul dat
    @Override
    public void removeObject(Subscriptie myObject) {
        for(int i = 0; i < lfu.size(); i++){
            if(lfu.get(i).getSubscriptie().getObjName().equals(myObject.getObjName())){
                lfu.remove(i);
                return;
            }
        }
    }

    
    //metoda verifica daca obiectul cu numele cautat e in cache
    @Override
    public boolean search(String objName) {
        for(int i = 0; i < lfu.size(); i++){
            if(lfu.get(i).getSubscriptie().getObjName().equals(objName)){
                return true;
            }
        }
        
        return false;
    }

    
    //metoda intoarce referinta la obiectul cu numele dat daca e in cache
    @Override
    public Subscriptie obtain(String objName) {
        for(int i = 0; i < lfu.size(); i++){
            if(lfu.get(i).getSubscriptie().getObjName().equals(objName)){
                return lfu.get(i).getSubscriptie();
            }
        }
        
        return null;
    }
    
    
    //metoda intoarce referinta la obiectul care contine si numarul de accesari

    /**
     *
     * @param objName
     * @return
     */
    public LFUSubscriptie obtainLFU(String objName) {
        for(int i = 0; i < lfu.size(); i++){
            if(lfu.get(i).getSubscriptie().getObjName().equals(objName)){
                return lfu.get(i);
            }
        }
        
        return null;
    }
    
}
