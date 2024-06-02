import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int cnt = 0;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Point> cctv = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num != 0 && num != 6) 
                    cctv.add(new Point(i,j,num));
                map[i][j] = num;
            }
        }
        
        dfs(cnt, map, cctv);
        System.out.println(min);
        
    }
    
    public static void dfs(int cnt, int[][] map, ArrayList<Point> cctv) {
        if(cnt == cctv.size()) {
            min = Math.min(min, getZeros(map));
            return;
        }
        
        Point point = cctv.get(cnt);
        int type = point.type;
        int x = point.x;
        int y = point.y;
        int[][] tmp;
        
        if(type == 1) {
            tmp = copyMap(map);
            checkLeft(tmp, x, y);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkRight(tmp, x, y);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkDown(tmp, x, y);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkUp(tmp, x, y);
            dfs(cnt+1, tmp, cctv);
        }
        
        else if(type == 2) {
            tmp = copyMap(map);
            checkLeft(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkUp(tmp, x, y);
            checkDown(tmp, x, y);
            dfs(cnt+1, tmp, cctv);
        }
        
        else if (type == 3) {
            tmp = copyMap(map);
            checkLeft(tmp, x, y);
            checkUp(tmp, x, y);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkUp(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkDown(tmp, x, y);
            checkLeft(tmp, x, y);
            dfs(cnt+1, tmp, cctv);
        }
        
        else if (type == 4) {
            tmp = copyMap(map);
            checkLeft(tmp, x, y);
            checkUp(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkUp(tmp, x, y);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            checkLeft(tmp ,x , y);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkDown(tmp, x, y);
            checkLeft(tmp ,x , y);
            checkUp(tmp, x, y);
            dfs(cnt+1, tmp, cctv);
        }
        
        else if(type == 5) {
            tmp = copyMap(map);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            checkLeft(tmp ,x , y);
            checkUp(tmp, x, y);
            dfs(cnt+1, tmp, cctv); 
        }

    }
    
        public static void checkLeft(int[][] map, int x, int y) {
        for(int i=y-1; i>=0; i--) {
            if(map[x][i] == 6) return;
            if(map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }

    public static void checkRight(int[][] map, int x, int y) {
        for(int i=y+1; i<M; i++) {
            if(map[x][i] == 6) return;
            if(map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }

    public static void checkUp(int[][] map, int x, int y) {
        for(int i=x-1; i>=0; i--) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    public static void checkDown(int[][] map, int x, int y) {
        for(int i=x+1; i<N; i++) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    public static int getZeros(int[][] map) {
        int zero = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) zero++;
            }
        }
        return zero;
    }

    public static int[][] copyMap(int[][] map) {
        int[][]tmp = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }
    
    public static class Point {
        int x;
        int y;
        int type;
        
        public Point(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}