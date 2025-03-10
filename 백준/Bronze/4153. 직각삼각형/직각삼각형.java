import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            while ((str = br.readLine()) != null && !str.equals("0 0 0")) {
                String[] values = str.split("\\s+");
                
                if (values.length == 3) {
                    try {
                        int a = Integer.parseInt(values[0]);
                        int b = Integer.parseInt(values[1]);
                        int c = Integer.parseInt(values[2]);
                        
                        int[] sides = {a, b, c};
                        Arrays.sort(sides); // 오름차순 정렬

                        if (Math.pow(sides[0], 2) + Math.pow(sides[1], 2) == Math.pow(sides[2], 2)) {
                            System.out.println("right");
                        } else {
                            System.out.println("wrong");
                        }
                        
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 숫자 형식입니다.");
                    }
                } else {
                    System.out.println("숫자가 세 개가 아닙니다.");
                }
            }
        } catch (IOException e) {
            System.out.println("입출력 오류 발생");
        }
    }
}