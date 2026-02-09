public class LargestElementArray {

    /*
     * First try, in this problem i can't use a sort, so i use a priority queue instead
     * Logic is simple, we keep adding elementes till we have k elements, then we check
     * if new element is bigger than the smallest element in the queue, if it is,
     * we remove the smallest element and add the new one, at the end we return
     * the smallest element in the queue, which is the kth largest element in the array
     * 
     * Runtime 45ms beats 67.39% 
     */
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> largest = new PriorityQueue<>();

            for(int i = 0; i<nums.length; i++){
                int actual = nums[i];

                if(largest.size() < k){
                    largest.offer(actual);
                    continue;
                }

                if(actual > largest.peek()){
                    largest.poll();
                    largest.offer(actual);
                }
            }

            return largest.peek();
        }
    }
}
