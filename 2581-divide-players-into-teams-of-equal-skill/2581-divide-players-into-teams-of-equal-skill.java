import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill); 

        long sum = skill[0] + skill[skill.length - 1]; // Target sum for each pair
        long totalProduct = 0; // To store the product sum of pairs
        
        int left = 0;
        int right = skill.length - 1;

        while (left < right) {
            // Check if current pair matches the target sum
            if (skill[left] + skill[right] != sum) {
                return -1; // If the sum doesn't match, return -1
            }
            totalProduct += (long) skill[left] * skill[right]; // Add the product of the pair to the total
            left++;
            right--;
        }
        return totalProduct;
    }
}
