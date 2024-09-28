class MyCircularDeque {

    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        // Initialize the deque with size k + 1 to differentiate between full and empty states
        deque = new int[k + 1];
        capacity = k + 1; // Effective capacity (since we leave one slot empty to differentiate)
        front = 0;
        rear = 0;
        size = 0;
    }

    // Insert an element at the front of the deque. Returns true if the operation is successful.
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity; // Move front pointer backward circularly
        deque[front] = value;
        size++;
        return true;
    }

    // Insert an element at the rear of the deque. Returns true if the operation is successful.
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        deque[rear] = value;
        rear = (rear + 1) % capacity; // Move rear pointer forward circularly
        size++;
        return true;
    }

    // Delete an element from the front of the deque. Returns true if the operation is successful.
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity; // Move front pointer forward circularly
        size--;
        return true;
    }

    // Delete an element from the rear of the deque. Returns true if the operation is successful.
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity; // Move rear pointer backward circularly
        size--;
        return true;
    }

    // Get the front element. Returns -1 if the deque is empty.
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }

    // Get the last element. Returns -1 if the deque is empty.
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[(rear - 1 + capacity) % capacity]; // Return the element just before the rear pointer
    }

    // Check if the deque is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the deque is full.
    public boolean isFull() {
        return size == capacity - 1;
    }
}
