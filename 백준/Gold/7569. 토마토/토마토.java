import java.util.*;
import java.io.*;

public class Main {
    static int[][][] arr;
    static int dx[] = {0, 0, -1, 1, 0, 0};
	static int dy[] = {-1, 1, 0, 0, 0, 0};
	static int dz[] = {0, 0, 0, 0, 1, -1};
    static int n,m,h;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[n][m][h];
        
        for(int k = 0; k < h; k++) {
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        
        bfs();
    }
    
    public static void bfs() {
       Queue<Point> q = new LinkedList<Point>();
       for(int k = 0; k < h; k++) {
           for(int i = 0; i < n; i++)
                for(int j = 0; j < m; j++) {
                    if(arr[i][j][k] == 1) 
                        q.offer(new Point(i, j, k, 0));
            }
        }
        
        while(!q.isEmpty()) {
          Point point = q.poll();
 
          for(int i=0; i < 6; i++) {
             int nx = point.x + dx[i];
             int ny = point.y + dy[i];
             int nz = point.z + dz[i];
 
             if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) 
                 continue;
             if (arr[nx][ny][nz] == 1) continue; 
             if (arr[nx][ny][nz] == -1) continue;
              
             arr[nx][ny][nz] = 1; 
             q.offer(new Point(nx, ny, nz, point.cnt+1));
             cnt = point.cnt+1; 
           }
        }
        
        if(isAllGrown())
            System.out.println(cnt);
        else
            System.out.println(-1);
    }    
    
    
    static boolean isAllGrown() {
      for(int k = 0; k < h; k++) {
          for(int i = 0; i < n; i++) {
              for(int j = 0; j < m; j++) {
                  if(arr[i][j][k] == 0)
                      return false;
              }
           }
      }
       return true;
    }
    
    public static class Point {
        int x;
        int y;
        int z;
        int cnt;
 
        public Point(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }
}