class CustomStack {
    private int[] stack;  // Array to hold stack elements
    private int top;      // Points to the top element of the stack
    private int maxSize;  // Maximum size of the stack

    // Constructor to initialize the stack with a maximum size
    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];  // Create an array for the stack
        this.top = -1;                  // Stack is initially empty
        this.maxSize = maxSize;         // Set the maximum size
    }

    // Push method to add an element to the stack
    public void push(int x) {
        if (top < maxSize - 1) {        // Check if the stack is not full
            stack[++top] = x;           // Increment top and add element
        }
    }
   // Pop method to remove and return the top element from the stack
    public int pop() {
        if (top == -1) {                // Check if the stack is empty
            return -1;                  // Return -1 if empty
        }
        return stack[top--];            // Return the top element and decrement top
    }
// Increment method to add a value to the bottom k elements
    public void increment(int k, int val) {
        // Increment only the bottom k elements, or all elements if k is greater than the size of the stack
        for (int i = 0; i < Math.min(k, top + 1); i++) {
            stack[i] += val;            // Add val to the element
        }
    }
}
/**
 * Example usage:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k, val);
 */
