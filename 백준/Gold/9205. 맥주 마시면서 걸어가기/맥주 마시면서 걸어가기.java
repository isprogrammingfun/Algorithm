import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int t = Integer.parseInt(br.readLine());
 
        ArrayList<Point> place;
        ArrayList<ArrayList<Integer>> graph;
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
 
            place = new ArrayList<>();
            
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
 
                place.add(new Point(x, y));
            }
 
            graph = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());
            }
            
            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (Manhattan(place.get(i), place.get(j)) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }
            
            bfs(graph, n);
        }
    }
    
    public static int Manhattan(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    
    public static void bfs(ArrayList<ArrayList<Integer>> graph, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
 
        boolean[] visited = new boolean[n + 2];
        visited[0] = true;
 
        while (!q.isEmpty()) {
            int now = q.poll();
 
            if (now == n + 1) {
                System.out.println("happy");
                return;
            }
 
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
 
        System.out.println("sad");
        return;
    }
 
    static class Point {
    int x;
    int y;
 
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
}
