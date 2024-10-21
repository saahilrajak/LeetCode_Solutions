class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, new HashSet<>(), 0);
    }

    private int backtrack(String s, Set<String> uniqStr, int start) {
        if (start == s.length()) {
            return 0;
        }

        int maxSplits = 0;

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (!uniqStr.contains(substring)) {
                uniqStr.add(substring);
                maxSplits = Math.max(maxSplits, 1 + backtrack(s, uniqStr, end));
                uniqStr.remove(substring);
            }
        }
        return maxSplits;
    }
}