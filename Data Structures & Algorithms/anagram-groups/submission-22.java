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
            System.out.println(currString); 

            //sort the characters alphabetically 
            Arrays.sort(charArray); 

            //used for debug print 
            String sortedString = new String(charArray); 

            //debug; print out word after sorting alphabetically
            System.out.println(sortedString); 

        }

        //take all grouped lists (values) from map and wrap them 
        //into a new arraylist to return 
        return new ArrayList<>(finalMap.values()); 
    }
}
