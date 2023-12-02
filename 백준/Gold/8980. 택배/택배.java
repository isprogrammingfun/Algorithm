import java.util.*;
import java.io.*;

public class Main {
    static class Delivery implements Comparable<Delivery> {
        int from, to, cnt;
        public Delivery(int from, int to, int cnt) {
            this.from = from;
            this.to = to;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Delivery o) {
            //받는 마을 기준으로 오름차순, 만약 받는 마을이 같으면 
            //보내는 마을 기준으로 오름차순
            if (this.to == o.to) return this.from - o.from;
            else return this.to - o.to;
        }
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        
        Delivery deliveryInfo[] = new Delivery[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            deliveryInfo[i] = new Delivery(from, to, cnt);
        }
        // 정렬
        Arrays.sort(deliveryInfo);
        
        int box[] = new int[N + 1];
        int max, capacity, total = 0;
        for (int i = 0; i < M; i++) {
            int from = deliveryInfo[i].from;
            int to = deliveryInfo[i].to;
            int cnt = deliveryInfo[i].cnt;
            max = 0;
            // 지나간 구간에서 실린 박스의 최댓값
            for(int j = from; j < to; j++) {
                max = Math.max(max, box[j]);
            }
            // 실을 수 있는 박스 수
            capacity = Math.min(C - max, cnt);
		    total += capacity;
		    for (int j = from; j < to; j++) {
			    box[j] += capacity;
		    }
	    }
	    // 배송할 수 있는 최대 박스 수
	    System.out.println(total + box[N]);
    }
}