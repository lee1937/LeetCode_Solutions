class Solution:
    def partitionDisjoint(self, nums: List[int]) -> int:
        n = len(nums)
        lMax = nums[0]      # Max inside left partition (leftMax)
        oMax = nums[0]      # Max found so far in array (overallMax)
        left = 1            
        partition = 0
        while left < n: 
            if nums[left] < lMax:
                # If we find an item smaller than lMax we must include it in left partition
                # Update partition accordingly
                partition = left
                lMax = oMax
            else:
                # If not, simply update the largest thing we've found thus far
                oMax = max(oMax, nums[left])
            left += 1
              
        return partition + 1
                
