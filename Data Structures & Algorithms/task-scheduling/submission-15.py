import heapq


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = {}
        for task in tasks: 
            if task in count: 
                count[task]+=1
            else: 
                count[task] =1
        

        heap =[]
        for task in count: 
            heapq.heappush(heap, -count[task])

        cooldown = [] # (remaining count of tasks, time that can be executed again )
        time = 0

        while heap or cooldown: 
            time +=1
            if heap: 
                count = heapq.heappop(heap) 
                count +=1

                if count != 0: 
                    # add to cooldown list 
                    cooldown.append((count, time +n))
            
            #check cooldown list if there is something that we can execute
            i = 0 
            while i< len(cooldown): 
                # add back to heap and remove from cooldown list 
                if cooldown[i][1] == time: 
                    heapq.heappush(heap, cooldown[i][0])
                    cooldown.pop(i) 
                else: i+=1
        return time 

