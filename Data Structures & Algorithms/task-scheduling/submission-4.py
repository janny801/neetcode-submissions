#goal ; find the minimum number of cpu cycles required to complete all tasks

#constraints
# - identical tasks must be separated by at least n cpu cycles

import heapq

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = {}#stores the count of each char in the tasks 
        for task in tasks: 
            if task in count: 
                count[task] +=1
            else: 
                count[task] =1
        
        #fill heap as maxheap (insert as negative) 
        heap = []
        for task in count: 
            heapq.heappush(heap, -count[task]) #push negative 
        
        #cooldown list 
        cooldown = [] #stores (remaining count, time it can go back into being ready)
        time = 0
        while heap or cooldown: 
            #keep checking as long as either the heap or cooldown are not empty 
            time +=1
            
            #check if there is somethign to execute 
            if heap: 
                count = heapq.heappop(heap) 
                count +=1 #decrement (since we add as negative to heap) 

                # add to cool down if count != 0 
                if count != 0: 
                    # add  to cooldown 
                    cooldown.append((count, time +n))
            
            #check if anything in the cooldown can be added back to the heap 
            i=0
            while i< len(cooldown): 
                if cooldown[i][1] ==time: 
                    #cooldown[i][1] stores the time same task can be executed again 
                    #so add back to the heap 
                    heapq.heappush(heap, cooldown[i][0])
                    cooldown.pop(i)
                else: 
                    i+=1
        return time
