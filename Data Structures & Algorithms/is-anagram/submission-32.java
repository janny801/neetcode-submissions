class Solution {
    public boolean isAnagram(String s, String t) 
    {
        //edge case; if not the same length 
        if (s.length()!= t.length())
        {
            return false; 
        }

        //initialize empty hashmaps for both strings 
        HashMap<Character, Integer> counts = new HashMap<>(); 
        HashMap<Character, Integer> countt= new HashMap<>(); 

        //loop thru strings at the same time 
        for (int i = 0; i< s.length(); i++)
        {
            //get current character
            //find existing count and add 1

            //for string s
            char chars = s.charAt(i); 
            if (counts.containsKey(chars))
            {
                //if it exists increment 
                int currentcount = counts.get(chars); 
                counts.put(chars, currentcount+1); 
            }
            else
            {
                //doenst exist so make value 1 
                counts.put(chars, 1); 
            }

            //for string t 
            char chart= t.charAt(i); 
            if(countt.containsKey(chart))
            {
                //if alrady there increment
                int currentcount = countt.get(chart);
                countt.put(chart, currentcount+1);
            }
            else
            {
                //make character value 1 
                countt.put(chart, 1); 
            }
        }
        //check if both values have the same values
        return counts.equals(countt); 

    }
}
