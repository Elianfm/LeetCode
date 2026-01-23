public class LemonadeChange {


    /*
     * Straightforward version
     */
    class Solution2 {
        public boolean lemonadeChange(int[] bills) {
            int fiveBills = 0;
            int tenBills = 0;

            for(int i = 0; i<bills.length; i++){
                int bill = bills[i];

                if(bill == 20){
                    fiveBills -= (tenBills>0) ? 1: 3;
                    tenBills -= (tenBills>0) ? 1: 0;
                }else if(bill == 10){
                    fiveBills--;
                }

                if(fiveBills<0) return false;

                switch (bill) {
                    case 5  -> fiveBills++;
                    case 10 -> tenBills++;
                }

            }

            return true;
        }
    }

    /*
     * First try, straightforward simulation keeping track of bills on hand.
     * 
     * Runtime 2ms beats 99.11%
     */
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int fiveBills = 0;
            int tenBills = 0;
            int twentyBills = 0;

            for(int i = 0; i<bills.length; i++){
                int bill = bills[i];
                int change = bill-5;

                while(change > 0){
                    if(change >= 10 && tenBills > 0){
                        tenBills--;
                        change-=10;
                        continue;
                    }
                    if(fiveBills == 0) return false;
                    fiveBills--;
                    change-=5;
                }
                
                switch (bill) {
                    case 5  -> fiveBills++;
                    case 10 -> tenBills++;
                    case 20 -> twentyBills++;
                }

            }

            return true;
        }
    }
}
