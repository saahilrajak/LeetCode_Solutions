
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternMatched = new HashMap<>();
        Set<String> set = new HashSet<>();

        String[] arr = s.split(" ");
        int n = arr.length;

        if (n != pattern.length()) return false;
        
        for (int i = 0; i < n; i++) {
            String word = arr[i];
            char ch = pattern.charAt(i);

            if (patternMatched.containsKey(ch)) {
                if (!patternMatched.get(ch).equals(word)) return false;
            } else {
                if (set.contains(word)) return false;

                patternMatched.put(ch, word);
                set.add(word);
            }
        }
        return true;
    }
}
