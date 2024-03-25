import java.io.*;
import java.util.*;

public class Main {
  
    static int[][] distances; 
	static final int INF = 999999999;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        distances = new int[N+1][N+1]; 
        
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                distances[i][j] = INF;
                if(i == j) distances[i][j] = 0; 
            }
        }
        
        //입력 받기
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            distances[x][y] = 1;
            distances[y][x] = 1;
        }
        
		for(int i=1; i<=N; i++) { //중간지점
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					distances[j][k] = Math.min(distances[j][k], 
                                               distances[j][i]+distances[i][k]);
				}
			}
        }
        
		int total = INF;
		int maxIndex = 0;
		for(int i=1;i<=N;i++) {
			int sum = 0;
			for(int j=1;j<=N;j++) {
				sum += distances[i][j];
			}
			
			if(total > sum) { 
				total = sum;
				maxIndex = i;
			}	
		}
        
        System.out.println(maxIndex);
    }
}
