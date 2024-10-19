class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int len = (1 << n) - 1; // Length of the sequence is 2^n - 1
        int mid = (int) Math.ceil(len / 2.0); // Handle floating point division
        if (k < mid) {
            return findKthBit(n - 1, k);
        }
        else if (k == mid) {
            return '1';
        }
        else {
            char ch = findKthBit(n - 1, len - k + 1);  // Reverse the position
            return (ch == '0') ? '1' : '0';  // Flip the bit
        }
    }
}
