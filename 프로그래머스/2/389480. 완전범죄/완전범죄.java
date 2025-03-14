import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1000000;
        int answer = 0;
        int size = info.length;
        // i 물건까지 훔쳤을 때 B가 j까지의 흔적이 남았을 때 A의 흔적
        int dp[][] = new int[size+1][m];
        for(int i = 0; i <= size; i++){
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        
        for(int i = 1; i <= size; i++) {
            int a = info[i-1][0];
            int b = info[i-1][1];
            for(int j = 0; j < m; j++) {
                // A가 훔치는 경우
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                // B가 훔치는 경우
                if(b + j < m)
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i-1][j]);
            }
        }
        
        int min = INF;
        for(int j = 0; j < m; j++) {
            min = Math.min(dp[size][j], min);
        }
        answer = min >= n ? -1 : min;
        return answer;
    }
}