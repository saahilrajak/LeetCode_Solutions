class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            // Check if the top of the stack and current character form "AB" or "CD"
            if (!stack.isEmpty() && ((stack.peek() == 'A' && ch == 'B') || (stack.peek() == 'C' && ch == 'D'))) {
                stack.pop(); // Remove the top of the stack (simulates removing "AB" or "CD")
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
