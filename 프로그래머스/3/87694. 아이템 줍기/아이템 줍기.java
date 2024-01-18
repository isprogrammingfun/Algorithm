import java.io.*;
import java.util.*;

class Solution {
    public static int answer = 0;
    static int dx[] = {0 ,0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    public static int[][] arr;
    public static boolean[][] visited;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        arr = new int[101][101];
        visited = new boolean[101][101];
        
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];

            draw(y1 * 2, x1 * 2, y2 * 2, x2 * 2);
        }
        
        answer = bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2);
        return answer;
    }
    
    public int bfs(int cY, int cX, int iY, int iX) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(cY, cX, 0));
        visited[cY][cX] = true;
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            if(p.x == iX && p.y == iY)
                return p.cnt / 2;
            
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
              if(ny < 0 || nx < 0 || ny >= arr.length || nx >= arr[0].length)
                    continue;
              if(visited[ny][nx] == true || arr[ny][nx] != 2)
                    continue;
                
              visited[ny][nx] = true;
              q.add(new Point(ny, nx, p.cnt + 1));
            }
            
        }
        return -1;
    }
    
    
    public static class Point {
        int y;
        int x;
        int cnt;
        
        public Point(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    
    public static void draw(int y1,int x1,int y2,int x2){
        
        for(int i = y1;i <= y2;i++) {
            for(int j = x1;j <= x2;j++) {
            	if(arr[i][j] == 1) continue;
                arr[i][j] = 1;
                if(i == y1 || i == y2 || j == x1 || j == x2)
                    arr[i][j]=2;
            }
        }
        
    }
}