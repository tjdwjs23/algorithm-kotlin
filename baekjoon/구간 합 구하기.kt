/**
* 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 
* 둘째 줄에는 N개의 수가 주어진다. 
* 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
* 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
*/

fun main() {
    // n은 배열의 크기, m은 쿼리의 수를 의미합니다.
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(n + 1)
    // 입력 받은 문자열을 숫자 배열로 변환하면서 누적 합을 계산합니다.
    readln().split(" ").forEachIndexed { index, value ->
        arr[index + 1] = arr[index] + value.toInt()
    }
    // m개의 쿼리를 처리합니다.
    repeat(m) {
        val (i, j) = readln().split(" ").map { it.toInt() }
        // i부터 j까지의 구간합을 출력합니다.
        println(arr[j] - arr[i - 1])
    }
}
