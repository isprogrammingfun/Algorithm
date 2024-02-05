import java.io.*;
import java.util.*;

public class Main {
	
	static int max = 0;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] Time = new int[N]; //소요 기간
		int[] Price = new int[N];//금액
		for(int i = 0; i < N; i++) {
			Time[i]=sc.nextInt();	
			Price[i]=sc.nextInt();	
		}
		
		int[] dp = new int[N+1];
		
		for(int i = 0; i < N; i++) {
			 if(i + Time[i]<= N) {	
				 dp[i + Time[i]] = Math.max(dp[i + Time[i]], dp[i] + Price[i]);	
			 }
			 dp[i + 1] = Math.max(dp[i+1], dp[i]);
			 
		}
        
		System.out.println(dp[N]);	
	}
	
}