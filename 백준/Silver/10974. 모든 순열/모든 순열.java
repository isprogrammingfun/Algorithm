import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	private static int N;
	private static int arr[];
	private static boolean isSelected[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		isSelected = new boolean[N];
		
		perm(0);
	}
	
	private static void perm(int cnt) {
		if(cnt == N) {
			for(int i=0;i<N;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
			return ;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i])
				continue;
			arr[cnt] = i+1;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}

}