import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    /*
     * Third try, i realized that the timestamp is always increasing, so i don't really
     * need to use a Treemap, instead i use a object called Pair to store the timestamp and value.
     * I also use a binary search to find the max value less than the timestamp. 
     * 
     * Runtime: 133ms beats 88.23%
     * Memory: 119mb beats 65.81%
     */
    class TimeMap3 {
        private class Pair{
            int timestamp;
            String value;
            
            public Pair(int timestamp, String value){
                this.timestamp = timestamp;
                this.value = value;
            }
        }
    
        Map<String, List<Pair>> values;
    
        public TimeMap3() {
            values = new HashMap();
        }
        
        public void set(String key, String value, int timestamp) {
            values
            .computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Pair(timestamp, value));
        }
        
        public String get(String key, int timestamp) {
            if(!values.containsKey(key)) return "";
            List list = values.get(key);
            return binarySearch(list, 0, list.size()-1, new Pair(0,""), timestamp+1).value;
        }
    
        private Pair binarySearch(List<Pair> elements, int left, int right, Pair best, int limit){
            if(left > right) return best;
    
            int mid = (left+right)/2;
            Pair midNum = elements.get(mid);
    
            return (midNum.timestamp < limit) 
                ? binarySearch(elements, mid+1, right, midNum, limit)
                : binarySearch(elements, left, mid-1, best, limit);
    
        }
    
    }


    /*
     * Second try, i change the HashMap to a TreeMap, and using the floorKey method to get 
     * the max value less than the timestamp. 
     * 
     * Runtime: 164ms beats 14.63%
     * Memory: 121.63mb beats 36.99%
     */
    class TimeMap2 {
        Map<String, TreeMap> values;
    
        public TimeMap2() {
            this.values = new HashMap();
        }
        
        public void set(String key, String value, int timestamp) {
            TreeMap<Integer,String> map = new TreeMap();
            if(this.values.containsKey(key)) map = this.values.get(key);
            map.put(timestamp,value);
            this.values.put(key,map);
        }
        
        public String get(String key, int timestamp) {
            if(!this.values.containsKey(key)) return "";
    
            TreeMap<Integer,String> map = this.values.get(key);
    
            if(map.isEmpty()) return "";
            if(map.containsKey(timestamp)) return map.get(timestamp);
    
            Integer max = map.floorKey(timestamp);
            return (max != null) ? map.get(max) : "";
     
        }
    }


    /* 
     * First try, using a HashMap to store the key and a HashMap to store the time and value.
     * It works, but it is not efficient. I got TLE.
     */
    class TimeMap {
    Map<String, TreeMap> values;

    public TimeMap() {
        this.values = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> map = new TreeMap();

        if(this.values.containsKey(key)) map = this.values.get(key);

        map.put(timestamp,value);
        this.values.put(key,map);
    }
    
    public String get(String key, int timestamp) {
        if(!this.values.containsKey(key)) return "";

        TreeMap<Integer,String> map = this.values.get(key);

        if(map.isEmpty()) return "";

        if(map.containsKey(timestamp)) return map.get(timestamp);

        Integer max = map.floorKey(timestamp);
    
        return (max != null) ? map.get(max) : "";
 
    }

    // O(n) without binary search
    private int maxLimitValue(Set<Integer> set, int limit){
        int max = 0;

        for(int s : set)
            if (s<limit) max = Math.max(max, s);
        
        return max;
    }
}


}
