class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        # Use a helper function to build top down DP Solution
        def recurse(numRows):
            # First check if needed
            if numRows > 0:
                recurse(numRows - 1) # Immediately recurse
                arr.append([1] * numRows) # Fill row w/ 1s
                for i in range(1, numRows - 1):
                    # Add values from prev row to current row
                    val1 = arr[numRows - 2][i]
                    val2 = arr[numRows - 2][i - 1]
                    arr[numRows - 1][i] = val1 + val2
        arr = []
        recurse(numRows)
        return arr
