import java.util.*;
import java.io.*;

public class Main {
    static char[] alpha = new char[27];
    static int rslt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        for(int i = 0; i < str.length(); i++) 
            alpha[str.charAt(i) - 'a']++; // 알파벳 별 개수
        
        dfs(0, "", str.length());
        
        System.out.println(rslt);
    }
    
    private static void dfs(int index, String tmp, int length) {
        // 탐색이 다 끝난 경우 (행운의 문자열)
        if(index == length){
            rslt++;
            return;
        }
 		for(int i = 0; i < 26; i++) {       
            // 문자열에 해당 알파벳이 없는 경우 
            if(alpha[i] == 0)
		        continue;
        
            // 바로 앞에 있던 문자와 같은 문자일 경우 
            if(tmp != "" && tmp.charAt(tmp.length()-1) == (char)('a' + i))
                continue;
            alpha[i]--;
            dfs(index + 1, tmp + (char)('a' + i), length);
            alpha[i]++; // 다음 탐색을 위해 복구
        }
            
    }
}