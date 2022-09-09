import java.util.Scanner; 

public class Main {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int max = 0;
        int min = 1000001;
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            if(num > max)
                max = num;
            if(num < min)
                min = num;
        }
        System.out.println(min*max);
    }
}