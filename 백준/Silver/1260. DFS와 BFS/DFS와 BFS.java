import java.util.*;
import java.io.*;

public class Main {
    static int[][] tree;
    static boolean[] visited; 
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        tree = new int[N+1][N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 연결
            tree[x][y] = 1;
            tree[y][x] = 1;
        }
        
        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println();
        
    }

     public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
         
        if(v == tree.length) return;
         
        for(int i = 1; i < tree.length; i++) {
          if(tree[v][i] == 1 && visited[i] == false) {
          dfs(i);
          }
        }
     } 
         
            
     public static void bfs(int v){
       Queue<Integer> queue = new LinkedList<Integer>();
       queue.offer(v);
       visited[v] = true;

       System.out.print(v + " ");

       while(!queue.isEmpty()) {
         int n = queue.poll();
           for(int i = 1; i < tree.length; i++) {
               if(tree[n][i] == 1 && visited[i] == false) {
                   visited[i] = true;
                   System.out.print(i + " ");
                   queue.offer(i);
               }
           }
       }
     }
}