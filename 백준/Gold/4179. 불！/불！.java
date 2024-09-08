import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static int N;
    static int M;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new char[N][M];
       
        for (int i = 0; i < N; i++) {
            String line = br.readLine();  // 한 줄을 읽어들임
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);  // 각 문자를 배열에 저장
            }
        }
        
        bfs();        
    }
    
    private static void bfs() {
        Queue<Point> jihoon = new LinkedList<>();
        Queue<Point> fire = new LinkedList<>();
        boolean[][] jihoonVisited = new boolean[N][M]; // 방문 여부 체크용 배열 추가
        boolean[][] fireVisited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'J') {
                    jihoon.offer(new Point(i, j));
                    jihoonVisited[i][j] = true;
                } else if (arr[i][j] == 'F') {
                    fire.offer(new Point(i, j));
                    fireVisited[i][j] = true;
                }
            }
        }
        
        int time = 0;
        while (true) {
            time++;
            
            // 불을 먼저 확산시킴
            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                Point p = fire.poll();
                int x = p.x;
                int y = p.y;
                
                for (int idx = 0; idx < 4; idx++) {
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];
                    
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (arr[nx][ny] == '.' && !fireVisited[nx][ny]) {
                        arr[nx][ny] = 'F';
                        fire.offer(new Point(nx, ny));
                        fireVisited[nx][ny] = true;
                    }
                }
            }
            
            // 지훈 이동
            int jihoonSize = jihoon.size();
            for (int i = 0; i < jihoonSize; i++) {
                Point p = jihoon.poll();
                int x = p.x;
                int y = p.y;
                
                for (int idx = 0; idx < 4; idx++) {
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];
                    
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {  // 탈출 가능
                        System.out.println(time);
                        return;
                    }
                    if (arr[nx][ny] == '.' && !jihoonVisited[nx][ny]) {
                        arr[nx][ny] = 'J';
                        jihoon.offer(new Point(nx, ny));
                        jihoonVisited[nx][ny] = true;
                    }
                }
            }
            
            if (jihoon.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
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
