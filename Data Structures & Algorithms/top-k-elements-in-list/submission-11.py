class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {} #maps ; number -> frequency 
        for num in nums: 
            #if in count already then increment 
            if num in count: 
                count[num]+=1
            else: 
                #if not there set to 1 
                count[num]=1

        #print count for testing 
        print(count) 
        
        #create buckets 
        #index = frequency a number appears in original nums array
        #value = list of numbers that have 'index' frequency
        bucket =[]

        #initialize the bucket with empty [] for each index 
        #so that we can append later on 
        for num in range(len(nums)+1): 
            bucket.append([]) #doing this allows us to append 
                            #based on index later on when filling 
                            #based on the count hashmap 

        #fill in buckets 



        