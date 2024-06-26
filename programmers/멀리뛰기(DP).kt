/**
 * 문제 설명
 * 효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
 * (1칸, 1칸, 1칸, 1칸)
 * (1칸, 2칸, 1칸)
 * (1칸, 1칸, 2칸)
 * (2칸, 1칸, 1칸)
 * (2칸, 2칸)
 * 의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
 *
 * 제한 사항
 * n은 1 이상, 2000 이하인 정수입니다.
 */

class Solution {
    // 이 함수는 멀리 뛰기 칸의 수 n을 입력으로 받고, 해당 칸 수에 대한 뛰기 방법의 수를 반환합니다.
    fun solution(n: Int): Long {
        // jump 함수를 재귀적으로 호출하여 문제를 해결합니다.
        // 초기값으로 a는 1, b는 2를 전달합니다. 이는 첫 번째 칸과 두 번째 칸에 도달하는 방법의 수를 의미합니다.
        return jump(n, 1L, 2L)
    }

    // n은 도달해야 하는 목표 칸 수, a는 n-1번째 칸에 도달하는 방법의 수, b는 n번째 칸에 도달하는 방법의 수입니다.
    tailrec fun jump(n: Int, a: Long, b: Long): Long {
        // 기본 경우: n이 1이면, 첫 번째 칸에 도달하는 방법의 수인 a를 반환합니다.
        if (n == 1) return a

        // 재귀 호출: n이 1보다 크면, 함수를 다시 호출합니다.
        // 이때, n-1을 전달하여 한 칸 앞으로 진행하고,
        // a의 자리에는 이전 b(현재 칸에 도달하는 방법의 수)를,
        // b의 자리에는 현재 칸과 이전 칸에 도달하는 방법의 수의 합을 전달합니다.
        // 합산 시 1234567로 나눈 나머지를 사용하여 오버플로우를 방지하고, 문제의 조건을 만족시킵니다.
        return jump(n - 1, b % 1234567L, (a + b) % 1234567L)
    }
}
