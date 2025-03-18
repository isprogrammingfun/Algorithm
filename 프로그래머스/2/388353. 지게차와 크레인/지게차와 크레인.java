import java.util.*;

class Solution {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private String[][] warehouse;
    private boolean[][] accessible;
    private int rows, cols;

    public int solution(String[] storage, String[] requests) {
        initializeWarehouse(storage);
        
        for (String request : requests) {
            updateAccessibility();
            if (request.length() == 2) {
                removeAllContainers(String.valueOf(request.charAt(0)));
            } else {
                removeAccessibleContainers(request);
            }
        }
        
        return countRemainingContainers();
    }

    private void initializeWarehouse(String[] storage) {
        rows = storage.length;
        cols = storage[0].length();
        warehouse = new String[rows + 2][cols + 2];
        
        for (String[] row : warehouse) {
            Arrays.fill(row, "-1");
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                warehouse[i + 1][j + 1] = String.valueOf(storage[i].charAt(j));
            }
        }
    }

    private void updateAccessibility() {
        accessible = new boolean[rows + 2][cols + 2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        accessible[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = current[0] + dx[dir];
                int ny = current[1] + dy[dir];
                if (isOutOfBounds(nx, ny) || accessible[ny][nx] || !warehouse[ny][nx].equals("-1")) continue;
                accessible[ny][nx] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    private boolean isOutOfBounds(int x, int y) {
        return x < 0 || y < 0 || x >= cols + 2 || y >= rows + 2;
    }

    private void removeAllContainers(String target) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (warehouse[i][j].equals(target)) {
                    warehouse[i][j] = "-1";
                }
            }
        }
    }

    private void removeAccessibleContainers(String target) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (warehouse[i][j].equals(target) && isAccessible(j, i)) {
                    warehouse[i][j] = "-1";
                }
            }
        }
    }

    private boolean isAccessible(int x, int y) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (accessible[ny][nx]) return true;
        }
        return false;
    }

    private int countRemainingContainers() {
        int count = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (!warehouse[i][j].equals("-1")) {
                    count++;
                }
            }
        }
        return count;
    }
}
