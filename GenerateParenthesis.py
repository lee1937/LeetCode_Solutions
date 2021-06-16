class Solution:  
    paren = set()
    def generateParenthesis(self, n: int) -> List[str]:
        # While we could build a library of possible strings via recursion, I think
        # it will be easier to just build from scratch by tracking the number of 
        # left and right parenthesis
        arr = []
        # Sub function below
        #######################################################
        def addParenthesis(index, remaining, seq):
            # If our index has reached max, begin the work
            if index == 2 * n:
                potential = [0] * 2 * n
                for i in range(2 * n):
                    potential[i] = "(" if seq & 1 << i else ")"
                arr.append("".join(potential))
                return
            # Indicate additional parentheses to be closed
            if remaining: 
                addParenthesis(index + 1, remaining - 1, seq)
            # Build up phase where we increase index and parentheses
            if (2 * n) - index > remaining: 
                addParenthesis(index + 1, remaining + 1, seq | 1 << index)
        #######################################################

        # Initialize everything to 0 as we start with nothing
        addParenthesis(0, 0, 0)
        return arr
        
