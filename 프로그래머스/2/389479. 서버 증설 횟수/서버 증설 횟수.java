import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] activeServers = new int[players.length]; // 각 시간별 운영 중인 서버 수
        
        for (int i = 0; i < players.length; i++) {
            int requiredServers = players[i] / m;
            
            if (requiredServers > activeServers[i]) {
                int additionalServers = requiredServers - activeServers[i];
                answer += additionalServers; // 증설 횟수 증가
                
                // 추가된 서버는 현재 시간부터 k시간 동안 운영
                for (int j = i; j < Math.min(i + k, players.length); j++) {
                    activeServers[j] += additionalServers;
                }
            }
        }
        
        return answer;
    }
}