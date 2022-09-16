import java.util.Scanner; 
public class Main {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        
        if(max <= 1) return;
 
        boolean[] arr = new boolean[max+1];    //true 이면 해당 인덱스 소수.
        arr[0] = arr[1] = false;
        for(int i=2; i<=max; i++) {
            arr[i] = true;
        }
 
        //2 부터 숫자를 키워가며 배수들을 제외(false 할당)
        for(int i=2; i<=Math.sqrt(max); i++) {
            for(int j=i*i; j<=max; j+=i) {
                arr[j] = false;        //2를 제외한 2의 배수 false
            }
        }
        for(int i=min; i<=max; i++) {
            if(true == arr[i]) {
                System.out.println(i);
            }
        }
    }
}