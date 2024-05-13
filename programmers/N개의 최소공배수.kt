/**
 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서,
 * n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 */

class Solution {
    fun solution(arr: IntArray): Int = arr.fold(1) {lcm, i -> getLcm(lcm, i) }

    // 최대공약수를 구하는 함수
    private fun getGcd(targetNumber1 : Int, targetNumber2 : Int) : Int {
        var gcm = targetNumber1
        var divisor = targetNumber2
        var rest = 0
        while(divisor != 0) {
            rest = gcm % divisor
            gcm = divisor
            divisor = rest
        }
        return gcm
    }

    // 유클리드 호제법을 이용하여 최소공배수를 구하는 함수
    private fun getLcm(targetNumber1: Int, targetNumber2: Int) : Int = targetNumber1 * targetNumber2 / getGcd(targetNumber1, targetNumber2)
}
