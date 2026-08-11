class Twitter {
    private static int timestamp = 0;

    private class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private Map<Integer, Set<Integer>> follows;
    private Map<Integer, List<Tweet>> tweets;

    public Twitter() {
        follows = new HashMap<>() ;
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time) ;

        Set<Integer> followedUsers = follows.getOrDefault(userId, new HashSet<>());
        Set<Integer> allUsers = new HashSet<>(followedUsers);
        allUsers.add(userId);

        for(int user : allUsers) {
            List<Tweet> userTweets = tweets.get(user);
            if(userTweets != null) {
                int count = 0;
                for(int i = userTweets.size() -1; i>= 0 && count < 10; i--){
                    maxHeap.add(userTweets.get(i));
                    count++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        while(!maxHeap.isEmpty() && count <10) {
            result.add(maxHeap.poll().id) ;
            count++;
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
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