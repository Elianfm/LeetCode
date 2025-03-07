import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

    /*
     * First try, using sliding window and two sets to store the repeated and
     * unique sequences. After some optimizations i got the below solution.
     * 
     * Runtime: 14ms Beats 97.37%
     * Memory: 53.46MB Beats 66.75%
     */

     public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10) return new ArrayList<>();

        Set<String> exist = new HashSet<>();
        Set<String> multiple = new HashSet<>();

        for(int left = 0; left <= s.length()-10; left++){
            String chain = s.substring(left,left+10);
            
            if(!exist.add(chain)){
                multiple.add(chain);
            }
        }

        return new ArrayList<>(multiple);
    }
}
