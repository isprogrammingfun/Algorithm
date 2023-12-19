import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int answer = 0;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && i != j) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int x) {
        visited[x] = true;
        for (int i = 0; i < graph[x].size(); i++) {
            int next = graph[x].get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
