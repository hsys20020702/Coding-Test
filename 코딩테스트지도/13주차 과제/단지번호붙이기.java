import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> complexSizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i, j); 
                    complexSizes.add(size); 
                }
            }
        }

        Collections.sort(complexSizes);

        System.out.println(complexSizes.size()); 
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    static int bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        
        int count = 1; 

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (map[nr][nc] == 1 && !visited[nr][nc]) {
                        queue.add(new int[]{nr, nc});
                        count++; 
                    }
                }
            }
        }
        
        return count; 
    }
}
/*
실행 오류
일단 첫 번쨰 오류는 생각했을 때 static으로 전역 변수로 map, visited 배열을 생성했는데 
내가 초기화를 하지 않음  
*/

/*
두 번째 오류 발생
이번에는 실행은 되는데 이상한 값이 나옴
마지막에 if 문에 visited[nr][nc] 처리를 하지 않음
*/


/*
정답 코드
*/
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> complexSizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i, j); 
                    complexSizes.add(size); 
                }
            }
        }

        Collections.sort(complexSizes);

        System.out.println(complexSizes.size()); 
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    static int bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        
        int count = 1; 

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (map[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                        count++; 
                    }
                }
            }
        }
        
        return count; 
    }
}
