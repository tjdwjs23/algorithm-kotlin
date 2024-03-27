/**
 * 길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다.
 * a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.
 * 이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)
 */

class Solution {
    // 주어진 두 배열의 각 요소를 곱한 후 그 결과를 모두 더하여 반환하는 함수
    fun solution(a: IntArray, b: IntArray): Int {
        // 두 배열을 순서대로 짝지어서 Pair로 만든 후, 각 Pair에 대해 첫 번째 요소와 두 번째 요소를 곱한 리스트를 생성한 뒤, 그 합을 반환
        return a.zip(b).map { it.first * it.second }.sum()
    }
}
