class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        /* This is a sliding window problem, so we can solve it in O(n)
         * To maximize the number of happy customers we'll keep track of the
         * biggest DIFFERENCE in a window of time if the shopkeep uses his technique
         */
        int bestDiff = 0;
        int currDiff = 0;
        // Do a total of happy customers if he doesn't use his tech.

        int right = 0; 
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1)
                currDiff += customers[i];
        }
        bestDiff = currDiff;
        // We're tracking the window as bestLeft...bestRight INCLUSIVE
        int bestRight = minutes - 1;
        for (right = minutes; right < customers.length; right++) {
            // Update currDiff
            if (grumpy[right - minutes] == 1)
                currDiff -= customers[right - minutes];
            if (grumpy[right] == 1)
                currDiff += customers[right];
            // Check and change if necessary
            if (currDiff > bestDiff) {
                bestDiff = currDiff;
                bestRight = right;
            }
        }
        int bestLeft = bestRight - minutes + 1;     // +1 because inclusive
        int total = 0;
        // If in window increment. Else if !grumpy, increment
        for (int i = 0; i < customers.length; i++) {
            if (i >= bestLeft && i <= bestRight)
                total += customers[i];
            else if(grumpy[i] == 0)
                total += customers[i];
        }
        return total;
        
    }
}
