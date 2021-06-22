class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        
        // Binary search in each word helps turn this from a naive solution of 
        // O(n * m) (n = length of s, m = # words) to O(n + mlogn)
        // This is algorithmically faster
        ArrayList<ArrayList<Integer>> indices = new ArrayList<ArrayList<Integer>>();
        
        // Initialize the ArrayLists in indices
        for (int i = 0; i < 26; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            indices.add(temp);
        }
        // Populate Indices
        for (int i = 0; i < s.length(); i++) {
            int chValue = s.charAt(i) - 'a';
            indices.get(chValue).add(i);
        }
        // Sort through each word
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() > s.length())
                continue;
            int prev = -1;      // Initialize to -1 because we haven't found any yet
            boolean match = true;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                ArrayList<Integer> arr = indices.get(word.charAt(j) - 'a');
                int index = upperBound(arr, prev);
                if (index == arr.size())
                    match = false;
                else
                    prev = arr.get(index);
            }
            if (match)
                count++;
        }
        return count;
    }
    
    // Returns upper bound
    private int upperBound(ArrayList<Integer> arr, int i) {
        int left = -1;
        int right = arr.size();
        int mid;
        while (left + 1 < right) {
            mid = (left + right) >>> 1;
            if (arr.get(mid) <= i)
                left = mid;
            else
                right = mid;
        }
        return left + 1;
    }
}
