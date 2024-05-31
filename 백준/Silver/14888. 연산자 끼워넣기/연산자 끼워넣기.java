import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    static int[] symbol = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];  // nums 배열을 크기 N으로 초기화
        for(int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        
        for(int i = 0; i < 4; i++) {
            symbol[i] = sc.nextInt();
        }
        
        //dfs (전체 탐색)
        dfs(nums[0], 1);
        
        System.out.println(max);
        System.out.println(min);
    }
    
    public static void dfs(int n, int idx) {
        if(idx == N) {
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            if(symbol[i] > 0) {
                symbol[i]--;
                switch(i) {
                    case 0 : dfs(n + nums[idx], idx + 1); break;
                    case 1 : dfs(n - nums[idx], idx + 1); break;
                    case 2 : dfs(n * nums[idx], idx + 1); break;
                    case 3 : dfs(n / nums[idx], idx + 1); break;
                      
                }
                symbol[i]++;
            }
        }
    }
}
