class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) // A mountain array must have at least 3 elements
        return false; 
        int i = 0;
        while (i + 1 < arr.length && arr[i] < arr[i + 1]) { // Climb up: Find the peak
            i++;
        }
        if (i == 0 || i == arr.length - 1) // Peak cannot be the first or the last element
         return false;
        // Climb down: Make sure all elements after the peak are strictly decreasing
        while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == arr.length - 1; // If we've reached the end of the array, it's a valid mountain array
    }
}
