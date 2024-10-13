import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Min heap to store the smallest elements from the lists
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        
        int max = Integer.MIN_VALUE;  // Track the maximum value in the current range
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;  // Initialize the range
        
        // Add the first element of each list to the heap
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.offer(new Element(value, i, 0));
            max = Math.max(max, value);  // Track the largest element
        }
        
        // Continue the process until we cannot get more elements from one of the lists
        while (minHeap.size() == nums.size()) {
            Element minElement = minHeap.poll();  // Get the smallest element
            
            int currentRangeStart = minElement.value;
            int currentRangeEnd = max;
            
            // Update the smallest range
            if (currentRangeEnd - currentRangeStart < rangeEnd - rangeStart) {
                rangeStart = currentRangeStart;
                rangeEnd = currentRangeEnd;
            }
            
            // If there are more elements in the current list, add the next element
            if (minElement.indexInList + 1 < nums.get(minElement.listIndex).size()) {
                int nextValue = nums.get(minElement.listIndex).get(minElement.indexInList + 1);
                minHeap.offer(new Element(nextValue, minElement.listIndex, minElement.indexInList + 1));
                max = Math.max(max, nextValue);  // Update max value
            }
        }
        
        return new int[] { rangeStart, rangeEnd };
    }
    
    // Helper class to store elements in the heap
    class Element {
        int value;
        int listIndex;  // The index of the list the element is from
        int indexInList;  // The index of the element in its list
        
        public Element(int value, int listIndex, int indexInList) {
            this.value = value;
            this.listIndex = listIndex;
            this.indexInList = indexInList;
        }
    }
}
