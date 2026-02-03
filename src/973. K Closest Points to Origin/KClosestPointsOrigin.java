import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPointsOrigin {

    // Pending try with quick select

    /*
    * A cleaner version using a max heap with a lambda expression to compare
    * the distances.
    * Runtime: 28ms beats 69.17%
    */
    class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<MyNode> pq 
            = new PriorityQueue<>( (a,b) -> Integer.compare(b.sum, a.sum));

        for(int i = 0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int sum = x*x + y*y;

            if(pq.size() < k){
                pq.offer(new MyNode(points[i], sum));
            } else if(pq.peek().sum > sum){
                pq.poll();
                pq.offer(new MyNode(points[i], sum));
            }
        }

        int[][] res = new int[k][2];

        for(int i = 0; i<k; i++)
            res[i] = pq.poll().points;

        return res;
    }

    private class MyNode{
        int[] points;
        int sum;

        public MyNode(int[] points, int sum){
            this.points = points;
            this.sum = sum;
        }
    }
}

    /*
     * First try, using a max heap to keep track of the k closest points.
     * I calculate the distance using the sum of squares of x and y. then
     * i have a MyNode class that implements comparable to be able to store
     * the points and their distance in the max heap.
     * 
     * Runtime: 44ms beats 18.17%
     */
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<MyNode> pq 
                = new PriorityQueue<>(Collections.reverseOrder());

            for(int i = 0; i<points.length; i++){
                MyNode last = pq.peek();
                int x = points[i][0];
                int y = points[i][1];
                int sum = Math.abs(x*x) 
                        + Math.abs(y*y);

                if(pq.size() < k){
                    pq.offer(new MyNode(points[i], sum));
                } else if(last.sum > sum){
                    pq.poll();
                    pq.offer(new MyNode(points[i], sum));
                }
            }

            int[][] res = new int[k][2];

            for(int i = 0; i<k; i++){
                res[i] = pq.poll().points;
            }

            return res;
        }

        private class MyNode implements Comparable<MyNode>{
            int[] points;
            int sum;

            public MyNode(int[] points, int sum){
                this.points = points;
                this.sum = sum;
            }

            @Override
            public int compareTo(MyNode s){
                if(this.sum == s.sum){
                    return 0;
                }else if(this.sum > s.sum){
                    return 1;
                }
                return -1;
            }

        }
    }
}
