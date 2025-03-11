class Solution {
    public int solution(int n, int w, int num) {
        // num이 범위를 벗어나면 0 반환
        if (num > n || num <= 0) {
            return 0;
        }
        
        // 상자 높이 계산
        int height = (n % w == 0) ? n/w : n/w + 1;
        
        int[][] arr = new int[height][w];
        
        int count = 1;
        
        // 상자 번호 할당
        for(int i = 0; i < height; i++) {
            if(i % 2 == 0) {
                for(int j = 0; j < w && count <= n; j++) {
                    arr[i][j] = count++;
                }
            } else {
                for(int j = w-1; j >= 0 && count <= n; j--) {
                    arr[i][j] = count++;
                }
            }
        }
        
        // num 상자의 위치 찾기
        int ix = -1, iy = -1;
        boolean found = false;
        
        for(int i = 0; i < height && !found; i++) {
            for(int j = 0; j < w; j++) {
                if(arr[i][j] == num) {
                    iy = i;
                    ix = j;
                    found = true;
                    break;
                }
            }
        }
        
        // 상자를 찾지 못했으면 0 반환
        if (!found) {
            return 0;
        }
        
        // num 상자와 그 위에 있는 모든 상자 세기
        int answer = 0;
        for(int i = iy; i < height; i++) {
            if(ix < w && arr[i][ix] != 0)
                answer++;
        }
        
        return answer;
    }
}