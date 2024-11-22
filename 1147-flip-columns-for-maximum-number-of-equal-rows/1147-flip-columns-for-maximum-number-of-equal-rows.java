class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
            Map<String, Integer> countMap = new HashMap<>();
        
        for (int[] row : matrix) {
            StringBuilder normal = new StringBuilder();
            StringBuilder flipped = new StringBuilder();
            
            // Generate normal and flipped forms
            for (int cell : row) {
                normal.append(cell);
                flipped.append(1 - cell);
            }
            
            // Use the smaller of the two as the canonical form
            String canonical = normal.toString().compareTo(flipped.toString()) < 0
                    ? normal.toString() : flipped.toString();
            
            countMap.put(canonical, countMap.getOrDefault(canonical, 0) + 1);
        }
        
        // Find the maximum frequency
        int maxRows = 0;
        for (int count : countMap.values()) {
            maxRows = Math.max(maxRows, count);
        }
        
        return maxRows;
    }
}