class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if(stack.size() == 0) {
                // If the stack is empty, put char on the stack
                stack.push(ch);
                i++;
            } else if (s.length() == 2) {
                if (s.charAt(0) != s.charAt(1))
                    return s;
                else
                    return "";
            }   else {
                // If not, check if we have a match
                if (ch == stack.peek()) {
                    stack.pop();        // Take this bad boy out of the mix
                    // if last char
                    if (i == s.length() - 1) {
                        s = s.substring(0, i - 1);
                        i++; // Probably doesn't matter tbh
                    } else {
                        // Remove i-1, i. Decrement i to account for new string
                        s = s.substring(0, i - 1) + s.substring(i+1, s.length());
                        i -= 1;
                    }
                } else {
                    stack.push(ch);
                    i++;
                }
            }
        }
        return s;
    }
}
