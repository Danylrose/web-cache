
/**
 * CacheTest, that uses the WebpageGenerator
 * and the Cache to process Webpages
 *
 * @author Daniel Rosales-Rodriguez
 */
public class CacheTest {

    /**
     * Arguments for Webpage cache statistics.
     * @param args - arguments
     */
    public static void main(String args[] ){
        if (args.length < 4){
            System.out.println("Usage: <cache-size> <number-of-Webpages> <standard-deviation> <debug-level=0-3> [<seed>]\n");
            System.exit(1);
        }

        double currentTime = System.currentTimeMillis();
        WebpageGenerator generator;
        long seed = -1;
        int cacheSize = Integer.parseInt(args[0]);
        int numWebPages = Integer.parseInt(args[1]);
        double standardDeviation = Double.parseDouble(args[2]);
        int debugLevel = Integer.parseInt(args[3]);

        Cache<String, Webpage> cache;
        cache = new Cache<String, Webpage>(cacheSize);

        if(args.length < 5){
           generator = new WebpageGenerator(numWebPages,standardDeviation);
        }
        else {
            seed = Long.parseLong(args[4]);
            generator = new WebpageGenerator(numWebPages,standardDeviation,seed);
        }
        // iterates through webpages
        for(int i = 0; i < numWebPages; i++){

            String url = generator.getURL();
            if(cache.get(url) == null){
                // generates webpage if it's not in cache
                Webpage webpage = generator.readPage(url);
                // webpage is added to front of cache
                cache.add(webpage);
            }
        }
        // optional debug levels
        if(debugLevel == 0){
            // prints cache stats
            cache.toString();
        }
        else if(debugLevel == 1){
            // prints webpage distributions and cache stats
            generator.getWebpageDatabasePings();
            cache.toString();
        }
        else if(debugLevel == 2){
            // prints webpages and cache stats
            generator.printWebpages(3);
            cache.toString();
        }

        double endTime = System.currentTimeMillis();
        double timeElapsed = endTime - currentTime;
        // prints cache stats and time elapse status
        System.out.println(cache.toString());
        System.out.println("Time elapsed: " + timeElapsed + " milliseconds");
        System.out.println("----------------------------------------------------------------");
    }
}
