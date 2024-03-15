import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[41];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i = 0; i < T; i++) {
            int n = sc.nextInt();
            if(n == 0)
                System.out.println("1 0");
            else if(n == 1) 
                System.out.println("0 1");
            else {
                fibonacci(n);
                System.out.println(dp[n-1]+" "+dp[n]);
            }
        }
    }
    
    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if(dp[n] != 0){
                return dp[n];
            }
            else{
                dp[n] = fibonacci(n-1) + fibonacci(n-2);
                return dp[n];
            }
        }
        
    }
}