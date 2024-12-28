import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Integer arraySize = Integer.parseInt(br.readLine());
        
        List<String> words = new ArrayList<>();
        
        for(int i = 0; i < arraySize; i++) {
            words.add(br.readLine());
        }

        words.sort((s1, s2) -> s2.length() - s1.length());
        int result = countPrefix(words);
        System.out.println(result);
        
    }
    
    public static int countPrefix(List<String> words) {
        int cnt = 0;
        
        for(int i = 0; i < words.size(); i++) {
            boolean isPrefix = false;
            String current = words.get(i);
            for(int j = 0; j < i; j++) {
                String prefix = words.get(j);
                if(prefix.startsWith(current)) {
                    isPrefix = true;
                    break;
                }
            }
            
            if(!isPrefix)
                cnt++;
        }
        return cnt;
    }
}