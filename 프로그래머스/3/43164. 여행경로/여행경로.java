import java.util.*;

class Solution {
    public Queue<String> pq = new PriorityQueue<>();
    public boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", "ICN", 0);
        String[] answer = pq.peek().split(",");
        return answer;
    }
    
    public void dfs(String[][] tickets, String currentCity, String path, int cnt){
        if(cnt == tickets.length){
            pq.add(path);
            return;
        }
        for(int i=0;i < tickets.length;i++){
            if(!visited[i] && currentCity.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets, tickets[i][1], path +","+ tickets[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}