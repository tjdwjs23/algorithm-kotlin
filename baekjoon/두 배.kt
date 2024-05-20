/**
 * 수열을 오름차순으로 만들기 위해 원소에 2를 곱하는 연산을 최소 몇 번 해야하는가?
 */

import kotlin.math.ceil
import kotlin.math.log2

fun main() = System.`in`.bufferedReader().run {
    val n = readLine().toInt()
    val numbers = readLine().split(" ").map { it.toInt() }.toMutableList()
    var count = 0

    for (i in 0 until n - 1) {
        if (numbers[i] > numbers[i + 1]) {
            // numbers[i]를 numbers[i + 1]로 만들기 위해 2를 곱하는 최소 횟수를 구하고 count에 더함
            count += findMinimumTimes(numbers[i], numbers[i + 1])
            // numbers[i + 1]을 numbers[i]로 만듦
            numbers[i + 1] = numbers[i]
        }
    }

    println(count)
}

// x를 y로 만들기 위해 2를 곱하는 최소 횟수를 구하는 함수
fun findMinimumTimes(x: Int, y: Int): Int {
    // x가 y보다 작거나 같으면 0을 반환 (x가 y보다 작거나 같으면 2를 곱할 필요가 없음)
    return if (x <= y) 0 else ceil(log2(x.toDouble() / y)).toInt()
}
