/**
 * 두 배
 * 길이 N인 양의 정수열 A1, . . . , AN이 주어진다. 이 수열을 오름차순으로 만들려 한다. 수열 A1, . . . , AN이
 * 오름차순이라는 것은, 각 i (1 ≤ i ≤ N − 1)에 대해 Ai ≤ Ai+1이라는 것이다.
 * 수열 A를 오름차순으로 만들기 위해, 수열 A에 다음 연산을 몇 번이든 반복해서 적용할 수 있다.
 * • 어떤 i (1 ≤ i ≤ N)에 대해 Ai에 2를 곱한다.
 * 연산을 최소 횟수로 적용해서 A를 오름차순으로 만들고 싶다. 이때, 최소 횟수를 구하라.
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
fun findMinimumTimes(x: Int, y: Int): Int = if (x <= y) 0 else ceil(log2(x.toDouble() / y)).toInt()
