import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/**
 *
 * @author Lavinia
 */
public class Main {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //deschid fisierul de input
        File inputFile = new File(args[0]); 
        BufferedReader input = new BufferedReader(new FileReader(inputFile));
        
        //deschid fisierul de output
        PrintWriter output = new PrintWriter(args[1], "UTF-8");

        String typeOfCache = input.readLine();
        int lengthOfCache = Integer.parseInt(input.readLine());
        int numberOp = Integer.parseInt(input.readLine());
       
        //creez o instanta a cache-ului corespunzator
        Cache cache = null;
        if(typeOfCache.equals("FIFO")){
            cache = new FIFOCache(lengthOfCache);
        }else if(typeOfCache.equals("LRU")){
            cache = new LRUCache(lengthOfCache);
        }else{
            cache = new LFUCache(lengthOfCache);
        }
        
        //creez o instanta a memoriei principale 
        Memory memory = new Memory();
        
        for(int i = 0; i < numberOp; i++){
            String string = input.readLine();
            //impart fiecare linie in string-uri pe care le retin in vector
            String[] vec = string.split(Pattern.quote(" "));
            String operation = vec[0];
            String objName = vec[1];
            
            
            //ADD
            if(operation.equals("ADD")){
                int basic_request = Integer.parseInt(vec[2]);
                int premium_request = 0;
                if(vec.length == 4){
                    premium_request = Integer.parseInt(vec[3]);
                }
            
                //creez obiectul
                Subscriptie myObject ;
                if(premium_request > 0){
                    myObject = new Premium(objName, basic_request, premium_request);
                }else if(basic_request > 0){
                    myObject = new Basic(objName, basic_request);
                }else{
                    myObject = new Free(objName);
                }
                
                //adaug noul element in memorie sau il suprascriu daca exista 
                memory.addObject(myObject);
                
                //sterg elementul din cache daca se gaseste
                cache.removeObject(myObject);
            
                
            //GET
            }else if(operation.equals("GET")){
                
                //verific daca obiectul se gaseste in cache  
                if(cache.search(objName)){
                    //metoda add nu face nimic pentru fifo in acest caz
                    //pentru lru si lfu gaseste obiectul si il actualizeaza
                    cache.add(cache.obtain(objName));
                    
                    output.write("0 " + cache.obtain(objName).getTypeObj() + "\n");
                    
                    //scad nr corespunzator de cereri(consume)
                    cache.obtain(objName).consume();
                 
                //daca obiectul se gaseste in memorie, nu si in cache    
                }else if(memory.search(objName)){
                    output.write("1 " + memory.obtain(objName).getTypeObj() + "\n");
                    
                    //scad nr corespunzator de cereri(consume)
                    memory.obtain(objName).consume();
                    
                    //il adaug in cache
                    cache.add(memory.obtain(objName));
                }else{
                    output.write("2\n");
                }
            }      
        }
        output.close();
    }

    
    
}
