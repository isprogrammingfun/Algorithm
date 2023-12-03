import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 최대로 인원을 수용하려면, 가장 첫째 자리는 고정이다
        // 따라서 해당 자리를 제외하고 -> (H - 1), (W - 1)
        // N,M칸 띄우고 자리에 앉는 값을 구해 나누고 -> (N + 1), (M + 1)
        // 해당 값에 고정 자리를 더해주면 된다 -> + 1
        int height = (H - 1) / (N + 1) + 1;
        int width = (W - 1) / (M + 1) + 1;

        System.out.println(height * width);
    }
}