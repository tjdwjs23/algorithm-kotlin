/**
 * 정수가 주어지면 다음과 같이 문자열 배열 ( 1부터 인덱스 )n 을 반환합니다 .answer
 * answer[i] == "FizzBuzz"는 와 i로 나누어 떨어진다 .35
 * answer[i] == "Fizz"는 i로 나누어 떨어진다 3.
 * answer[i] == "Buzz"는 i로 나누어 떨어진다 5.
 * answer[i] == i(문자열로) 위 조건 중 어느 것도 참이 아닌 경우.
*/

class Solution {
    fun fizzBuzz(n: Int): List<String> = List<String>(n) {
        val currentNumber = it + 1
        when {
            currentNumber % 15 == 0 -> "FizzBuzz"
            currentNumber % 3 == 0 -> "Fizz"
            currentNumber % 5 == 0 -> "Buzz"
            else -> currentNumber.toString()
        }
    }
}
