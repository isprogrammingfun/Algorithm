import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            set.add(str);
        }

        set.removeIf(Main::isDigit);

        List<String> arr = new ArrayList<>(set);

        Comparator<String> sortedArr = (s1, s2) -> {
            int result = Integer.compare(s1.length(), s2.length());
            if (result == 0) {
                return s1.compareTo(s2);
            }
            return result;
        };

        Collections.sort(arr, sortedArr);

        for (String str : arr) {
            System.out.println(str);
        }
    }

    private static boolean isDigit(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
