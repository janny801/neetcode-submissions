class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        //create our result hashmap that gets returned later 
        Map<String, List<String>> resmap = new HashMap<>();  

        //loop thru each string in the input array 
        for (String eachstring : strs)
        {
            //create a freq array of size 26 for a-> z
            //since constraints say that all strings are made 
            //up of only lowercase chars 
            int[] count = new int[26];

            //count the frequency of each character in the current string 
            for (char c: eachstring.toCharArray())
            {
                //convert characters into index (0-25) 
                count[c-'a']++; // inc count to count frequency 
            }

            //convert the frequency array into a unique string key 
            String key = Arrays.toString(count); 

            //if this specific frequency key doesnt exist create a new list for it 
            resmap.putIfAbsent(key, new ArrayList<>()); 

            //add original string 's' to the list matching this frequency key 
            resmap.get(key).add(eachstring);
        }

        //wrap all grouped value lists into a new arrayList
        return new ArrayList<>(resmap.values()); 
        
    }
}
