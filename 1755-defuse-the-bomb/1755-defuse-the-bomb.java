class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        
        if (k == 0) {
            Arrays.fill(result, 0);
            return result;
        }
        
        // Determine the direction of summation
        int start, end, step;
        if (k > 0) {
            start = 1;
            end = k;
            step = 1;
        } else {
            start = -1;
            end = k;
            step = -1;
        }
        
        // Decrypt each position in the circular array
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = start; j != end + step; j += step) {
                // Use modulo to handle circular array indexing
                sum += code[(i + j + n) % n];
            }
            result[i] = sum;
        }
        
        return result;

    }
}