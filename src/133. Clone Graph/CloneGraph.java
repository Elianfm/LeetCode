import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {


    /*
     * First try, previously i did something similar with a linked list, so i tried to use it here
     * a map to store the relationship between the original node and the new node, and a recursive function
     * to visit all the nodes and clone them. If the node was already cloned i return the clone from the map, 
     * if not i create a new node and add it to the map, then i visit all the neighbors of the node and add them 
     * to the neighbors of the new node.
     * 
     * Runtime 24ms to 28ms (leetcode is not consistent with the runtime) beats 96.68%
     */
    class Solution {
        Map<Node, Node> map;

        public Node cloneGraph(Node node) {
            map = new HashMap<>();
            return visitAndClone(node);
        }

        private Node visitAndClone(Node node){
            if(node == null) return null;
            if(map.containsKey(node)) return map.get(node);

            Node newNode = new Node(node.val);
            map.put(node, newNode);

            List<Node> newNeighbors = new ArrayList<>(node.neighbors.size());
            for(Node n: node.neighbors) newNeighbors.add(visitAndClone(n));
            newNode.neighbors = newNeighbors;
            //map.put(node, newNode);

            return newNode;
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
