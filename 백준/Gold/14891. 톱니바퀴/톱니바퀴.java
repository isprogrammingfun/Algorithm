import java.util.*;
import java.io.*;

public class Main {
    static int[][] wheels = new int[4][8];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 4; i++) {
            wheels[i] = br.readLine().chars().map(c -> c - '0').toArray();
        }
        
        int K = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            moveWheels(num, direction);
        }
        
        int sum = 0;
        if (wheels[0][0] == 1) sum += 1;
        if (wheels[1][0] == 1) sum += 2;
        if (wheels[2][0] == 1) sum += 4;
        if (wheels[3][0] == 1) sum += 8;
        
        System.out.println(sum);
    }
    
    private static void moveWheels(int num, int direction) {
        int[] directions = new int[4];
        directions[num] = direction;
        
        for (int i = num; i < 3; i++) {
            if (wheels[i][2] != wheels[i + 1][6]) {
                directions[i + 1] = -directions[i];
            } else {
                break;
            }
        }
        
        for (int i = num; i > 0; i--) {
            if (wheels[i][6] != wheels[i - 1][2]) {
                directions[i - 1] = -directions[i];
            } else {
                break;
            }
        }
        
        for (int i = 0; i < 4; i++) {
            if (directions[i] != 0) {
                rotateWheel(wheels[i], directions[i]);
            }
        }
    }
    
    private static void rotateWheel(int[] wheel, int direction) {
        if (direction == 1) {
            int temp = wheel[7];
            System.arraycopy(wheel, 0, wheel, 1, 7);
            wheel[0] = temp;
        } else {
            int temp = wheel[0];
            System.arraycopy(wheel, 1, wheel, 0, 7);
            wheel[7] = temp;
        }
    }
}
