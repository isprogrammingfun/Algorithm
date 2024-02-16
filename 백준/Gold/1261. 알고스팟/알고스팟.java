import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, -1, 0, 0}; 
    static int[] dy = {0, 0, 1, -1}; 
    static boolean[][] isEmpty, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        isEmpty = new boolean[n][m];

        // 공백 없는 문자열을 한 글자씩 분리하여 배열에 넣기. 공백이 없으므로 StringTokenizer 사용 불가
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (input[j] == '0') {
                    isEmpty[i][j] = true;
                }
            }
        }

        int answer = bfs(isEmpty, n, m);
        System.out.println(answer);
    }

    public static int bfs(boolean[][] isEmpty, int n, int m) {
        visited = new boolean[n][m];
        visited[0][0] = true;
        Deque<Point> deque = new ArrayDeque<Point>();
        deque.offer(new Point(0,0,0)); 
        while (!deque.isEmpty()) {
            Point tmp = deque.poll();
            int x = tmp.x;
            int y = tmp.y;
            int cnt = tmp.cnt;

            if (x == n - 1 && y == m - 1) { 
                return cnt;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (isEmpty[nx][ny]) { 
                        deque.addFirst(new Point(nx, ny, cnt));
                    } else {
                        deque.addLast(new Point(nx, ny, cnt + 1));
                    }
                }
            }
        }

        return -1;
    }

    public static class Point {
        private int x;
        private int y;
        private int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}    
        