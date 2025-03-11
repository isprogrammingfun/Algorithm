class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        String str = Integer.toString(x);
        int length = str.length();
        char[] ch = str.toCharArray();

        for(int i = 0; i < length/2; i++) {
            if(ch[i] != ch[length - i -1])
                return false;
        }
        return true;
    }
}