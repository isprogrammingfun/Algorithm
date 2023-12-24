import java.util.*;
import java.io.*;

class Solution {
    static int answer = 0; 
    static int idx = 0;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        if(Arrays.asList(words).contains(target))
            bfs(begin, target, words);
        
        return answer;
    }
    
    public static void bfs(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            Word w = q.poll();
            for(int i = 0; i < words.length; i++) {
                String str = w.str;
                int cnt = w.cnt;
                
                if(str.equals(target)){
                    answer = cnt;
                    return;
                }
                
                if(!checkChar(str, words[i]) || visited[i] == true)
                    continue;
                
                q.add(new Word(words[i], cnt+1));
                visited[i] = true; 
            }
            
        }
        
    }
    
    public static class Word {
        String str;
        int cnt;
        
        public Word(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
    
    public static boolean checkChar(String s1, String s2) {
        int diffCount = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;

                if (diffCount > 1) {
                    return false;
                }
            }
        }
            return diffCount == 1;
    }
}