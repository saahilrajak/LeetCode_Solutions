import java.util.Arrays;
import java.util.Hashtable;

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        Hashtable<Integer, Integer> skillCount = new Hashtable<>();
        long sum = skill[0] + skill[skill.length - 1];
        long totalProduct = 0;

        for (int s : skill) {
            skillCount.put(s, skillCount.getOrDefault(s, 0) + 1);
        }

        int left = 0;
        int right = skill.length - 1;

        while (left < right) {
            int leftSkill = skill[left];
            int rightSkill = skill[right];

            if (leftSkill + rightSkill != sum) {
                return -1;
            }

            if (skillCount.get(leftSkill) == 0 || skillCount.get(rightSkill) == 0) {
                return -1;
            }

            totalProduct += (long) leftSkill * rightSkill;

            skillCount.put(leftSkill, skillCount.get(leftSkill) - 1);
            skillCount.put(rightSkill, skillCount.get(rightSkill) - 1);

            left++;
            right--;
        }

        return totalProduct;
    }
}
