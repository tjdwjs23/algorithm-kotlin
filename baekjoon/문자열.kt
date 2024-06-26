/**
 * 문제
 * 길이가 N으로 같은 문자열 X와 Y가 있을 때, 두 문자열 X와 Y의 차이는 X[i] ≠ Y[i]인 i의 개수이다. 예를 들어, X=”jimin”, Y=”minji”이면, 둘의 차이는 4이다.
 *
 * 두 문자열 A와 B가 주어진다. 이때, A의 길이는 B의 길이보다 작거나 같다. 이제 A의 길이가 B의 길이와 같아질 때 까지 다음과 같은 연산을 할 수 있다.
 *
 * A의 앞에 아무 알파벳이나 추가한다.
 * A의 뒤에 아무 알파벳이나 추가한다.
 * 이때, A와 B의 길이가 같으면서, A와 B의 차이를 최소로 하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 A와 B가 주어진다. A와 B의 길이는 최대 50이고, A의 길이는 B의 길이보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.
 *
 * 출력
 * A와 B의 길이가 같으면서, A와 B의 차이를 최소가 되도록 했을 때, 그 차이를 출력하시오.
 */

fun main() = System.`in`.bufferedReader().run {
    val (A, B) = readLine().split(" ")
    val diff = B.length - A.length
    var minDiff = B.length
    // B와 A의 길이 차이만큼 반복하면서 A와 B의 차이를 계산한다.
    for (i in 0..diff) {
        var count = 0
        for (j in 0 until A.length) {
            // A와 B의 차이가 발생하면 count를 증가시킨다.
            if (A[j] != B[i + j]) {
                count++
            }
        }
        // A와 B의 차이가 최소가 되도록 업데이트한다.
        minDiff = minOf(minDiff, count)
    }
    println(minDiff)
}