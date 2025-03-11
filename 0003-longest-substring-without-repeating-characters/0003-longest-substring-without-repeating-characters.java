class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        
        // 윈도우의 시작 위치
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            
            // 문자가 이미 존재하고, 현재 윈도우 내에 있으면
            if (charMap.containsKey(c) && charMap.get(c) >= left) {
                // 중복 문자 다음 위치로 left 이동
                left = charMap.get(c) + 1;
            }
            
            // 현재 문자 위치 저장
            charMap.put(c, right);
            
            // 최대 길이 갱신
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
