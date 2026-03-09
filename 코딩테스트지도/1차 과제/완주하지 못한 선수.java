/*
IT융합자율학부 컴퓨터공학 전공 202114036 김현서 
코딩테스트 지도 1차 과제
2026-03-10 제출
*/

// 처음 코드(문제 발생)
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> finalmap = new HashMap<>();
        for(String i : participant) {
            finalmap.put(i,1);
        }
        for(String j : completion) {
            finalmap.put(j,finalmap.get(j)-1);
        }
        for(String key : finalmap.keySet()) {
            if(finalmap.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }
}
/*
현재 코드 문제점 
이미 등록되어 있는 이름인 경우나 이름이 없는 경우를 확인하지 못함
Map에 이름이 있거나 없는지 확인하지 않고 무조건 put을 진행 중

>> if,else 문을 이용하면서 이름이 없으면 새로 등록하고
이름이 있으면 기존에 있던 인원수에 +1을 하는 방식으로 진행

*/

/*
그러나 if,else 문을 사용하면 반대로 코드가 너무 길어질꺼 같아
좀 더 효율적인 방법이 있는지 찾아 보던 중 getOrDefault를 찾아서 진행
*/

// 최종 코드
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> finalmap = new HashMap<>();
        for(String i : participant) {
            finalmap.put(i,finalmap.getOrDefault(i,0)+1);
        }
        for(String j : completion) {
            finalmap.put(j,finalmap.get(j)-1);
        }
        for(String key : finalmap.keySet()) {
            if(finalmap.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }
}
