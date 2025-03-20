import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binaryStr = Integer.toBinaryString(sc.nextInt() + 1).replace('0','4').replace('1', '7');
        String str = binaryStr.substring(1);
        
        System.out.println(str);
    }
}