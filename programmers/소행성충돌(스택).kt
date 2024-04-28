/**
 * asteroids소행성을 연속적으로 나타내는 정수 배열이 제공됩니다 .
 *
 * 각 소행성에 대해 절대값은 크기를 나타내고 부호는 방향을 나타냅니다(양수는 오른쪽, 음수는 왼쪽을 의미). 각 소행성은 같은 속도로 움직입니다.
 *
 * 모든 충돌 후 소행성의 상태를 알아보세요. 두 소행성이 만나면 작은 소행성이 폭발합니다. 둘 다 같은 크기이면 둘 다 폭발합니다. 같은 방향으로 움직이는 두 소행성은 결코 만날 수 없습니다.
 */

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        // 스택을 사용하여 이미 통과한 소행성을 추적합니다.
        val stack = ArrayDeque<Int>()

        // 모든 소행성에 대해 반복합니다.
        asteroids.forEach { asteroid ->
            when {
                // 현재 소행성이 양수이면, 스택에 추가합니다. 양수 소행성은 오른쪽으로 이동합니다.
                asteroid > 0 -> stack.add(asteroid)
                // 스택이 비어있거나, 스택의 마지막 소행성이 음수일 때, 현재 소행성을 스택에 추가합니다.
                // 음수 소행성은 왼쪽으로 이동하므로, 이전에 양수 소행성과 충돌하지 않습니다.
                stack.isEmpty() || stack.last() < 0 -> stack.add(asteroid)
                else -> {
                    // 현재 소행성이 음수이고, 스택의 마지막 소행성이 양수인 경우 충돌이 발생합니다.
                    // 스택의 마지막 소행성이 현재 소행성의 크기보다 작은 동안 스택에서 소행성을 제거합니다.
                    while (stack.isNotEmpty() && stack.last() > 0 && stack.last() < Math.abs(asteroid)) {
                        stack.removeLast()
                    }
                    // 충돌 후, 두 소행성의 크기가 같으면, 스택에서 마지막 소행성을 제거합니다.
                    if (stack.isNotEmpty() && stack.last() == Math.abs(asteroid)) {
                        stack.removeLast()
                    } else if (stack.isEmpty() || stack.last() < 0) {
                        // 스택이 비어있거나 마지막 소행성이 음수일 경우, 현재 소행성을 스택에 추가합니다.
                        // 이 경우에는 현재 소행성이 전진할 수 있는 길이 열립니다.
                        stack.add(asteroid)
                    }
                }
            }
        }

        // 스택에 남아있는 소행성들을 배열로 변환하여 반환합니다.
        return stack.toIntArray()
    }
}

