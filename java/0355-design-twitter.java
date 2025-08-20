import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
    https://leetcode.com/problems/design-twitter/
    Difficuilty: Medium

    Time complexity: O(nlogn) for getNewsFeed(), where n is total tweets. O(1) for postTweet/follow/unfollow.
    Space complexity: O(n)

    Solution: have 2 different maps to store all tweets and users info, by this way follow, unfollow, tweet can lineat time O(1)
    - on getNewsFeed(); dump all tweets of given userId and following to maxHeap and retrieve top 10 elements.

    More optimized approach is maintaining a separate feed for every user(this is how twitter was working in the early days) or using a similar approach to `merge-k-sorted-lists` problem to merge last n tweets
*/

class Twitter {
    int order;
    Map<Integer, Set<Integer>> users; // userId -> set of [following users]
    Map<Integer, List<int[]>> tweets; // userId -> list of [tweet IDs, order]

    public Twitter() {
        this.order = 0;
        this.users = new HashMap<>();
        this.tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        this.tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{tweetId, ++this.order});
    }

    public List<Integer> getNewsFeed(int userId) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparing(tw -> tw[1], Comparator.reverseOrder()));

        if(this.tweets.containsKey(userId)) {
            maxHeap.addAll(this.tweets.get(userId));
        }
        for(Integer following: this.users.getOrDefault(userId, Collections.emptySet())) {
            if (tweets.containsKey(following)) {
                maxHeap.addAll(this.tweets.get(following));
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty() && res.size() < 10) {
            res.add(maxHeap.poll()[0]);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        this.users.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        this.users.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */