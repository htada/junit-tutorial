package junit.tutorial;

import java.util.HashMap;
import java.util.Map;

public class ItemStock {

    Map<String, Integer> items = new HashMap<String, Integer>();
    
    public int size(String itemName) {
        return items.size();
    }

    public boolean contains(String itemName) {
        return items.containsKey(itemName);
    }

    public void add(String itemName, int amount) {
        if (contains(itemName)) {
            items.put(itemName, items.get(itemName) + amount);
        } else {
            items.put(itemName, amount);
        }
    }

}
