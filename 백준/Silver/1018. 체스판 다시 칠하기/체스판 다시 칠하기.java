import java.io.*;
import java.util.*;

public class Main {
    public static char[][] arr;
    public static int min = 64;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new char[N][M];
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        
        for(int i = 0; i < N-7; i++) {
            for(int j = 0; j < M-7; j++) {
                find(i,j,arr);
            }
        }
        System.out.println(min);
    }
    
    public static void find(int x, int y, char[][] arr) {
        int cnt = 0;
        char TC = arr[x][y];
        
        for(int i = x; i < x + 8; i++) {
            for(int j = y; j < y + 8; j++) {
                
                if(arr[i][j] != TC) {
                    cnt++;
                }
                
                TC = changeColor(TC);
                
            }
              TC = changeColor(TC);
        }
        
        cnt = Math.min(cnt, 64 - cnt);
        min = Math.min(min, cnt);
    }
    
    public static char changeColor(char TC){
        if(TC == 'W')
            return 'B';
        else 
            return 'W';
    }
    
}