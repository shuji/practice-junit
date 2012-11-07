package ch07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LruCache<E> {

    final ArrayList<String> keys = new ArrayList<String>();
    private final Map<String, E> entries = new HashMap<String, E>();

    public void put(String key, E item) {
        entries.put(key, item);
        keys.remove(key);
        keys.add(key);
    }

    public E get(String key) {
        if (entries.containsKey(key)) {
            keys.remove(key);
            keys.add(key);
        }
        return entries.get(key);
    }

    public int size() {
        return entries.size();
    }
}
