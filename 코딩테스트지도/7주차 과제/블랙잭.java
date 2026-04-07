import java.util.*;
import java.io.*;
public class Main{
    static int n;
    static int m;
    static int[] number;
    static int ans;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokeninzer(reader.readLine());
        
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
        
        StringTokenizer tokenizer = new StringTokeninzer(reader.readLine());
        number = new int[n];
        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(tokenizer.nextToken());
        }
        plus(0,0,0);
        writer.write(ans);
        writer.flush();
        writer.close();
    }
     static void plus(int count, int sum, int start) {
         if(sum > m) {
                return;
         }
         if(count == 3) {
             ans = Math.max(ans, sum);
             return;
         }
         for(int i = 0; i < n; i++){
             plus(count+1, sum+a[i], i+1);
         }
        }
}
/*
일단 재귀를 사용해서 구현을 시도했다 먼저 재귀 함수에는 숫자의 개수, 합, 시작 인덱스가 변수로 들어갔다
그러나 에러가 발생했다
내가 생각해보았을 때 재귀함수의 for문에서 0부터 또 시작하면 시작 인덱스인 start가 반영되지 않아 중복일 발생할 것이라고 생각한다
일단 for의 시작을 start로 바꾸고 또 writer.write()에서 String.valueOf를 사용하지 않은 것도 문제라고 생각한다
*/

import java.util.*;
import java.io.*;
public class Main{
    static int n;
    static int m;
    static int[] number;
    static int ans;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st    .nextToken());
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        number = new int[n];
        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(tokenizer.nextToken());
        }
        plus(0,0,0);
        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }
     static void plus(int count, int sum, int start) {
         if(sum > m) {
                return;
         }
         if(count == 3) {
             ans = Math.max(ans, sum);
             return;
         }
         for(int i = start; i < n; i++){
             plus(count+1, sum+number[i], i+1);
         }
        }
}
