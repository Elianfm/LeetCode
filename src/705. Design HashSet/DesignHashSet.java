import java.util.ArrayList;
import java.util.HashSet;

public class DesignHashSet {

    // Looks like faster implementations use a fixed size array or 
    // write linkedlists from scratch.

    /*
    * Few tweaks over the first try. Use a prime number as the bucket size to reduce collisions 
    * and use modulo operator to determine the index.
    * 
    * Runtime: 15ms beats 46.51%
    * 
    */
    class MyHashSet3 {
        int buckets = 997;
        ArrayList<Integer>[] hash = new ArrayList[buckets];

        public MyHashSet3() {
            for(int i = 0; i<buckets; i++)
                hash[i] = new ArrayList<>();
        }
        
        public void add(int key) {
            int first = this.getHash(key);
            if(hash[first].contains(key)) return;
            hash[first].add(key);
        }
        
        public void remove(int key) {
            int first = this.getHash(key);
            if(!hash[first].contains(key)) return;
            hash[first].remove((Integer) key);
        }
        
        public boolean contains(int key) {
            int first = this.getHash(key);
            return hash[first].contains(key);
        }

        private int getHash(int key) {
            return key % buckets;
        }


    }



    /*
     * First try, it sucks but works. Idea is simple, use an array of arraylists to store
     * the keys. The index of the array is determined by the first one or two digits of the key,
     * simulating a hash function.
     * 
     * Runtime: 25ms beats 22.96%
     *
     */
    class MyHashSet2 {
        ArrayList<Integer>[] hash = new ArrayList[100];

        public MyHashSet2() {
            for(int i = 0; i<100; i++)
                hash[i] = new ArrayList<>();
        }
        
        public void add(int key) {
            int first = this.getFirst(key);
            if(hash[first].contains(key)) return;
            hash[first].add(key);
        }
        
        public void remove(int key) {
            int first = this.getFirst(key);
            if(!hash[first].contains(key)) return;
            hash[first].remove((Integer) key);
        }
        
        public boolean contains(int key) {
            int first = this.getFirst(key);
            return hash[first].contains(key);
        }

        private int getFirst(int key) {
            key = Math.abs(key);
            if (key < 10) return key;
            return Integer.parseInt(String.valueOf(key).substring(0, 2));
        }

    }

    //lol
    class MyHashSet extends HashSet<Integer> {}
}

