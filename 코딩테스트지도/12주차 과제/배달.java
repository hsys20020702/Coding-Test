import java.util.*;

class Solution {
    class Edge {
        int to, weight;
        public Edge(int to, int weight) { this.to = to; this.weight = weight; }
    }

    public int solution(int N, int[][] road, int K) {
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for(int[] r : road) {
            graph[r[0]].add(new Edge(r[1], r[2]));
            graph[r[1]].add(new Edge(r[0], r[2]));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<Edge> q = new ArrayDeque<>(); 
        
        q.add(new Edge(1, 0));
        dist[1] = 0;

        while (!q.isEmpty()) {
            Edge current = q.remove();

            for (Edge next : graph[current.to]) {
                if (dist[next.to] > dist[current.to] + next.weight) {
                    dist[next.to] = dist[current.to] + next.weight;
                    q.add(new Edge(next.to, dist[next.to])); 
                }
            }
        }
        
         int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                count++;
            }
        }
        
      
        return 0; 
    }
}


/*
현재 이 코드가 시간 오류가 발생했다
일단 문제를 파악해 봤을 때 우선순위 큐를 사용하지 않았다는 것을 먼저 알았다
우선순위 큐를 적용해보자
*/
import java.util.*;

class Solution {
    class Edge {
        int to, weight;
        public Edge(int to, int weight) { this.to = to; this.weight = weight; }
    }

    public int solution(int N, int[][] road, int K) {
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for(int[] r : road) {
            graph[r[0]].add(new Edge(r[1], r[2]));
            graph[r[1]].add(new Edge(r[0], r[2]));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        q.add(new Edge(1, 0));
        dist[1] = 0;

        while (!q.isEmpty()) {
            Edge current = q.remove();

            for (Edge next : graph[current.to]) {
                if (dist[next.to] > dist[current.to] + next.weight) {
                    dist[next.to] = dist[current.to] + next.weight;
                    

                    q.add(new Edge(next.to, dist[next.to])); 
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                count++;
            }
        }

        return 0; 
    }
}
/*
지금 또 오류가 발생
우선순위 큐가 문제가 아니라 add를 할 때 순서 보장이 안되는 문제가 발생
*/

// 최종 정답 코드
import java.util.*;

class Solution {
    static class Edge implements Comparable<Edge> {
        int to;
        int weight;
        
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public int solution(int N, int[][] road, int K) {
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            int u = r[0];
            int v = r[1];
            int w = r[2];
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); 

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        dist[1] = 0; 
        pq.add(new Edge(1, 0));
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll(); 

            if (dist[current.to] < current.weight) {
                continue;
            }
            

            for (Edge next : graph[current.to]) {
                if (dist[next.to] > dist[current.to] + next.weight) {
                    dist[next.to] = dist[current.to] + next.weight;
                    pq.add(new Edge(next.to, dist[next.to])); 
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                count++;
            }
        }
        
        return count;
    }
}
