/**
 * 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
 * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
 * n=17일때 까지 피보나치 수를 써보면 다음과 같다.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
 * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 */

fun main() = System.`in`.bufferedReader().run {
    // 사용자로부터 입력을 받아 정수 n을 읽습니다.
    val n = readLine()!!.toInt()

    // tailrec 키워드를 사용한 꼬리 재귀 함수 fibo를 정의합니다.
    // 이 함수는 n, pre, next를 인자로 받아 피보나치 수를 계산합니다.
    tailrec fun fibo(n: Int , pre:Int, next:Int): Int {
        // 기저 조건: n이 0 이하일 경우, pre 값을 반환합니다.
        if (n <= 0) return pre
        // 재귀 호출: n을 1 감소시키고, pre에는 next 값을, next에는 pre와 next의 합을 넣어 호출합니다.
        return fibo(n - 1, next, pre +next)
    }

    // fibo 함수를 호출하여 결과를 출력합니다. 초기 pre 값은 0, next 값은 1로 설정합니다.
    print(fibo(n,0,1))
}
