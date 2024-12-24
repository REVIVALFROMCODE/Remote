class LRUCache {
    private final int capacity;
    private final Map<Integer,Integer> map;
    private final LinkedHashSet<Integer> set;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        set=new LinkedHashSet<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        // Move the accessed key to the end to show that it was recently used
        set.remove(key);
        set.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            set.remove(key);
        }else if(map.size()==capacity){
            // If the number of keys exceeds the capacity from this operation, evict the least recently used key.
            int oldest = set.iterator().next();
            set.remove(oldest);
            map.remove(oldest);
        }
        map.put(key,value);
        set.add(key);
    }
}

//Solution2 : extend LinkedHashMap
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache(int capacity) {
      /*
      public LinkedHashMap(int initialCapacity,
                     float loadFactor,
                     boolean accessOrder)
A special constructor is provided to create a linked hash map whose order of iteration is the order in which its entries were last accessed, from least-recently accessed to most-recently (access-order).      */
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }
}
