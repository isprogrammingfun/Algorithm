import java.util.*;
import java.io.*;

public class Main {
	static final int MAX = 1000000; // N은 최악의 경우, 최대 100만까지

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long v[];
		long sum[];
		
		v = new long[MAX+1]; // 최악의 경우인 100만을 모두 담는 배열로, f(1...N)값이 들어간다
		sum = new long[MAX+1]; // 최악의 경우인 100만을 모두 담는 배열로, g(1...N)값이 들어간다.
              // 즉, 덧셈이 누적된 값이 들어간다.
		
		for(int i = 1; i <= MAX; i++) { // 1...N은 모두 1을 약수로 포함하고 있다.
			v[i] = 1;
		}
		
		for(int i = 2; i <= MAX; i++) { // 1은 약수 1밖에 없으므로 2부터 시작
			for(int j = 1; j*i <= MAX; j++) { // 배수 = i를 약수로 갖고있는 값
            			//만약 약수(i)가 2라면, 2의 배수인 2 4 6...이 약수(i) 2를 가지고 있다.
                              //배수 값들을 구하기 위해 약수를 1부터 곱해준다. 
				v[j*i] += i; //그럼 각 인덱스에 약수들이 더해져서 f(1...N)이 될 것이다.
			}
		}
		
		for(int i = 1; i <= MAX; i++){
			sum[i] = sum[i-1] + (int)v[i]; // f(1...N)을 누적하여 덧셈한 값을 sum의 각 인덱스에 할당한다.
                  // 이전 누적 값 + 현재 값
		}
                 //이제 sum[]에 모든 g(1...N)값들이 들어가 있다.
                 //따라서 마지막에 원하는 만큼 반복(t)해서 원하는 N값을 입력하여 g(N)을 출력한다.
		
		int t = Integer.parseInt(bf.readLine());
		while(t--> 0) {
			int n = Integer.parseInt(bf.readLine());
			bw.write(sum[n]+"\n");
		}
		
		bw.flush();//buffer에 저장했다가 한번에 stream에 나타낸다.
		
	}

}