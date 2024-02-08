import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
		int[] score = new int[N+1];
        int[] dp = new int[N+1];
        
		for(int i=1; i < N+1; i++) {
			score[i]  = sc.nextInt();
		}
        
		if(N == 1) {
			dp[1] = score[1];
		}else if(N == 2) {
			dp[2] = score[2] + score[1];
		}else {
			dp[1] = score[1];
			dp[2] = score[2] + score[1];
			dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);
			
			for(int i = 4; i < N+1; i++) {
				// 1. 두 계단 + 한 계단 오른 경우 
				// 2. 한 번에 두 계단 오른 경우 
				dp[i] = Math.max(dp[i-3] + score[i] + score[i-1], dp[i-2] + score[i]);
			}
		}
		System.out.println(dp[N]);
	}
}