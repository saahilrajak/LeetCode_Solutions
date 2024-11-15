class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int j = n - 1;
        while (j > 0 && arr[j - 1] <= arr[j]) {
            j--;
        }
        
        // If the entire array is already non-decreasing, return 0
        if (j == 0) return 0;
        
        int result = j;
        int i = 0;
        while (i < n && (i == 0 || arr[i] >= arr[i - 1])) {
            while (j < n && arr[i] > arr[j]) {
                j++;
            }
            result = Math.min(result, j - i - 1);
            i++;
        }
        return result;
    }
}
