import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 }; 
    static int[] dy = { 0, 0, -1, 1 }; 
    static List<Integer> result;
    static int cnt,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N][N];
        visited = new boolean[N][N];
        cnt = 1;
        result = new LinkedList<>();
        
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    dfs(i,j);
                    result.add(cnt);
					cnt = 1;
                }
            }
        }
        
        Collections.sort(result);
        
        System.out.println(result.size());
        for(int r : result) {
            System.out.println(r);
        }
    }
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
		   int nx = dx[i]+x;
		   int ny = dy[i]+y;
 
           if (nx < 0 || ny < 0 || nx >= N || ny >= N)
               continue;
           if (visited[nx][ny] || arr[nx][ny] == 0)
               continue;
           cnt++;
           dfs(nx,ny);
        }
    }
}
