class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        //create hashmap that we r going to use for final return 
        Map<String, List<String>> finalMap = new HashMap<>(); 

        //loop thru every string in the input array 
        for (String currString: strs)
        {
            //convert the current string to array of individual chars 
            char[] charArray = currString.toCharArray(); 

            //debug; print out before getting sorted alphabetically
            //System.out.println("before sorting: " + currString); 

            //sort the characters alphabetically 
            Arrays.sort(charArray); 

            //used for debug print 
            String sortedString = new String(charArray); 

            //debug; print out word after sorting alphabetically
            //System.out.println("after sorting:" + sortedString); 

            //check if already exists in the map 
            //if;  not putIfAbsent makes new empty ArrayList for it 
            //else; leaves it alone ts 
            finalMap.putIfAbsent(sortedString, new ArrayList<>()); 

            //get the list that belongs to thsi key 
            finalMap.get(sortedString).add(currString); 


        }

        //take all grouped lists (values) from map and wrap them 
        //into a new arraylist to return 
        return new ArrayList<>(finalMap.values()); 
    }
}
