import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int rc, gc, bc, oc, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        arr = new char[n][n];
        visited = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String token = st.nextToken();
            for(int j = 0; j < n; j++) {
                arr[i][j] = token.charAt(j);
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 'R' && !visited[i][j]) {
                    dfs(i,j,'R');
                    rc++;
                }
                else if(arr[i][j] == 'G' && !visited[i][j]) {
                    dfs(i,j,'G');
                    gc++;
                }
                
                else if(arr[i][j] == 'B' && !visited[i][j]) {
                    dfs(i,j,'B');
                    bc++;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 'R' || arr[i][j] == 'G') {
                    arr[i][j] = 'O';
                    visited[i][j] = false;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 'O' && !visited[i][j]) {
                    dfs(i,j,'O');
                    oc++;
                }
            }
        }
        
        System.out.println((rc+gc+bc) + " " + (bc+oc));
    }
    
    public static void dfs(int x, int y, char color) {
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            if(visited[nx][ny] || arr[nx][ny] != color)
                continue;
            
            dfs(nx,ny,color);
        }
    }
}