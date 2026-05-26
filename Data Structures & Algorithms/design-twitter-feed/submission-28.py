import heapq

class Twitter:

    def __init__(self):
        self.time = 0 # global timer
        # use self.time when creating posting new tweets
        self.tweets= {} # maps userid -> (time, tweetid) 
        self.following = {} #maps userid -> set of users that userid follows
        

    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId not in self.tweets: 
            self.tweets[userId] = []
        
        # add tweet 
        self.tweets[userId].append((self.time, tweetId))
        self.time+=1 #inc time 
        

    def getNewsFeed(self, userId: int) -> List[int]:
        heap = []
        #helper function to add tweets to the heap 
        def addtweet(uid): 
            if uid not in self.tweets: 
                return 
            # add last 10 tweets from given user
            for time, tweets in self.tweets[uid][-10:]: 
                heapq.heappush(heap, (-time, tweets)) 
        # add own users tweets 
        addtweet(userId)

        # add tweets based on userId friends
        if userId in self.following: 
            for followee in self.following[userId]: 
                # 
                addtweet(followee) 
        result = []
        # add to the results list 
        while heap and len(result) <10: 
            time, tweet= heapq.heappop(heap) 
            result.append(tweet) 
        return result

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId: 
            return 
        if followerId not in self.following: 
            self.following[followerId] = set()
        
        self.following[followerId].add(followeeId)
        

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId: 
            return 
        if followerId in self.following: 
            self.following[followerId].discard(followeeId)
        
