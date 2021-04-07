import java.util.Set;

public class Run {
    public static void main(String[] args) {
            Hash hash = new Hash();
            
            System.out.println(hash.map.get("Song 3")); //print one

            Set<String> mapKeys = hash.map.keySet(); //print all
            for(String key : mapKeys) {
                System.out.println(String.format("%s: %s", key, hash.map.get(key)));
            } 
    }
}