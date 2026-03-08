/*
문제 설명
정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ n ≤ 100

입출력 예
n	result
10	[1, 3, 5, 7, 9]
15	[1, 3, 5, 7, 9, 11, 13, 15]
*/

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n + 1) / 2];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                answer[index] += i;
                index++;
            }

        }
        return answer;
    }
}