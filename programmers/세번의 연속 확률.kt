/**
 * 3개의 연속된 확률
 * 정수 배열이 주어지면  배열에 세 개의 연속 홀수가 있으면 arr반환됩니다 . true그렇지 않으면 를 반환합니다  false.
 */

class Solution {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        // 배열을 순회하면서 세 개의 연속된 홀수가 있는지 확인합니다.
        // 배열의 길이가 3 미만이면 세 개의 연속된 홀수가 없으므로 false를 반환합니다.
        for (i in 0..arr.size - 3)
            if (arr[i] % 2 == 1 % 2
                && arr[i + 1] % 2 == 1
                && arr[i + 2] % 2 == 1) return true
        return false
    }
}
