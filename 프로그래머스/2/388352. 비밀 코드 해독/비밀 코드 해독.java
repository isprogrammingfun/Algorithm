import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        List<int[]> combi = generateCombinations(n);
        List<int[]> possibleCombi = combi.stream()
                                         .filter(c -> isValid(c,q,ans))
                                         .collect(Collectors.toList());
        answer = possibleCombi.size();
        return answer;
    }
    
    private List<int[]> generateCombinations(int n) {
        // 조합을 담을 리스트
        List<int[]> combinations = new ArrayList<>(); 
        // 현재 조합
        int[] current = new int[5];
        
        generateCombinationsHelper(combinations, current, 0, 1, n);
        return combinations;
    }
    
    // 조합 재귀함수로 구현
    private void generateCombinationsHelper(List<int[]> combinations, int[] current, int index, int start, int n) {
        // 다 선택한 경우
        if(index == 5) {
            //리스트에 조합 추가
            combinations.add(current.clone()); 
            return;
        }
        
        for(int i = start; i <= n; i++) {
            current[index] = i;
            generateCombinationsHelper(combinations, current, index + 1, i + 1, n);
        }
    }
    
    private boolean isValid(int[] combi, int[][] q, int[] ans) {
        for(int i = 0; i < q.length; i++) {
            int count = 0;
            for (int num : q[i]) {
                for(int combiNum: combi) {
                    if(num == combiNum) {
                        count++;
                        break;
                    }
                }
            }
            if(count != ans[i])
                return false;
        }
        return true;
    }
}