public class TaskScheduler {


  /*
   * Cleaner version of first try, one pass to get the max and maxs, then calculate the minimum time needed to execute all tasks, 
   * and if the minimum time is less than the number of tasks, return the number of tasks, otherwise return the minimum time.
   * 
   * Runtime 3ms beats 83.92%
   */
  class Solution2 {
      public int leastInterval(char[] tasks, int n) {
          int[] counter = new int[26];
          int max = 0;
          int maxs = 0;

          for(char ch: tasks){
              int count = ++counter[ch - 'A'];

              if(max < count){
                  max = count;
                  maxs = 0;
              }

              if(max == count) maxs++;

          }

          int minRes = ((max-1) * (n+1)) + maxs;
          return Math.max(minRes, tasks.length);   
      }
  }

  /*
   * First try, i count the number of times each task appears, then i get the max number 
   * of times a task appears, and the number of tasks that appear that max number of times, 
   * then i calculate the minimum time needed to execute all tasks, and if the minimum time 
   * is less than the number of tasks, then i return the number of tasks, 
   * otherwise i return the minimum time.
   * 
   * Runtime 4ms beats 78.05%
   */
  class Solution {
      public int leastInterval(char[] tasks, int n) {
          int[] counter = new int[26];
          int max = 0;

          for(char ch: tasks){
              counter[ch - 'A']++;
              max = Math.max(max, counter[ch - 'A']);
          }

          int maxs = 0;
          for(int i: counter) if(i == max) maxs++;


          int minRes = ((max-1) * (n+1)) + maxs;
          int finalRes = (tasks.length - minRes);
          return (finalRes > 0) 
              ? minRes + finalRes
              : minRes;
          
      }
  }

}
