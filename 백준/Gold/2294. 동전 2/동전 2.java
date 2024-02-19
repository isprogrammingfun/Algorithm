import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr=new int[n+1];

        for(int i = 1;i <= n; i++)
        {
            arr[i]=Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[m+1];

        for(int i = 1; i <= m; i++){
            dp[i] = Integer.MAX_VALUE-1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = arr[i]; j <= m; j++){
                dp[j]=Math.min(dp[j], dp[j-arr[i]]+1);
            }
        }

        if(dp[m] == Integer.MAX_VALUE-1)
            System.out.println(-1);
        else
            System.out.println(dp[m]);
    }

}