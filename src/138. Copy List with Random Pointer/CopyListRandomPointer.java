import java.util.Map;
import java.util.HashMap;

public class CopyListRandomPointer {


    /*
     * First try, i pass through the list twice, the first time i create a new node for each node in the original 
     * list and store the mapping in a hash map, the second time i set the next and random pointers for each new node 
     * using the mapping in the hash map.
     * 
     * Runtime 0ms beats 100%
     */
    class Solution {
        public Node copyRandomList(Node head) {
            if(head == null) return null;
            Map<Node, Node> kv = new HashMap<>();

            Node newHead = new Node(head.val);
            kv.put(head,newHead);

            Node actual = head.next;
            Node prev = newHead;
            while(actual != null){
                Node newNode = new Node(actual.val);
                prev.next = newNode;
                
                kv.put(actual,newNode);
                prev = prev.next;
                actual = actual.next;
            
            }

            actual = head;
            Node newActual = newHead;
            while(newActual != null){
                Node prevRandom = actual.random;
                Node newRandom = kv.get(prevRandom);

                newActual.random = newRandom;

                actual = actual.next;
                newActual = newActual.next;
            }

            return newHead;
        }
    }

        class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
