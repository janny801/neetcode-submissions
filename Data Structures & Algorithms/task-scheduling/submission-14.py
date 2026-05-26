#return the minimum number of cpu cyles required to complete all tasks

import heapq

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = {}
        for task in tasks: 
            if task in count: 
                count[task ]+=1
            else: 
                count[task]=1

        heap = []
        for task in count: 
            heapq.heappush(heap, -count[task])

        cooldown = [] #sep identical tasks by 'n' (remaining count, time it can be executed again)
        time = 0 

        while heap or cooldown: 
            time +=1 
            if heap: 
                # execute the task and add to cooldown if needed 
                count = heapq.heappop(heap)
                count +=1

                if count != 0: 
                    # add to the cooldown list 
                    cooldown.append((count, time +n )) 
            
            #check the cooldown list if there is anything we can add back 
            i =0 
            while len(cooldown) > i: 
                if cooldown[i][1] == time: 
                    #then it can be executed again 
                    # add back to heap and remove from cooldown 
                    heapq.heappush(heap, cooldown[i][0])
                    cooldown.pop(i) 
                else: 
                    i+=1
        return time 
                


