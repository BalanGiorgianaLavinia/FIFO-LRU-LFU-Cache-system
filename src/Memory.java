import java.util.ArrayList;

/**
 *
 * @author Lavinia
 */
public class Memory {
    ArrayList<Subscriptie> memory;
    
    /**
     *
     */
    public Memory(){
       memory = new ArrayList();
    }

    /**
     *
     * @param myObject
     */
    public void addObject(Subscriptie myObject) {
        //daca gasesc elementul il suprascriu 
        for(int i = 0; i < memory.size(); i++){
            if(memory.get(i).getObjName().equals(myObject.getObjName())){
                memory.remove(i);
                memory.add(i, myObject);
                return;
            }
        }
        
        //daca elementul nu e in lista il adaug 
        memory.add(myObject);
    }

    
    //metoda verifica daca obiectul cu numele cautat se gaseste in memorie

    /**
     *
     * @param objName
     * @return
     */
    public boolean search(String objName) {
        for(int i = 0; i < memory.size(); i++){
            if(memory.get(i).getObjName().equals(objName)){
                return true;
            }
        }
        
        return false;
    }

    
    //metoda intoarce referinta la obiectul cu numele cautat

    /**
     *
     * @param objName
     * @return
     */
    public Subscriptie obtain(String objName) {
        for(int i = 0; i < memory.size(); i++){
            if(memory.get(i).getObjName().equals(objName)){
                return memory.get(i);
            }
        }
        return null;

    }
    
  
}
