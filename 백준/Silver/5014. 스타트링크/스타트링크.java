import java.io.*;
import java.util.*;

public class Main {
    static int f,s,g,u,d;
    static int[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        visited = new int[f + 1];
        bfs(s);
    }
    
    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(n);
        visited[n] = 1;
        
        Operation[] operations = {
              new AddOperation(),
              new SubtractOperation()
        };
        
        while(!q.isEmpty()) {
            int v = q.poll();
            if(v == g) {
                System.out.println(visited[g] - 1);
            }
            for(int i = 0; i < 2; i++) {
                int rslt = operations[i].performOperation(v);
                    if (rslt < 1 || rslt > f)
                        continue;
                    if(visited[rslt] != 0)
                        continue;
                    visited[rslt] = visited[v] + 1;
                    q.offer(rslt);
                }
            }
        
        if(visited[g] == 0) {
            System.out.println("use the stairs");
        }
       
    }
    
    interface Operation {
        int performOperation(int a);
    }
    
    static class AddOperation implements Operation {
        @Override
        public int performOperation(int a) {
            return a + u;
        }
    }

    static class SubtractOperation implements Operation {
        @Override
        public int performOperation(int a) {
            return a - d;
        }
    }
}  