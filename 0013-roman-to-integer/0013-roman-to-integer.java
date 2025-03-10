class Solution {
    public int romanToInt(String s) {
	int answer = 0;
	HashMap<Character, Integer> map = new HashMap<>();

	map.put('I', 1);
	map.put('V', 5);
	map.put('X', 10);
	map.put('L', 50);
	map.put('C', 100);
	map.put('D', 500);
   	map.put('M', 1000);

	answer = map.get(s.charAt(s.length() - 1));      
        
        for(int i = s.length() - 2; i >= 0; i--) {
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                answer += map.get(s.charAt(i));
            else
                answer -= map.get(s.charAt(i));
        }

        return answer;
    }
}