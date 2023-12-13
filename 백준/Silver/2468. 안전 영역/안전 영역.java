import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int n, area;
    static int maxHeight = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > maxHeight) maxHeight = arr[i][j]; 
            }
        }

        int max = Integer.MIN_VALUE;
        for(int h = 0; h < maxHeight + 1; h++) {
            visited = new boolean[n][n];
            area = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && arr[i][j] > h){
                       dfs(i,j,h); 
                       area++;
                    }
                }
            }
        max = Math.max(max, area);
    }
      System.out.println(max);  
  }
    static void dfs(int x, int y, int h) {
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            if(visited[nx][ny] || arr[nx][ny] <= h)
                continue;
            
            dfs(nx,ny,h);
        }
           
    }
}