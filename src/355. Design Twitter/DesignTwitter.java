import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {

    /*
     * First try, using a priority queue to store all the tweets, and a map to store the following relationship.
     * Runtime TLE
     */
    class Twitter {
        int date;
        PriorityQueue<Tweet> pq;
        Map<Integer, HashSet> following;

        public Twitter() {
            date = Integer.MAX_VALUE;
            pq = new PriorityQueue<>((a,b) -> Integer.compare(a.date,b.date));
            following = new HashMap<>();
        }
        
        public void postTweet(int userId, int tweetId) {
            Tweet tw = new Tweet(userId, tweetId, date--);
            pq.offer(tw);
        }
        
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> copyPq = new PriorityQueue<>(pq);
            List<Integer> feed = new ArrayList<>();
            
            Set<Integer> follows = following.getOrDefault(userId, new HashSet<Integer>());

            while(feed.size() < 10 && !copyPq.isEmpty()){
                Tweet tw = copyPq.poll();
                if(tw.userId == userId || follows.contains(tw.userId)) feed.add(tw.tweetId);
            }

            return feed;
        }
        
        public void follow(int followerId, int followeeId) {
            HashSet<Integer> set = following.getOrDefault(followerId, new HashSet<Integer>());
            set.add(followeeId);
            following.put(followerId, set);
        }
        
        public void unfollow(int followerId, int followeeId) {
            HashSet<Integer> set = following.getOrDefault(followerId, new HashSet<Integer>());
            set.remove(followeeId);
            following.put(followerId, set);
        }

        private class Tweet{
            int userId;
            int tweetId;
            int date;

            public Tweet(int userId, int tweetId, int date){
                this.userId = userId;
                this.tweetId = tweetId;
                this.date = date;
            }
        }
    }

}
