import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to maintain the class with the maximum gain at the top
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Initialize the heap with each class and their initial gain
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = gain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }

        // Distribute the extra students
        for (int i = 0; i < extraStudents; i++) {
            // Get the class with the maximum gain
            double[] current = maxHeap.poll();
            double gain = current[0];
            int pass = (int) current[1];
            int total = (int) current[2];

            // Add one student to this class
            pass++;
            total++;

            // Recalculate the gain and push it back into the heap
            maxHeap.offer(new double[]{gain(pass, total), pass, total});
        }

        // Calculate the final average pass ratio
        double totalAverage = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            int pass = (int) current[1];
            int total = (int) current[2];
            totalAverage += (double) pass / total;
        }

        return totalAverage / classes.length;
    }

    // Helper function to calculate the gain of adding one student
    private double gain(int pass, int total) {
        double currentRatio = (double) pass / total;
        double newRatio = (double) (pass + 1) / (total + 1);
        return newRatio - currentRatio;
    }
}
