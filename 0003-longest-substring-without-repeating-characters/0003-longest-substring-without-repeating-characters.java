class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                boolean hasDuplicate = false;
                
                HashSet<Character> charSet = new HashSet<>();
                for (char c : str.toCharArray()) {
                    if (!charSet.add(c)) {
                        hasDuplicate = true;
                        break;
                    }
                }
                
                if (!hasDuplicate) {
                    answer = Math.max(answer, str.length());
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}