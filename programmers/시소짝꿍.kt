/**
 * 문제 설명
 * 어느 공원 놀이터에는 시소가 하나 설치되어 있습니다. 이 시소는 중심으로부터 2(m), 3(m), 4(m) 거리의 지점에 좌석이 하나씩 있습니다.
 * 이 시소를 두 명이 마주 보고 탄다고 할 때, 시소가 평형인 상태에서 각각에 의해 시소에 걸리는 토크의 크기가 서로 상쇄되어 완전한 균형을 이룰 수 있다면 그 두 사람을 시소 짝꿍이라고 합니다. 즉, 탑승한 사람의 무게와 시소 축과 좌석 간의 거리의 곱이 양쪽 다 같다면 시소 짝꿍이라고 할 수 있습니다.
 * 사람들의 몸무게 목록 weights이 주어질 때, 시소 짝꿍이 몇 쌍 존재하는지 구하여 return 하도록 solution 함수를 완성해주세요.
 *
 * 입출력 예
 * weights	                result
 * [100,180,360,100,270]	4
 *
 * 입출력 예 설명
 * {100, 100} 은 서로 같은 거리에 마주보고 앉으면 균형을 이룹니다.
 * {180, 360} 은 각각 4(m), 2(m) 거리에 마주보고 앉으면 균형을 이룹니다.
 * {180, 270} 은 각각 3(m), 2(m) 거리에 마주보고 앉으면 균형을 이룹니다.
 * {270, 360} 은 각각 4(m), 3(m) 거리에 마주보고 앉으면 균형을 이룹니다.
 */

class Solution {
    fun solution(weights: IntArray): Long {
        val weightCount = mutableMapOf<Double, Long>()
        var answer: Long = 0

        // 각 몸무게의 개수를 카운트
        for (weight in weights) {
            weightCount[weight.toDouble()] = weightCount.getOrDefault(weight.toDouble(), 0) + 1
        }

        // 짝꿍의 조건을 체크
        for ((weight, count) in weightCount) {
            // 같은 무게의 짝꿍
            answer += count * (count - 1) / 2 // nC2 방식으로 짝꿍 수 계산

            // 2배 무게의 짝꿍
            answer += count * weightCount.getOrDefault(weight * 2, 0)

            // 3/2배 무게의 짝꿍
            answer += count * weightCount.getOrDefault(weight * 1.5, 0)

            // 4/3배 무게의 짝꿍
            answer += count * weightCount.getOrDefault(weight * 4.0 / 3.0, 0)
        }

        return answer
    }
}
