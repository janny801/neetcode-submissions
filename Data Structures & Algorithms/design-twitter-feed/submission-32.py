import heapq

class Twitter:

    def __init__(self):
        self.time = 0
        self.tweets={} # maps userid -> set of (time, tweetid) 
        self.following={} # maps userid -> set of users that userid follows
        

    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId not in self.tweets: 
            self.tweets[userId] = []
        
        self.tweets[userId].append((self.time, tweetId))
        self.time +=1        

    def getNewsFeed(self, userId: int) -> List[int]:
        heap = []
        # helper function to help add tweets to the heap 
        def addtweet(uid): 
            if uid not in self.tweets: 
                return 
            
            # add 10 tweets from user that is passed in  
            for time, tweet in self.tweets[uid][-10:]:
                heapq.heappush(heap, (-time, tweet))
        addtweet(userId)

        # add tweets from friends
        if userId in self.following: 
            for followee in self.following[userId]: 
                addtweet(followee)
        
        result= []
        while heap and len(result) < 10: 
            time, tweet = heapq.heappop(heap)
            result.append(tweet)
        return result

        

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId: 
            return 
        # initialize user if they dont follow anyone yet 
        if followerId not in self.following: 
            self.following[followerId] = set()
        
        # follow other user 
        self.following[followerId].add(followeeId)
        

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId: 
            # cant unfollow urself
            return 
        
        # make the unfollow occur if the follow exists 
        if followerId in self.following: 
            self.following[followerId].discard(followeeId)
        
