class RemoveOccurrences {

    /*
     * Second try, using StringBuilder
     * Runtime: 1ms Beats 99.46%
     * Memory: 42.22MB Beats 78.64%
     */
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int index;

        while ((index = sb.indexOf(part)) != -1) {
            sb.delete(index, index + part.length());
        }

        return sb.toString();
    }

    /*
     * First try, using java methods
     * It works, but it's not efficient
     * Runtime: 9ms Beats 18.53%
     * Memory: 44.47MB Beats 41.04%
     */

    /*
     * public String removeOccurrences(String s, String part) {
     * while(s.contains(part))s = s.replaceFirst(part,"");
     * return s;
     * }
     */
}
