import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 * Generic cache to store webpages
 * @param <K> - Key generic
 * @param <V> - Value generic
 *
 * @author Daniel Rosales-Rodriguez
 */
public class Cache <K, V extends KeyInterface<K>>{

    private double cacheHit;
    private int cacheSize;
    private LinkedList<V> cache;
    private double numReferences;

    /**
     * Constructor for Webpage cache.
     * @param cache -   Size of cache
     */
    public Cache(int cache){
        this.cacheSize = cache;
        this.cache = new LinkedList<V>();
        this.cacheHit = 0;
        this.numReferences = 0;
    }

    /**
     * Searches and reads webpage cache using a Key object.
     * @param key -  Key
     * @return Webpage if Key matches it. Otherwise, return null.
     */
    public V get(K key){

        numReferences++;
        // iterates through cache
        for (int i = 0; i < cache.size(); i++){
             V webpage = cache.get(i);
             // checks to see if webpage is in the cache
             if(webpage.getKey().equals(key)){
                 cacheHit++;
                 // removes the least recently used webpage
                 cache.remove(webpage);
                 // adds most recently used webpage to front of cache
                 cache.addFirst(webpage);
                 return webpage;
             }
        }
        return null;
    }

    /**
     * Adds webpage to front of the cache.
     * @param webpage
     */
    public void add(V webpage){

        if(cache.size() >= cacheSize){
            // removes last entry in cache
            cache.removeLast();
        }
        cache.addFirst(webpage);
    }

    /**
     * Removes webpage from cache.
     * @param key - Key
     * @return webpage
     */
    public V remove (K key){

        V webpage = get(key);
        cacheHit++;
       if(webpage == null){
           // returns null if webpage is not in cache
           return null;
       }
       // removes webpage from the cache
       cache.remove(webpage);
       return webpage;
    }

    /**
     * Clears cache.
     */
    public void clear(){
        cache.clear();
    }

    /**
     * Prints out cache statistics.
     * @return str - The cache statistics.
     */
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        double hitRatio = (cacheHit/numReferences)*100;
        String str = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Cache with "+ cacheSize+ " entries has been created\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Total number of references:         "+ (int) numReferences+ "\n" +
                "Total number of cache hits:         " + (int) cacheHit + "\n" +
                "Cache hit percent:                  " + decimalFormat.format(hitRatio)+"%" +"\n" +
                "\n" +
                "----------------------------------------------------------------" ;
        return str;
    }
}
