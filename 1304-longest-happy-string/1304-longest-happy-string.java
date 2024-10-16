import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Create a max heap where the element with the highest frequency is on top
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        
        // Add the characters with their frequencies
        if (a > 0) pq.add(new int[]{'a', a});
        if (b > 0) pq.add(new int[]{'b', b});
        if (c > 0) pq.add(new int[]{'c', c});
        
        StringBuilder result = new StringBuilder();
        
        while (!pq.isEmpty()) {
            int[] first = pq.poll(); // Character with the highest frequency
            
            // If the last two characters in the result are the same as the current character, choose the second most frequent character
            if (result.length() >= 2 && result.charAt(result.length() - 1) == first[0] && result.charAt(result.length() - 2) == first[0]) {
                if (pq.isEmpty()) break; // No valid character left to add
                
                int[] second = pq.poll(); // Choose the second most frequent character
                result.append((char) second[0]); // Add second character to result
                second[1]--; // Decrease its frequency
                
                if (second[1] > 0) pq.add(second); // Add second back if it has remaining frequency
                
                pq.add(first); // Add first back to the heap for the next iteration
            } else {
                result.append((char) first[0]); // Add first character to result
                first[1]--; // Decrease its frequency
                
                if (first[1] > 0) pq.add(first); // Add first back if it has remaining frequency
            }
        }
        return result.toString();
    }
}
