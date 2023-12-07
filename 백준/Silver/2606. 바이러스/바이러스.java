import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[] visited; 
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
            
        for(int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            arr[X][Y] = 1;
            arr[Y][X] = 1;
        }
        
        dfs(1);
        System.out.println(cnt);
    }
    
    public static void dfs(int v) {
        visited[v] = true;
        
        if(v == arr.length) return;
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[v][i] == 1 && visited[i] == false) {
                cnt++;
                dfs(i);
            }
        }
         
    }
}