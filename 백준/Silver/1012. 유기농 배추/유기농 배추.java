import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static int M,N,K;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            arr = new int[M][N];
            visited = new boolean[M][N];

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
                        
            int cnt = 0;
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < N; k++) {
                    if(arr[j][k] == 1 && !visited[j][k]) {
                        bfs(j,k);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
        
    private static void bfs(int x, int y) {
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(x,y));
            visited[x][y] = true;
            
            while(!q.isEmpty()) {
                Point p = q.poll();
                
                for(int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    
                    if(nx < 0 || nx >= M || ny < 0 || ny >= N) 
                        continue;
                    if(visited[nx][ny] || arr[nx][ny] != 1)
                        continue;
                    
                    q.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                }
                
            }
            
        }
        
        static class Point {
            int x;
            int y;
            
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }