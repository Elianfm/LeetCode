/* PENDING TO CLEAN */
public class DefuseBomb {
    /*
     * First try, i use sliding window to solve this problem,
     * and a function to reverse the array in case of the negative k.
     * Although i should try a cleaner solution.
     * 
     * Runtime: 0 ms beats 100%
     * Memory: 42.06MB beats 93.59%
     */

    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] decrypt = new int[len];

        int sum = 0;
        int right = 0;
        int left = 0;

        if (k < 0) code = reverseCode(code);

        for (int i = 0; i < Math.abs(k); i++) {
            sum += code[right++];
            if (right == len) right = 0;
        }

        for (int i = 0; i < len; i++) {
            sum += code[right++] - code[left++];
            decrypt[i] = sum;

            if (right == len) right = 0;
            if (left == len) left = 0;
        }

        return (k > 0) ? decrypt : reverseCode(decrypt);
    }

    private int[] reverseCode(int[] code) {
        int[] inverse = new int[code.length];
        int pos = code.length - 1;
        for (int i = 0; i < code.length; i++) {
            inverse[pos--] = code[i];
        }
        return inverse;
    }

}
