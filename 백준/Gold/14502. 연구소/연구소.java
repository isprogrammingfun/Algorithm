import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static int[][] virus;
    static int n, m;
    static int max = Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);
        
        System.out.println(max);
    }
    
    public static void dfs(int wall) {
        //벽 다 만들면 탐색
        if(wall == 3){
            bfs();
            return;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    
    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        virus = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                virus[i][j] = map[i][j];
                if(virus[i][j] == 2)
                    q.add(new Point(i,j));
            }
        }
        
        while (!q.isEmpty()) {
            Point p = q.poll();
        for(int i = 0; i < 4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && virus[nx][ny] == 0) {
                virus[nx][ny] = 2;
                q.add(new Point(nx,ny));
            }
            }
       }
            
        int count = 0;
        for (int i = 0; i < n; i++) {
             for (int j = 0; j < m; j++) {
                 if (virus[i][j] == 0) 
                     count++;
            }
       }
        max = Math.max(max, count);
    }
    
    public static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}