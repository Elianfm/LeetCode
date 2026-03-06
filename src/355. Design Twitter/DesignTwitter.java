import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {


    /*
     * Second try, here i store the tweets of each user in a priority queue, and when i want to get the news feed, 
     * i create a new priority queue with the most recent tweet of each user that the user follows, and then i poll 
     * the most recent tweet from this new priority queue, and add it to the result, and then i add the next tweet of
     * the same user to the new priority queue, and repeat this process until i have 10 tweets in the result or the
     * new priority queue is empty.
     * 
     * Runtime 34ms beats 49.04%
     */

    class Twitter2 {
        int timeline;
        Map<Integer, PriorityQueue<Tweet>> mapTweets;
        Map<Integer, Set<Integer>> mapFollows;

        public Twitter2() {
            timeline = Integer.MAX_VALUE;
            mapTweets = new HashMap<>();
            mapFollows = new HashMap<>();
        }
        
        public void postTweet(int userId, int tweetId) {
            PriorityQueue<Tweet> pq = mapTweets.getOrDefault(userId, 
                    new PriorityQueue<Tweet>((a,b) -> Integer.compare(a.time, b.time)));

            Tweet tw = new Tweet(timeline--, tweetId);
            if(pq.size() > 10) pq.poll();
            pq.offer(tw);
            mapTweets.put(userId, pq);
        }
        
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> pqTemp = 
                new PriorityQueue<Tweet>((a,b) -> Integer.compare(a.time, b.time));

            Set<Integer> follows = mapFollows.getOrDefault(userId, new HashSet<>());
            follows.add(userId);

            List<PriorityQueue<Tweet>> ls = new ArrayList<>();

            for(Integer f: follows)
                ls.add(new PriorityQueue<>(mapTweets.getOrDefault(f, new PriorityQueue<>())));        
            List<Integer> result = new ArrayList<>();

            for(int i = 0; i<ls.size(); i++){
                PriorityQueue<Tweet> temp = ls.get(i);
                if(!temp.isEmpty()){
                    Tweet tempTweet = temp.poll();
                    tempTweet.idx = i;
                    pqTemp.offer(tempTweet);
                }
            }

            while(!pqTemp.isEmpty() && result.size() < 10){
                Tweet recentTweet = pqTemp.poll();
                int tempIdx = recentTweet.idx;
                result.add(recentTweet.tweetId);
                PriorityQueue<Tweet> temp = ls.get(tempIdx);
                if(!temp.isEmpty()){
                    Tweet tempTweet = temp.poll();
                    tempTweet.idx = tempIdx;
                    pqTemp.offer(tempTweet);
                }
            }

            return result;

        }
        
        public void follow(int followerId, int followeeId) {
            Set<Integer> follows = mapFollows.getOrDefault(followerId, new HashSet<>());
            follows.add(followeeId);
            mapFollows.put(followerId, follows);
        }
        
        public void unfollow(int followerId, int followeeId) {
            if(mapFollows.containsKey(followerId))
                mapFollows.get(followerId).remove(followeeId);
        }

        private class Tweet{
            int time;
            int tweetId;
            int idx;

            public Tweet(int time, int tweetId){
                this.time = time;
                this.tweetId = tweetId;
            }
        }
    }

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
