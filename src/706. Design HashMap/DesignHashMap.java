import java.util.ArrayList;

public class DesignHashMap {

    /*
    * First try, following the same idea as DesignHashSet, i store a 'MyElement' object
    * that contains both key and value. In this case i cant compare integers directly,
    * so i override the equals method in MyElement class to compare only keys.
    * 
    * Runtime: 17ms beats 76.42%
    */
    class MyHashMap {
        int buckets = 997;
        ArrayList<MyElement>[] hash = new ArrayList[buckets];

        public MyHashMap() {
            for (int i = 0; i < buckets; i++)
                hash[i] = new ArrayList<>();
        }

        public void put(int key, int value) {
            int first = this.getHash(key);
            MyElement element = new MyElement(key, value);
            int idx = hash[first].indexOf(element);

            if (idx != -1) {
                hash[first].get(idx).value = value;
            } else {
                hash[first].add(element);
            }
        }

        public int get(int key) {
            int first = this.getHash(key);
            MyElement element = new MyElement(key);
            int idx = hash[first].indexOf(element);
            return (idx != -1) ? hash[first].get(idx).value : -1;

        }

        public void remove(int key) {
            int first = this.getHash(key);
            MyElement element = new MyElement(key);
            // if(!hash[first].contains(element)) return;
            hash[first].remove(element);
        }

        private int getHash(int key) {
            return key % buckets;
        }
    }

    class MyElement {
        int key;
        int value;

        public MyElement(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public MyElement(int key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            MyElement other = (MyElement) o;
            return this.key == other.key;
        }

    }
}
