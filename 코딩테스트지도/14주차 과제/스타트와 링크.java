import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getLink(0, 0);
        System.out.println(minDiff);
    }

    static void getLink(int from, int count) {
        if (count == N / 2) {
            calculateDiff();
            return;
        }

        for (int i = 0; i < N; i++) { 
            if (!visited[i]) {
                visited[i] = true;
                getLink(i + 1, count + 1); // 👈 i + 1 로직을 헷갈려서 잘못 적는 경우
                
            }
        }
    }

    static void calculateDiff() {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeamScore += S[i][j]; 
                } else if (!visited[i] && !visited[j]) {
                    linkTeamScore += S[i][j];
                }
            }
        }
        
        int diff = startTeamScore - linkTeamScore; 
        minDiff = Math.min(minDiff, diff);
    }
}
/*
제대로 컴파일되지 않는다
가장 먼저 문제는 시작을 from으로 안하고 그냥 0으로 시작
그리고 백트래킹을 해야하는데 (false) 이거를 안했다
*/

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getLink(0, 0);
        System.out.println(minDiff);
    }

    static void getLink(int from, int count) {
        if (count == N / 2) {
            calculateDiff();
            return;
        }

        for (int i = from; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                getLink(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }


      static void calculateDiff() {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeamScore += S[i][j]; 
                } else if (!visited[i] && !visited[j]) {
                    linkTeamScore += S[i][j];
                }
            }
        }
        
        int diff = startTeamScore - linkTeamScore; 
        minDiff = Math.min(minDiff, diff);
    }
}
/*
수정을 해도 또 오류 발생
startTeamScore를 갱신할 때 S[i][j]만 하고 반대는 하지 않음
S[j][i]도 해야 됨
마지막에 diff를 구할 때 그냥 뺄셈을 해서 음수가 나옴
절댓값이 있어야 함
*/

/*
정답 코드
*/
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getLink(0, 0);
        System.out.println(minDiff);
    }

    static void getLink(int from, int count) {
        if (count == N / 2) {
            calculateDiff();
            return;
        }

        for (int i = from; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                getLink(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    static void calculateDiff() {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeamScore += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeamScore += S[i][j] + S[j][i];
                }
            }
        }

        int diff = Math.abs(startTeamScore - linkTeamScore);

        if (diff == 0) {
            System.out.println(0);
            System.exit(0);
        }

        minDiff = Math.min(minDiff, diff);
    }
}
