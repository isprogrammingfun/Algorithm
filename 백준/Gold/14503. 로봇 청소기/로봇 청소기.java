import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int X, Y, D;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (arr[X][Y] == 0) {
                arr[X][Y] = 2;
                cnt++;
            }

            boolean isCleaned = true;
            for (int i = 0; i < 4; i++) {
                int nx = X + dx[(D + 3 - i) % 4];
                int ny = Y + dy[(D + 3 - i) % 4];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 0) {
                        X = nx;
                        Y = ny;
                        D = (D + 3 - i) % 4;
                        isCleaned = false;
                        break;
                    }
                }
            }

            if (isCleaned) {
                int backX = X + dx[(D + 2) % 4];
                int backY = Y + dy[(D + 2) % 4];
                if (arr[backX][backY] == 1)
                    break;
                else {
                    X = backX;
                    Y = backY;
                }
            }
        }

        System.out.println(cnt);
    }
}
