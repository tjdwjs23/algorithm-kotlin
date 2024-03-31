/**
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 */

fun main() = System.`in`.bufferedReader().run {
    // 소수 찾을 범위를 입력받습니다 M~N
    val (M, N) = readLine().split(" ").map { it.toInt() }
    // 소수 판별을 위한 Boolean 배열을 초기화합니다. 모든 값을 true로 설정하고, 0과 1은 소수가 아니므로 false로 설정합니다.
    val prime = BooleanArray(N + 1) { it > 1 }

    // 에라토스테네스의 체 알고리즘을 사용하여 소수를 찾습니다.
    for (i in 2..sqrt(N.toDouble()).toInt()) {
        // 현재 숫자 i가 소수가 아닌 경우, 다음 숫자로 넘어갑니다.
        if (!prime[i]) continue
         // i의 배수를 찾아 소수가 아니라고 표시합니다. i*i부터 시작하여 N까지 i씩 증가시키며 반복합니다.
        for (j in i * i..N step i) prime[j] = false
    }
    
    // M부터 N까지의 숫자 중 소수를 출력합니다.
    (M..N).forEach { if (prime[it]) println(it) }
}
