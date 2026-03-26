import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a,b) -> b-a);
        int answer = 0;
        
        int n = Integer.parseInt(reader.readLine());
        for(int i = 0; i < n; i++) {
            int j = Integer.parseInt(reader.readLine());
            minQueue.offer(j);
            maxQueue.offer(j);
        }
        
        if(n % 2 == 0) { // 짝수
            for(int i = 0; i < n/2; i++) {
                int a = minQueue.poll();
                int b = maxQueue.poll();
                answer = a + b;
            }
        }
        else { // 홀수
            for(int i = 0; i < n/2; i++) {
                int a = minQueue.poll();
                int b = maxQueue.poll();
                answer = a + b;
            }
            answer += minQueue.poll();
        }
        
        writer.write(answer);
    }
}
/*
최소 최대 끼리 합 -> 최소 + 1과 최대 + 1 끼리 합 
*/
/*
처음에는 전혀 문제를 이해하지 못하고 최대 큐와 최소 큐를 사용하여 풀어야 하는 줄 알았음
또한 답을 구할 때도 두 개의 우선순위 큐를 활용하고 짝,홀수를 나눠서 풀이해야 하는 것으로 알고있었음
그러나 다시 생각해보니 그게 아니었음
*/


import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        int answer = 0;
        
        int n = Integer.parseInt(reader.readLine());
        for(int i = 0; i < n; i++) {
            int j = Integer.parseInt(reader.readLine());
            minQueue.offer(j);
        }
        
        int first = minQueue.poll();
        int second = minQueue.poll();
        answer += (first+second);
        
        while(!minQueue.isEmpty()) {
            int a = minQueue.poll();
            answer += a;
        }
        
        
        writer.write(answer);
    }
}
/*
이제 큐 1개만 사용하는 것으로 변경하였으나
while 문의 조건문을 !queue.isEmpty()로 하여 오류 발생
또한 while문 밖에서 queue.poll()을 실행하여 논리에 맞지 않다고 생각
*/






import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        int answer = 0;
        
        int n = Integer.parseInt(reader.readLine());
        for(int i = 0; i < n; i++) {
            int j = Integer.parseInt(reader.readLine());
            minQueue.offer(j);
        }
        
        
        
        while(minQueue.size() > 1) {
            int a = minQueue.poll();
            int b = minQueue.poll();
            answer += (a+b);
            minQueue.offer(a+b);
        }
        
        
        writer.write(String.valueOf(answer));
        writer.flush();
        writer.close();
    }
}
/*

10 20 40
a b c
10 + 20   +    30 + 40

a + b + (a+b) + c
맨 앞 + 맨 앞 다음 + (맨앞+다음) + 맨 앞 다음다음
*/

/*
일단 while문의 조건문을 size()가 1보다 작아지면 종료되게 하였고
정확히 논리에 맞게 2개를 poll()해서 더하고 다시 answer에 추가하고
이 추가한 값을 다시 queue에 offer해서 저장
또한 BufferedWriter에서 flush(),close()를 하여 완벽히 종료되게 함
*/
