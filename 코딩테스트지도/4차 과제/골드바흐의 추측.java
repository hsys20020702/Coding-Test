import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new HashMap<>();
        int prime = Integer.parseInt(reader.readLine());
        
        boolean a[] = new boolean[10001];
        Arrays.fill(a, true);
        a[0] = false;
        a[1] = false;
        for(int i = 2; (i*i) <= 10000; i++) {
            if(a[i]) {
                for(int j = i * 2; j <= 10000; j+=i) {
                    a[j] = false;
                }
            }
        }
       for(int i = 0; i < prime; i++) {
           int b = Integer.parseInt(reader.readLine());
           int c = b/2;
           int d = b/2;
           while(a[c] == true && a[d] == true) {
               c--;
               d++;
           }
           map.put(c,d); 
       }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            writer.write(entry.getKey());
            writer.write(" ");
            writer.write(entry.getValue());
        }
        writer.flush();
        writer.close();
    }
}


/*
처음에는 단순하게 한 번의 페이즈당 두 개의 값을 write 해야하므로 key, value로 되어있는 map을 사용해야겠다고 생각함
그러나 map은 데이터의 순서를 보장하지 않으므로 사용하면 안됨
*/

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int prime = Integer.parseInt(reader.readLine());
        
        boolean a[] = new boolean[10001];
        Arrays.fill(a, true);
        a[0] = false;
        a[1] = false;
        for(int i = 2; (i*i) <= 10000; i++) {
            if(a[i]) {
                for(int j = i * 2; j <= 10000; j+=i) {
                    a[j] = false;
                }
            }
        }
        
       for(int i = 0; i < prime; i++) {
           int b = Integer.parseInt(reader.readLine());
           int c = b/2;
           int d = b/2;
           while(a[c] == true || a[d] == true) {
               c--;
               d++;
           }
           writer.write(String.valueOf(c) + " " + String.valueOf(d) + "\n");
           
       }
        
       
        
        writer.flush();
        writer.close();
        
        
    }
}

/*
이번에는 그냥 write 했는데도 오류 발생 -> 생각해보니 while문에서 둘 중 하나라도 소수면 반복한다는 오류가 있다는 것을 파악
*/


import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int prime = Integer.parseInt(reader.readLine());
        
        boolean a[] = new boolean[10001];
        Arrays.fill(a, true);
        a[0] = false;
        a[1] = false;
        for(int i = 2; (i*i) <= 10000; i++) {
            if(a[i]) {
                for(int j = i * 2; j <= 10000; j+=i) {
                    a[j] = false;
                }
            }
        }
        
       for(int i = 0; i < prime; i++) {
           int b = Integer.parseInt(reader.readLine());
           int c = b/2;
           int d = b/2;
           while(a[c] == false || a[d] == false) {
               c--;
               d++;
           }
           writer.write(String.valueOf(c) + " " + String.valueOf(d) + "\n");
           
       }
        
       
        
        writer.flush();
        writer.close();
        
        
    }
}




