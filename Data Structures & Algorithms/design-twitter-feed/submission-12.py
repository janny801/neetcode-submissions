import heapq

class Twitter:

    def __init__(self):
        self.time = 0 #global timer 
        self.tweets={} # user -> set of (time, tweetid) 
        self.following = {} #userid -> set of users that user follows 
        

    def postTweet(self, userId: int, tweetId: int) -> None:
        #initialize user in tweet list if not seen before
        if userId not in self.tweets: 
            self.tweets[userId] = []
        # add users tweet 
        self.tweets[userId].append((self.time, tweetId))
        self.time +=1
        

    def getNewsFeed(self, userId: int) -> List[int]:
        heap = [] #implemented as max heap 
        def addtweet(uid): 
            if uid not in self.tweets: 
                return 
            # add last 10 tweets from all users
            for time, tweet in self.tweets[uid][-10:]: 
                heapq.heappush(heap, (-time, tweet))
        # add all current users tweets
        addtweet(userId) 

        # add tweets based on who userId is following 
        if userId in self.following: 
            for followee in self.following[userId]: 
                addtweet(followee)
        #get 10 most recent tweets to return 
        result = []
        while heap and len(result) <10: 
            time, tweetId = heapq.heappop(heap) 
            result.append(tweetId)
        return result
        

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId: 
            return 
        
        #if user is not already in self.following add them 
        if followerId not in self.following: 
            self.following[followerId] = set()
        # add users following 
        self.following[followerId].add(followeeId)
        

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId: 
            return 
        #remove follower 
        if followerId in self.following: 
            self.following[followerId].discard(followeeId)
        
