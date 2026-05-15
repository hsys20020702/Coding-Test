import java.util.*;

class Solution {
    public int solution(int n, int[][] vertex) {
        
        boolean[][] graph = new boolean[n + 1][n + 1];
        
        for (int[] edge : vertex) {
            int a = edge[0];
            int b = edge[1];
        }
        
        int[] distances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        
        int maxDistance = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.remove();
            
            for (int next = 1; next <= n; next++) {
                if (graph[current][next] && !visited[next]) {
                    visited[next] = true;
                    distances[next] = distances[current] + 1;
                    queue.add(next);
                    maxDistance = Math.max(maxDistance, distances[next]);
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == maxDistance) {
                count++;
            }
        }
        return count;
    }
}
/*
처음에는 논리적으로 잘 풀었다고 생각이 들어서 컴파일을 해보았는데
시간 에러가 발생
문제를 다시 보니까 N이 20000인 것을 확인하고 2차원 배열로 풀면 안되겠다고 생각
또한 밑에 for문을 돌리는 것도 일단 다시 생각해봐야 겠다고 판단
*/

/*
다시 생각해보니까 그래프는 양방향이 가능하므로 graph[b][a] = true;를 빼먹음
이거도 추가해야 함
*/


/*
최종 코드
*/
import java.util.*;

class Solution {
    public int solution(int n, int[][] vertex) {
        ArrayList<Integer>[] neighbors = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            neighbors[i] = new ArrayList<>();
        }
        
        for (int[] edge : vertex) {
            int a = edge[0];
            int b = edge[1];
            neighbors[a].add(b);
            neighbors[b].add(a); 
        }
        
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1); 
        distances[1] = 0; 
        
        int maxDistance = 0; 
        
        while (!queue.isEmpty()) {
            int current = queue.remove();
            
            for (int next : neighbors[current]) {
                if (distances[next] == -1) {
                    distances[next] = distances[current] + 1; 
                    queue.add(next);
                    
                    maxDistance = Math.max(maxDistance, distances[next]);
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == maxDistance) {
                count++;
            }
        }
        return count;
    }
}
