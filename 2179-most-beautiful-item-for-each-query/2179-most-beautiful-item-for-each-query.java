import java.util.Arrays;

class Solution {

    private int binarySearch(int[][] items, int queriesPrice) {
        int low = 0;
        int high = items.length - 1;
        int maxBeauty = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (items[mid][0] > queriesPrice) {
                high = mid - 1;
            } else {
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                low = mid + 1;
            }
        }
        return maxBeauty;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int q = queries.length;
        int[] result = new int[q];

        // Sort items based on price
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        int maxBeauty = items[0][1];
        for (int i = 1; i < n; i++) {
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            items[i][1] = maxBeauty;
        }

        for (int i = 0; i < q; i++) { // here we are processing all queries
            int queriesPrice = queries[i];
            result[i] = binarySearch(items, queriesPrice);
        }

        return result;
    }
}
