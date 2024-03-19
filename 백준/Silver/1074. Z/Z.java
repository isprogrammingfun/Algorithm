import java.io.*;
import java.util.*;

public class Main {
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()); 
		int c = Integer.parseInt(st.nextToken());
		int side = (int) Math.pow(2, N); 
		
		search(side, r, c);
		System.out.println(cnt);
	}

	private static void search(int side, int r, int c) {
		if(side == 1) 
			return;
		
		if(r < side/2 && c < side/2) { // 1사분면에 존재 
			search(side/2, r, c); // 상대 위치
		}
		else if(r < side/2 && c >= side/2) { // 2사분면에 존재
			cnt += side * side / 4;
			search(side/2, r, c - side/2);
		}
		else if(r >= side/2 && c < side/2) { // 3사분면에 존재
			cnt += (side * side / 4) * 2;
			search(side/2, r - side/2, c);
		}
		else { // 4사분면에 존재
			cnt += (side * side / 4) * 3; 
			search(side/2, r - side/2, c - side/2);
		}
	}
}