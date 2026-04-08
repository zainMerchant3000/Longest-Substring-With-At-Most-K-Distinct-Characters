class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n < k + 1) return n;

        int left = 0;
        int right = 0;
        HashMap<Character, Integer> hashmap = new HashMap<>();

        int max_len = k;

        while (right < n) {
            // add character and its rightmost index to window
            hashmap.put(s.charAt(right), right++);

            // window has too many distinct characters
            if (hashmap.size() == k + 1) {
                // find and evict the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                left = del_idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }

        return max_len;
        
    }
}
