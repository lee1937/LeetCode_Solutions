class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums = sorted(nums)     
        ans = [[]]              # Init w/ empty set
        pos = {}                # Track position w/ a dict
        for i in nums:          # Iterate through every item 
            start = pos.get(i, 0)       # get start position from position
            length = len(ans)           # length by items found thus far
            for j in ans[start:]:       # Create new options via already found options
                ans = ans + [j + [i]]
            pos[i] = length             # update position
        return ans
        
        
