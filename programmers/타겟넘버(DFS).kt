/**
 * 문제 설명
 * n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 */

class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0 // 정답을 저장할 변수 선언. 타겟 넘버를 만들 수 있는 방법의 수를 카운트합니다.

        // 깊이 우선 탐색(DFS) 함수. 현재까지의 합(sum)과 현재 인덱스(idx)를 매개변수로 받습니다.
        fun dfs(sum: Int, idx: Int){
            // 현재 인덱스가 numbers 배열의 마지막 인덱스보다 작은 경우, 즉 아직 모든 숫자를 고려하지 않은 경우
            if(idx < numbers.size - 1){
                // 현재 숫자를 더하는 경우의 탐색을 재귀적으로 호출
                dfs(sum + numbers[idx], idx + 1)
                // 현재 숫자를 빼는 경우의 탐색을 재귀적으로 호출
                dfs(sum - numbers[idx], idx + 1)
            }
            // 모든 숫자를 고려한 경우(마지막 인덱스에 도달한 경우)
            else{
                // 현재까지의 합에 마지막 숫자를 더했을 때 타겟 넘버와 같다면 answer를 1 증가
                if(sum + numbers[idx] == target) {answer++}
                // 현재까지의 합에서 마지막 숫자를 뺐을 때 타겟 넘버와 같다면 answer를 1 증가
                if(sum - numbers[idx] == target) {answer++}
            }
        }
        // DFS 탐색 시작. 처음에는 합을 0으로, 인덱스를 0으로 설정
        dfs(0, 0)
        return answer // 탐색을 마친 후, 타겟 넘버를 만들 수 있는 방법의 수를 반환
    }
}
