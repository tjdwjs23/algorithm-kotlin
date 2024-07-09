/**
 * 문제
 * 어떤 수 X가 주어졌을 때, X의 모든 자리수가 역순이 된 수를 얻을 수 있다. Rev(X)를 X의 모든 자리수를 역순으로 만드는 함수라고 하자. 예를 들어, X=123일 때, Rev(X) = 321이다. 그리고, X=100일 때, Rev(X) = 1이다.
 *
 * 두 양의 정수 X와 Y가 주어졌을 때, Rev(Rev(X) + Rev(Y))를 구하는 프로그램을 작성하시오
 *
 * 입력
 * 첫째 줄에 수 X와 Y가 주어진다. X와 Y는 1,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 문제의 정답을 출력한다.
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (X, Y) = readLine().split(" ").map { it.toInt() }
    // X와 Y를 역순으로 만들어 더한 후 다시 역순으로 만들어 출력
    println(Rev(Rev(X) + Rev(Y)))
}

// 숫자를 역순으로 만드는 함수
fun Rev(n: Int): Int {
    var result = 0
    var num = n
    while (num > 0) {
        // result에 num의 일의 자리 숫자를 추가하고 num을 10으로 나누어 일의 자리 숫자를 없앤다.
        result = result * 10 + num % 10
        // num을 10으로 나누어 일의 자리 숫자를 없앤다.
        num /= 10
    }
    return result
}