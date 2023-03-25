package homework3.datedmap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DatedMapImpl implements DatedMap {

    private Map<String, String> mainMap = new HashMap<>();
    private Map<String, Date> keyDates = new HashMap<>();

    @Override
    public void put(String key, String value) {
        mainMap.put(key, value);
        keyDates.put(key, new Date());
    }

    @Override
    public String get(String key) {
        return this.mainMap.get(key);
    }

    @Override
    public boolean containsKey(String key) {
        return this.mainMap.containsKey(key);
    }

    @Override
    public void remove(String key) {
        this.mainMap.remove(key);
        this.keyDates.remove(key);
    }

    @Override
    public Set<String> keySet() {
        return this.mainMap.keySet();
    }

    @Override
    public Date getKeyLastInsertionDate(String key) {
        return this.keyDates.get(key);
    }
}
