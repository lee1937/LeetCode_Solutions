class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        left, right, longest, rem = 0, 0, 0, k
        # Left, right: bounds of the window
        # Longest: best solution so far
        # rem: number of flips remaining
        currLen = 0
        for right in range(len(nums)):
            # Start by moving right forward
            if nums[right] == 0:
                rem -= 1            # Decrease num flips remaining if necessary
            currLen += 1        # Increase length
            while rem < 0 and left < len(nums):      
                # If we've flipped too many no longer in valid state
                # Iterate through until we remove a flip
                if nums[left] == 0:
                    rem += 1
                left += 1
                currLen -= 1 
            # After we have returned to a valid state, update longest if necessary
            if currLen > longest:
                longest = currLen
        return longest
        
