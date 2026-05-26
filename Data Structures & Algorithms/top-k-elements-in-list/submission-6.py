class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}
        for num in nums: 
            #add to the counts map 
            if num in count: 
                count[num]+=1
            else: 
                count[num]=1
        
        #create buckets to fill 
        buckets=[]#list of lists that stores the amt of frequency for each number value from the nums list 
        for i in range(len(nums)+1): 
            buckets.append([])
        #fill buckets with proper values 
        for num in count: 
            freq= count[num]
            buckets[freq].append(num)

        #create the result list to return and return 
        result = []
        freq= len(buckets)-1
        while freq>0: 
            for num in buckets[freq]: 
                result.append(num) 
                if len(result) ==k: 
                    return result

            freq-=1

        