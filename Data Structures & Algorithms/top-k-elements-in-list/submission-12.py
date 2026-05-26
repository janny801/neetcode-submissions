class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {} 
        #count hashmap stores... 
            #index = value itself 
            #value = frequency that values appear in the nums array 
        
        #fill in the nums array 
        for num in nums: 
            #if in count already then increment 
            if num in count: 
                count[num]+=1
            else: 
                #if not then set frequency to 1 
                count[num]=1
        
        bucket =[]
        #bucket stores frequencies of values 
        #index = frequency that values appear in nums 
        #value = list of all numbers that appear with this frequency 

        #initially fill bucket with empty []
        for i in range(len(nums)+1): 
            bucket.append([])
        
        #fill in buckets based on frequency 
        for num in count: 
            freq= count[num]
            bucket[freq].append(num) #add to the right list 
                                    #based on the frequency ...  
                                    #it appears in nums 

        result = []
        freq= len(bucket)-1
        while freq>0: 
            #keep going while the frequency > 0 
            #iterate backwards thru frequency and decrement 
                #so that gets the most frequent values 
            for num in bucket[freq]: 
                result.append(num) 

                #check if we already have the 'k' most elements
                if len(result) ==k: 
                    return result 
            freq -=1

        