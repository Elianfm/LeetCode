/* PENDING  
*/
public class AddBinary {

    /*
     * SECOND TRY - I replaced the string concatenation with a StringBuilder.
     * Runtime: 1ms - Beats 99.90%
     * Memory 42.68MB - Beats 23.37%
     */

     public String addBinary(String a, String b) {
        StringBuilder output = new StringBuilder();
        int flag = 0;
        int a_end = a.length() - 1;
        int b_end = b.length() - 1;
        while(a_end >= 0 || b_end >= 0){
            if(a_end >= 0 && a.charAt(a_end--) == '1') flag++;
            if(b_end >= 0 && b.charAt(b_end--) == '1') flag++;
            output.append((flag%2 == 1) ?  "1": "0");
            flag = (flag>1) ? 1: 0;
        }

        if (flag == 1) output.append("1");
        return output.reverse().toString();
    }

    /*
     * FIRST TRY - It works but is not efficient.
     * Concat two strings is expensive, so is slow.
     */

    /*
     * public String addBinary(String a, String b) {
     * String output = "";
     * int flag = 0;
     * int a_end = a.length() - 1;
     * int b_end = b.length() - 1;
     * while (a_end >= 0 || b_end >= 0) {
     * if (a_end >= 0 && a.charAt(a_end--) == '1')
     * flag++;
     * if (b_end >= 0 && b.charAt(b_end--) == '1')
     * flag++;
     * output += (flag % 2 == 1) ? "1" : "0";
     * flag = (flag > 1) ? 1 : 0;
     * }
     * 
     * if (flag == 1)
     * output += "1";
     * return reverse(output);
     * }
     * 
     * private String reverse(String str) {
     * if (str.isEmpty()) {
     * return str;
     * }
     * return reverse(str.substring(1)) + str.charAt(0);
     * }
     */
}
