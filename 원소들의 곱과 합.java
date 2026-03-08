/*
문제 설명
정수가 담긴 리스트 num_list가 주어질 때, 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.

제한사항
2 ≤ num_list의 길이 ≤ 10
1 ≤ num_list의 원소 ≤ 9

입출력 예
num_list	result
[3, 4, 5, 2, 1]	1
[5, 7, 8, 3]	0
*/

class Solution {
    public int solution(int[] num_list) {
        int pow = 1;
        int plus = 0;
        int answer = 0;
        for (int i = 0; i < num_list.length; i++) {
            pow = pow * num_list[i];
            plus += num_list[i];
        }
        if (pow < plus * plus) {
            answer = 1;
        } else {
            answer = 0;
        }
        return answer;
    }
}