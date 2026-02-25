public class CapacityShipPackagesWithinDDays {

    /*
     * First try, similar to Koko Eating bananas, but instead of finding the max speed, we need to find the min weight per day
     * i find min and max weight, then i do a binary search to find the best day, 
     * if the days is less than or equal to the given days, i try to decrease weight per day
     * if the days is more than the given days, i need to increase the weight per day
     * 
     * Runtime: 11ms beats 70.05%
     */
    class Solution {
        int bestDay;

        public int shipWithinDays(int[] weights, int days) {
            int sum = 0;
            int min = 0;

            for(int weight: weights)
                min = Math.max(min, weight); 

            for(int weight: weights)
                sum += weight;

            bestDay = sum;
            shipping(weights,days, min, sum);
            return bestDay;
        }

        private void shipping(int[] weights, int days, int left, int right){        
            if(left > right) return;

            int mid = (left+right)/2;

            int midDays = getDays(weights, mid);

            if(midDays <= days) bestDay = Math.min(bestDay, mid);

            if(days >= midDays){
                shipping(weights, days, left, mid-1);
            }else{
                shipping(weights, days, mid+1, right);
            }

        }

        private int getDays(int[] weights, int maxWeight){
            int days = 1;
            int counter = 0;

            for(int i = 0; i<weights.length; i++){
                counter += weights[i];
                if(counter > maxWeight){
                    days++;
                    counter = weights[i];
                }
            }

            return days;
        }
    }
}
