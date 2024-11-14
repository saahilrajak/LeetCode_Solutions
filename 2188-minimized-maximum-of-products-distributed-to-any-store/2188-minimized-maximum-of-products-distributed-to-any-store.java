class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = Arrays.stream(quantities).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            if (canDistribute(mid, n, quantities)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canDistribute(int maxPerStore, int n, int[] quantities) {
        int storesNeeded = 0;
        for (int quantity : quantities) {
            storesNeeded += (quantity + maxPerStore - 1) / maxPerStore;
            if (storesNeeded > n) return false;
        }
        return true;
    }
}
