package ch06;

import java.util.HashMap;
import java.util.Map;

public class ItemStockImpl implements ItemStock {
    private final Map<String, Integer> list = new HashMap<String, Integer>();

    public void add(String item, int num) {
        int oldSize = size(item);
        int newSize = oldSize + num;
        list.put(item, newSize);
    }

    public int size(String item) {
        Integer size = list.get(item);
        return (size != null) ? size : 0;
    }

    public boolean contains(String item) {
        return 0 < size(item);
    }

}
