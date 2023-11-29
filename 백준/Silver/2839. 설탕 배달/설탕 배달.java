import java.io.*;
public class Main {
    static int cnt;
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        
		if (num == 4 || num == 7) {
			System.out.println(-1);
		}
		else if (num % 5 == 0) {
			System.out.println(num / 5);
		}
		else if (num % 5 == 1 || num % 5 == 3) {
			System.out.println((num / 5) + 1);
		}
		else if (num % 5 == 2 || num % 5 == 4) {
			System.out.println((num / 5) + 2);
		}
        
    }
}