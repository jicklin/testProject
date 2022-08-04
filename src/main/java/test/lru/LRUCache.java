package test.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author mal
 * @date 2022-08-04 17:03
 */
public class LRUCache extends LinkedHashMap<Object,Object> {
    private static final long serialVersionUID = 1L;


    Integer cacheSize;

    public LRUCache(Integer cacheSize) {
        super(cacheSize, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > cacheSize;
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put("1", "1");
        lruCache.put("2", "2");
        lruCache.put("3", "3");
        lruCache.put("4", "4");
        System.out.println(lruCache);

    }

}
