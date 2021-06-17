class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        # First attempt to solve via double loop O(n^2) failed via timeout, but likely was
        # logically correct
        
        # This is solved in one pass by counting the number of elements before and after
        # values which fall above the range we are searching for
        count = 0
        leftBound = 0 
        middle = 0
        for item in nums:
            if item > right:      # Have we found an item too large to be included?
                middle = 0          # Reset if we have
            else:
                middle += 1         # move middle point along
                count += middle     # Additional subarrays detected
            if item >= left:      # Have we found a valid max?
                leftBound = 0       # reset left bound if we have
            else:                
                leftBound += 1      # Move left bound along
                count -= leftBound  # remove subarrays
        return count
