import java.util.*;
import java.io.*;

public class Main {
    static int n,k;
    static int visited[] = new int[100001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);
    }
    
    public static void bfs(int n) {
       Queue<Integer> q = new LinkedList<Integer>();
       q.offer(n);
       visited[n] = 1;
       
       Operation[] operations = {
                new AddOperation(),
                new SubtractOperation(),
                new MultiplyOperation()
        };
        
       while(!q.isEmpty()) {
          int v = q.poll();
          if(v == k) {
              System.out.println(visited[v] - 1);
          }
          for(int i = 0; i < operations.length; i++) {
              int rslt = operations[i].performOperation(v);
              if(rslt < 0 || rslt > 100000)
                  continue;
              if(visited[rslt] != 0)
                  continue;
              visited[rslt] = visited[v] + 1;
              q.offer(rslt);
          }
       }
        
    }
    
    
    interface Operation {
        int performOperation(int a);
    }
    
    static class AddOperation implements Operation {
        @Override
        public int performOperation(int a) {
            return a + 1;
        }
    }

    static class SubtractOperation implements Operation {
        @Override
        public int performOperation(int a) {
            return a - 1;
        }
    }

    static class MultiplyOperation implements Operation {
        @Override
        public int performOperation(int a) {
            return a * 2;
        }
    }
}