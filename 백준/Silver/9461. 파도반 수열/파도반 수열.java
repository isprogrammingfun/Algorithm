import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            long[] dp = new long[m+2];
            
            dp[1] = 1;
            dp[2] = 1;
            
            for(int j = 3; j < m+2; j++) {
                dp[j] = dp[j-2] + dp[j-3];
            }
            
            System.out.println(dp[m]);
        }
        
    }
}