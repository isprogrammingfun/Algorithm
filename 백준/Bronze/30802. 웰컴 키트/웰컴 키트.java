import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String sizeInfo = br.readLine();
        int[] sizes = Arrays.stream(sizeInfo.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        int shirt = 0;
        for (int size : sizes) {
            shirt += (size + T - 1) / T;
        }
                
        int penBundle = N / P;
        int pen = N % P;
        
        System.out.println(shirt);
        System.out.println(penBundle + " " + pen);
         
    }
}