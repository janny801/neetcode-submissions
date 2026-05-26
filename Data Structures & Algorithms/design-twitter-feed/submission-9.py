import heapq

class Twitter:

    def __init__(self):
        self.time = 0 #global time counter 
        self.tweets = {} #userid -> set of (time, tweetid)
        self.following= {} #userid-> set of users they follow 
        

    def postTweet(self, userId: int, tweetId: int) -> None:
        #initialize user in tweet list if not seen this user before 
        if userId not in self.tweets: 
            self.tweets[userId] = [] #use a list since order matters and users can make multiple tweets
        # add tweet with current item 
        self.tweets[userId].append((self.time, tweetId))
        self.time+=1
        

    def getNewsFeed(self, userId: int) -> List[int]:
        heap = [] #implement as a max heap
        #helper function to add users tweets
        def addTweets(uid): 
            if uid not in self.tweets: 
                return 
            #only need the last 10 tweets from each user 
            for time, tweet in self.tweets[uid][-10:]: 
                #use negative since implementing as max heap 
                heapq.heappush(heap, (-time, tweet))
        # add each users tweets
        addTweets(userId) 

        # add tweets from followed users 
        if userId in self.following: 
            for followee in self.following[userId]: 
                addTweets(followee) 
        
        # extract 10 most recent tweets 
        result = []
        while heap and len(result) < 10: 
            time, tweetId = heapq.heappop(heap) 
            result.append(tweetId)
        return result
        

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId: 
            return 
        if followerId not in self.following: 
            self.following[followerId] = set()
        # add followers 
        self.following[followerId].add(followeeId)
        

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId: 
            return 
        if followerId in self.following: 
            self.following[followerId].discard(followeeId)
        
