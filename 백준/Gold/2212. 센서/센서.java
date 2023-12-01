import java.util.*;
import java.io.*;

public class Main {
    static Integer arr[];
    static Integer gap[];
    static int sum = 0;
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //입력
      int N = Integer.parseInt(br.readLine());
      int K = Integer.parseInt(br.readLine());
      arr = new Integer[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
          arr[i] = Integer.parseInt(st.nextToken());
      }
      
      if(K > N) {
         System.out.println(0);
          return;
      }
      // 센서 배열 오름차순
      Arrays.sort(arr);
      
      // 센서 사이 거리 차이 배열에 저장
      gap = new Integer[N - 1];
      for (int i = 0; i < N - 1; i++) {
          gap[i] = arr[i + 1] - arr[i];
      }
        
      // 센서 사이 거리 차이 배열 내림차순
      Arrays.sort(gap , Collections.reverseOrder());
      
      for(int i = K-1; i < N-1; i++) {
          sum += gap[i];
      }
        
      System.out.println(sum);
    }
}