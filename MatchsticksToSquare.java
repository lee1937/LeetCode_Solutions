class Solution {
    
    // Store whether a matchstick has been taken in a global array
    static boolean[] taken = new boolean[16];       // 16 is max # of elements in input
    
    public boolean makesquare(int[] matchsticks) {
        // First we will check if the sum is a multiple of 4. If it isn't, it is impossible
        // to make 4 equal lengths of matchsticks using all matchsticks exactly once
    
        // Sort the array first to pick up large objects first
        // Any element larger than binsize will terminate the program
        // matchsticks = Arrays.sort(matchsticks, Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0)
            return false;
        
        // Initialize bin size and the array w
        int binSize = sum / 4;
        for (int i = 0; i < 16; i++) {
            taken[i] = false;
        }
        return viableSquare(matchsticks, 0, binSize, 4, 0);
    }
    
    public boolean viableSquare(int[] matchsticks, int currSum, int binSize, int sides, int index) {
        // First check for base case, we have filled 3 slots
        // Don't need to check the last as the sum must equal the 
        // remaining matchsticks
        if(sides == 1)   
            return true;
        // If we have filled up a bin, 
        if (currSum == binSize)
            return viableSquare(matchsticks, 0, binSize, sides - 1, 0);
        
        // Avoid Array out of Bounds errors
        if (index >= matchsticks.length)
            return false;
        
        // For each remaining element in the array, attempt to put it into this side
        // If they're taken skip, if we get a negative, skip
        // Only return true if a positive match is found
        for (int i = index; i < matchsticks.length; i++) {
            if (taken[i] != true) {
                if (currSum + matchsticks[i] <= binSize) {
                    taken[i] = true; // See if we can get a match by putting i in this side
                    if (viableSquare(matchsticks, currSum + matchsticks[i], binSize, sides, i + 1))
                        return true;
                    taken[i] = false; // Backtrack point, i doesn't work here
                }
            }
        }
        
        return false;
    }
}
