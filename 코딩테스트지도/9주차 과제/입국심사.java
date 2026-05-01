import java.util.*;

class Solution {
    public int solution(int n, int[] times) {
        Arrays.sort(times);
        int answer = 0;
        int left = 1;
        int right = (int) n * times[times.length - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            int complete = 0;

            for (int time : times) {
                complete += mid / time;
            }

            if (complete < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}

/*
일단 로직 구현은 제대로 되었다고 생각함
하지만 디버깅을 해보니까 오류가 나고 그리고 문제를 보면 범위가 상당히
넓어서 int형의 범위를 벗어나는 문제여서 long 타입으로 변경해야 겠다고 생각함
*/



import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left = 1;
        long right = (long) n * times[times.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long complete = 0;

            for (int time : times) {
                complete += mid / time;
            }

            if (complete < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}

/*
일단 int 형을 long 형으로 변경해서 int의 범위가 초과되지 않게 함
그러나 오버플로우가 발생 -> for문을 보다가 이미 n명을 심사할 수 있다면
그냥 탈출해도 되므로 if문과 break를 넣어야 겠다고 생각함
*/

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left = 1;
        long right = (long) n * times[times.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long complete = 0;

            for (int time : times) {
                complete += mid / time;
                if (complete >= n) break;
            }

            if (complete < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
