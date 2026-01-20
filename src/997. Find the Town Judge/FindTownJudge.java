public class FindTownJudge {

    /*
     * Second try, using scores, judge have to have n scores
     * but only can trust in himself, so we search for n-1 scores.
     * 
     * Runtime: 2ms beats 99.73%
     */
    class Solution {
        public int findJudge(int n, int[][] trust) {
            int[] score = new int[n+1];

            for(int[] t:trust){
                score[t[0]]--;
                score[t[1]]++;
            }

            for(int i=1; i<=n; i++)
                if (score[i] == n-1) return i;

            return -1;
        }
    }

    /*
     * First try, i got this solution, is slow but works.
     * 
     * Runtime: 20ms beats 7.08%
     */ 
    class Solution {
        public int findJudge(int n, int[][] trust) {
            if(trust.length == 0) return (n == 1) ? 1: -1;
            
            Map<Integer, Integer> people = new HashMap<>();
            Set<Integer> labeled = new HashSet<>();

            for(int i = 0; i<trust.length; i++){
                int candidate = trust[i][1];
                int count = people.getOrDefault(candidate, 0);
                people.put(candidate, count+1);
                labeled.add(trust[i][0]);
            }

            for(int candidate: people.keySet()){
                int count = people.get(candidate);
                if(
                    !labeled.contains(candidate) && count == n-1
                    || people.get(candidate) == n
                ) return candidate;
            }

            return -1;

        }
    }

}
