/**
 * 역 폴란드 표기법tokens 의 산술 표현식을 나타내는 문자열 배열이 제공됩니다 .
 *
 * 표현을 평가해 보세요. 표현식의 값을 나타내는 정수를 반환합니다 .
 *
 * 참고 사항:
 *
 * 유효한 연산자는 '+', '-', '*'및 입니다 '/'.
 * 각 피연산자는 정수이거나 다른 표현식일 수 있습니다.
 * 두 정수 사이의 나눗셈은 항상 0을 향해 잘립니다 .
 * 0으로 나누는 일은 없을 것입니다.
 * 입력은 역방향 폴란드어 표기법으로 유효한 산술 표현식을 나타냅니다.
 * 답과 모든 중간 계산은 32비트 정수로 표현될 수 있습니다.
 */

class Solution {
    // evalRPN 함수 정의: 후위 표기법으로 표현된 수식을 계산하여 정수 결과를 반환
    fun evalRPN(tokens: Array<String>): Int {
        // 계산 과정에서 사용할 정수 스택 초기화
        val stack: Stack<Int> = Stack()
        // 입력된 토큰들을 순회하면서 처리
        tokens.forEach { token ->
            when (token) {
                // 현재 토큰이 연산자인 경우
                "+", "-", "*", "/" -> {
                    // 스택에서 두 개의 정수를 꺼내 연산을 수행
                    val right = stack.pop() // 오른쪽 피연산자
                    val left = stack.pop() // 왼쪽 피연산자
                    // 연산자에 따라 해당 연산을 수행하고 그 결과를 다시 스택에 넣음
                    when (token) {
                        "+" -> stack.push(left + right) // 덧셈
                        "-" -> stack.push(left - right) // 뺄셈
                        "*" -> stack.push(left * right) // 곱셈
                        "/" -> stack.push(left / right) // 나눗셈, 정수 나눗셈으로 몫만 계산
                    }
                }
                // 현재 토큰이 연산자가 아닌 경우 (즉, 숫자인 경우)
                else -> stack.push(token.toInt()) // 토큰을 정수로 변환하여 스택에 넣음
            }
        }
        // 모든 토큰 처리 후, 스택에 남은 마지막 값이 최종 계산 결과
        return stack.pop()
    }
}
