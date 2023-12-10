import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int cnt = 0;
    static int rslt = -1;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
	    for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        
        int M = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
			graph[s].add(e);
			graph[e].add(s);
        }
        
        dfs(X,Y,cnt);
        System.out.println(rslt);
    }
    
    public static void dfs(int x, int y, int cnt) {
        if(x == y) {
            rslt = cnt;
            return;
        }
        
        visited[x] = true;
        
		for(int i = 0; i < graph[x].size(); i++) { 
			int next = graph[x].get(i);
			if(!visited[next]) {
				dfs(next, y, cnt+1);
			}
		}
    }
}