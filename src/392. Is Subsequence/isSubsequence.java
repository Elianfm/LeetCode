class isSubsequence {

    /*
     * First try, i used two pointers at first but i realize i could use the i in
     * the for loop to iterate through the string t. So i just used one pointer
     * instead. 
     * Runtime 1ms Beats 93.39% 
     * Memory 41.48 Beats 68.74%
     */

    public boolean isSubsequence(String s, String t) {
        int pointer_a = 0; // i will use this pointer for string s
        int len_s = s.length()-1;

        if(len_s == -1) return true;

        for(int i = 0; i<t.length(); i++){
            if(s.charAt(pointer_a) == t.charAt(i)) pointer_a++;
            if(pointer_a > len_s) return true;
        }

        return false;
    }
}
