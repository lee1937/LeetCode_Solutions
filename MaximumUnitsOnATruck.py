class MaximumUnitsOnATruck:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        # Since weight across boxes is equal, we'll just take
        # the highest num of units. Runtime is O(n * log n)
        
        # First we just sort the boxTypes in reverse order
        boxTypes.sort(key=lambda x: x[1], reverse=True)
        total = 0
        for n, units in boxTypes:
            boxNum = min(n, truckSize) # don't take more boxes than remaining
            total += boxNum * units # add all boxes to the total units
            truckSize -= boxNum
            if truckSize == 0: # out of boxes so return
                return total
        return total    # Return what we have if capacity is > inventory
