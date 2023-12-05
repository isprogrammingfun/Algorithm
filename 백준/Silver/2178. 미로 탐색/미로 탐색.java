import java.util.*;
import java.io.*;

public class Main {
    static int arr[][];
    static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
    static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우
    static int N,M;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
			    arr[i][j] = s.charAt(j) - '0';
			}
		}
        visited = new boolean[N][M];
		visited[0][0] = true;
		bfs(0, 0);
        System.out.println(arr[N-1][M-1]);
    }
    
    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(x,y));
        
        while(!q.isEmpty()) {
            Point point = q.poll();
            for(int i=0; i<4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
 
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (visited[nx][ny] || arr[nx][ny] == 0)
                    continue;
                q.add(new Point(nx, ny));
                arr[nx][ny] = arr[point.x][point.y] + 1;
                visited[nx][ny] = true;
            }
        }
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