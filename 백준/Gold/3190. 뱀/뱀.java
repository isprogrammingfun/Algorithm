import java.util.*;

public class Main {

    static int[][] map;
    static List<int[]> snake = new ArrayList<>();
    static int N, K, L;
    static HashMap<Integer, String> hash = new HashMap<>();
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 }; 
    static int time = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        
        K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            map[x][y] = 1;
        }

        L = sc.nextInt();
        for (int i = 0; i < L; i++) {
            int sec = sc.nextInt();
            String direction = sc.next();
            hash.put(sec, direction);
        }

        move();
    }

    public static void move() {
        int cx = 0, cy = 0;
        int d = 0;
        snake.add(new int[] { 0, 0 });

        while (true) {
            time++;

            int nx = cx + dx[d];
            int ny = cy + dy[d];

            // 벽에 부딪히는 경우
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                break;
            }

            // 자기 자신에게 부딪히는 경우
            for (int[] part : snake) {
                if (part[0] == nx && part[1] == ny) {
                    System.out.println(time);
                    return;
                }
            }

            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snake.add(new int[] { nx, ny });
            } else {
                snake.add(new int[] { nx, ny });
                snake.remove(0);
            }

            if (hash.containsKey(time)) {
                if (hash.get(time).equals("D")) {
                    d = (d + 1) % 4;
                } else {
                    d = (d + 3) % 4; 
                }
            }

            cx = nx;
            cy = ny;
        }

        System.out.println(time);
    }
}
