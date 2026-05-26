import heapq

class Twitter:

    def __init__(self):
        self.time = 0 #global time -- used when posting a tweet 
        self.tweets= {} #user id-> set of (time, tweetid) 
        self.following ={} #userid -> set of users that userid follows
        

    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId not in self.tweets: 
            #if userid is not in self.tweets add them 
            self.tweets[userId] = []

        # add users tweet 
        self.tweets[userId].append((self.time, tweetId))
        self.time+=1
        
    def getNewsFeed(self, userId: int) -> List[int]:
        heap = []

        #helper function that helps add tweets 
        def addtweet(uid): 
            # check if uid(userid) has no tweets
            if uid not in self.tweets: 
                return 

            #get the 10 most recent tweets from each user 
            for time, tweet in self.tweets[uid][-10:]: 
                heapq.heappush(heap, (-time, tweet))
        
        addtweet(userId) 

        # add tweets based on who uid is following 
        if userId in self.following: 
            for followee in self.following[userId]: 
                addtweet(followee) 
        
        result = []
        # add to results list based on heap values 
        while heap and len(result) < 10: 
            time, tweet= heapq.heappop(heap) 
            result.append(tweet) 
        return result

        

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId: 
            #check since user cannot follow themselves
            return 
        if followerId not in self.following: 
            #if not in the following list add them to the list 
            #initialize with empty set
            self.following[followerId] = set()
        # add user to following list 
        self.following[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId: 
            #check if user is trying to unfollow themselves 
            return 

        #remove follower from the followerId
        if followerId in self.following: 
            self.following[followerId].discard(followeeId)
        
