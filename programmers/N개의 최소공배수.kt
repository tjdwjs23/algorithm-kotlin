/**
 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서,
 * n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 */

class Solution {
    // fold 함수를 이용하여 배열의 모든 요소에 대해 최소공배수를 구하는 solution 함수 정의
    fun solution(arr: IntArray): Int = arr.fold(1) {lcm, i -> getLcm(lcm, i) }

    // 두 정수의 최대공약수를 구하는 함수, 유클리드 호제법을 사용
    private fun getGcd(targetNumber1 : Int, targetNumber2 : Int) : Int {
        var gcm = targetNumber1 // 임시 최대공약수 변수 초기화
        var divisor = targetNumber2 // 나누는 수 초기화
        var rest = 0 // 나머지를 저장할 변수 초기화
        while(divisor != 0) { // 나누는 수가 0이 아닐 때까지 반복
            rest = gcm % divisor // 현재 나누는 수로 나눈 나머지 계산
            gcm = divisor // 나누는 수를 최대공약수로 업데이트
            divisor = rest // 나머지를 새로운 나누는 수로 설정
        }
        return gcm // 계산된 최대공약수 반환
    }

    // 두 정수의 최소공배수를 구하는 함수, 유클리드 호제법의 최대공약수를 이용
    private fun getLcm(targetNumber1: Int, targetNumber2: Int) : Int =
        targetNumber1 * targetNumber2 / getGcd(targetNumber1, targetNumber2) // 두 수의 곱을 최대공약수로 나눈 값이 최소공배수
}
