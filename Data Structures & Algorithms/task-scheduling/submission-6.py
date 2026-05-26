import heapq

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = {}
        for task in tasks: 
            if task in count: 
                #if already in count dict then increment 
                count[task]+=1
            else: 
                #else add to the count dict with 1 
                count[task]=1
        
        #fill out the max heap ( add as negative)
        heap = []
        for task in count: 
            heapq.heappush(heap, -count[task])
        
        #cooldown list (remaining of same task, time available to execute again) 
        cooldown = []
        time = 0

        while heap or cooldown: 
            time +=1
            #see if we can execute anything 
            if heap: 
                #if heap is not empty execute something 
                count = heapq.heappop(heap) 
                count +=1 #decreases count (inc since negative) 

                if count != 0: 
                    #if count is not 0 then add to cooldown list 
                    cooldown.append((count, time +n ))

            #check cooldown list if there is something to add back to heap 
            i=0
            while i< len(cooldown): 
                if cooldown[i][1] == time: 
                    heapq.heappush(heap, cooldown[i][0]) #push back to heap remaining of the same task to execute 
                    cooldown.pop(i) #remove what we added back to heap 
                else: 
                    i+=1
        return time

        