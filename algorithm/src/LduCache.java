import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LduCache {
    private static int counter = 0;
    private TreeMap<Integer, Integer> recentVisit;
    private Map<Integer, Integer> visitRecord;
    private Map<Integer, Integer> cache;
    private final int capacity;
    public LduCache(int capacity) {
        this.capacity = capacity;
        this.recentVisit = new TreeMap<>();
        this.visitRecord = new HashMap<>(capacity);
        this.cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            updateVisit(key);
            return cache.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
        } else {
            if (cache.size() >= capacity) {
                cache.remove(recentVisit.firstEntry().getValue());
                visitRecord.remove(recentVisit.firstEntry().getValue());
                recentVisit.remove(recentVisit.firstKey());
            }
            cache.put(key, value);
        }

        updateVisit(key);
    }

    private void updateVisit(int key) {
        if (visitRecord.containsKey(key)) {
            recentVisit.remove(visitRecord.get(key));
        }
        final int count = ++counter;
        recentVisit.put(count, key);
        visitRecord.put(key, count);
    }

    public static void main(String[] args) {
        LduCache cache = new LduCache(2);
        cache.set(2,1);
        cache.set(2,2);
        cache.get(2);
        cache.set(1,1);
        cache.set(4,1);
        System.out.println(cache.get(2));
    }
}