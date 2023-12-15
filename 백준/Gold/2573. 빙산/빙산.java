import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		while (true) {
            
			int result = countIsland();
            
			if (result >= 2) {
				break;
			} else if (result == 0) {
				year = 0; // 빙산이 다 녹을 때까지 두 덩어리 이상 분리되지 않는 경우
				break;
			}
			
			bfs();
			year++;
		}

		System.out.println(year);
	}
	
	public static int countIsland() {
		boolean[][] visited = new boolean[N][M];
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] > 0) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
		
		return cnt;
	}
	
	public static void dfs(int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if (!visited[nx][ny] && arr[nx][ny] > 0) {
					dfs(nx, ny, visited);
				}
			}
		}
	}
	
	public static void bfs() {
		Queue<Ice> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0) {
                    q.add(new Ice(i, j));
                    visited[i][j] = true;
                }
            }
        }
		
		while (!q.isEmpty()) {
			Ice ice = q.poll();
			
			int sea = 0; 
			
			for (int i = 0; i < 4; i++) {
				int nx = ice.x + dx[i];
				int ny = ice.y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (!visited[nx][ny] && arr[nx][ny] == 0) {
						sea++;
					}
				}
			}
			
			if (arr[ice.x][ice.y] - sea < 0) {
				arr[ice.x][ice.y] = 0;
			} else {
				arr[ice.x][ice.y] -= sea;
			}
		}
	}

    
    static class Ice {
	int x;
	int y;
	
	public Ice(int x, int y) {
		this.x = x;
		this.y = y;
	    }
    }
}