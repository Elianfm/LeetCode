public class JumpGame {

    /*
     * Second try, i just jump and keep jumping 
     * Runtime: 2ms beats 85.78%
     */
    class Solution2 {
        public boolean canJump(int[] nums) {
            int maxJump = 0;

            for(int i = 0; i<nums.length; i++){
                if(maxJump < i) return false;
                maxJump = Math.max(maxJump, i + nums[i]);
            }

            return true;
        }
    }

    /*
     * First try, i just jump and remember where i jumped
     * but i jumped too slow
     * Runtime 134ms beats 9.37%
     */
    class Solution {
        int[] nums;
        boolean[] jumped;
        int len;

        public boolean canJump(int[] nums) {
            this.len = nums.length;
            this.nums = nums;
            this.jumped = new boolean[len];
            return jump(0);
        }

        private boolean jump(int pos){
            if(pos >= len) return false;
            if(pos == len - 1) return true;
            if(jumped[pos]) return false;

            int actual = nums[pos];
            for(int i = actual; i>0; i--)
                if(jump(pos+i)) return true;
            
            jumped[pos] = true;
            return false;
        }


    }
}
