package ch18.ex05;

import java.util.HashMap;
import java.util.Map;

/**
 * リスト18.11 ItemStockクラス
 * @author shuji.w6e
 */
public class ItemStock {

    private final Map<String, Integer> values = new HashMap<String, Integer>();

    public void add(Item item) {
        Integer num = values.get(item.name);
        if (num == null) num = 0;
        num++;
        values.put(item.name, num);
    }

    public int getNum(Item item) {
        Integer num = values.get(item.name);
        return num != null ? num : 0;
    }

}
