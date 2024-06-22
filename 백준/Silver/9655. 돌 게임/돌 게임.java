import java.util.*;

public class Main {
    static boolean isSK = true;
    static int dp[];
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        
        dp = new int[N+1];
        
        dp[0] = 1;
        dp[1] = 1;
        playGame(N);
        
        if(dp[N] % 2 != 0)
            System.out.println("SK");
        else
            System.out.println("CY");
    }
    
    public static void playGame(int N) {
        for(int i = 2; i < N + 1; i++) {
            dp[i] = dp[i-1] + dp[1];
        }
    }
}