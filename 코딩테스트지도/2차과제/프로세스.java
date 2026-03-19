import java.util.*;
class Solution {
  public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
          Arrays.sort(priorities); // 우선순위 순으로 정렬(낮음 -> 높음)
        for(int i = 0; i < priorities.length; i++) {
            int[] a = new int[2];
            a[0] = priorities[i]; // 우선 순위
            a[1] = i; // 원래 인덱스
            queue.offer(a); // 큐에 넣기
        }

/*
처음에는 단순하게 배열을 정렬하여 우선순위가 낮음 -> 높음 순으로 위치시키면 되겠다고 생각
그러나 Arrays.sort()를 하면 원래 배열의 인덱스가 사라지는 문제가 발생
>> 원래 인덱스를 살리기 위해서 일단 큐에 원래 인덱스, 우선순위 값을 넣는 것을 우선으로 판단
*/

/*
결국에 이 코드의 리턴값은 location 위치의 실행 순서이기 때문에 if 문과 count 형식으로 
포인터 이동을 구현해야 겠다고 생각
*/

// 최종 코드
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            int[] a = new int[2];
            a[0] = priorities[i]; // 우선 순위
            a[1] = i; // 원래 인덱스
            queue.offer(a); // 큐에 넣기
        }
        Arrays.sort(priorities); // 우선순위 순으로 정렬(낮음 -> 높음)
        
        int target = priorities.length - 1;
        int answer = 0;
        
        while(!queue.isEmpty()) {
            int[] b = queue.poll(); // 꺼내서 확인
            if(b[0] == priorities[target]) {
                target--;
                answer++;
                if(b[1] == location) {
                    return answer;
                }
            }
            else {
                queue.offer(b);
            }
            
        }
        return answer;
    }
}
