import java.io.*;
import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[][] visited;
    static int dx[] = {1, -1, 0 ,0};
    static int dy[] = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        bfs(0,0,maps);
        return answer;
    }
    
    public static void bfs(int x, int y, int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) 
                    continue;
                if(maps[nx][ny] == 0 || visited[nx][ny] == true)
                    continue;
                
                q.add(new Point(nx,ny));
                visited[nx][ny] = true;
                maps[nx][ny] = maps[p.x][p.y] + 1;
            }
        }
        
        if(!visited[maps.length - 1][maps[0].length -1])
            answer = -1;
        else
            answer = maps[maps.length - 1][maps[0].length -1];
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