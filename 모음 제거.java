/*
문제 설명
영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다. 문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.

제한사항
my_string은 소문자와 공백으로 이루어져 있습니다.
1 ≤ my_string의 길이 ≤ 1,000

입출력 예
my_string	result
"bus"	"bs"
"nice to meet you"	"nc t mt y"
*/

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        String vowels = "aeiou";

        for (char c : my_string.toCharArray()) { // 문자열을 배열처럼 하나씩 꺼내기
            if (vowels.indexOf(c) == -1) { // 모음 문자열에 c가 없다면 (-1)
                sb.append(c);
            }
        }
        return sb.toString();
    }
}