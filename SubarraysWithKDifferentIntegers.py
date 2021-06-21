class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        # To keep track of the number of unique elements I'll use a set
        # Each iteration will start at some i in nums and will iterate until
        # The number of elements in the set > k
        
        def slidingWindow(nums, k):
            # Initiate everything to 0, instantiate new data structs
            left, right, count = 0, 0, 0
            found = set()
            hmap = collections.Counter()
            
            # while right pointer is in bounds:
            while right < len(nums):
                # Add nums[r] to list of found ints (count dups in hmap)
                found.add(nums[right])
                hmap[nums[right]] += 1
                
                # while we have too many elements:
                while len(found) > k:
                    hmap[nums[left]] -= 1       # Reduce count of nums[l] by 1
                    if hmap[nums[left]] == 0:   # Remove if necessary
                        found.remove(nums[left])
                    left += 1                   # Move the left edge forward until k
                count += (right - left + 1) # Update the count
                right += 1                  # Move right edge forward
                
            return count
        
        return slidingWindow(nums, k) - slidingWindow(nums, k-1)
