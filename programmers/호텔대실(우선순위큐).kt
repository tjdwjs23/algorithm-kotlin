/**
 * 호텔을 운영 중인 코니는 최소한의 객실만을 사용하여 예약 손님들을 받으려고 합니다. 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 다음 손님들이 사용할 수 있습니다.
 * 예약 시각이 문자열 형태로 담긴 2차원 배열 book_time이 매개변수로 주어질 때, 코니에게 필요한 최소 객실의 수를 return 하는 solution 함수를 완성해주세요.
 */


class Solution {
    // 주어진 예약 시간들을 기반으로 필요한 회의실의 최소 개수를 반환하는 함수
    fun solution(book_time: Array<Array<String>>): Int {
        var answer = 0 // 필요한 회의실의 최소 개수를 저장할 변수
        val pq = PriorityQueue<Int>() // 종료 시간을 저장할 우선순위 큐

        // 예약 시간을 시작 시간을 기준으로 정렬하고, 시작 시간이 같다면 종료 시간을 기준으로 정렬
        book_time.sortWith(compareBy({ it[0] }, { it[1] }))
        
        // 각 예약 시간에 대해 반복
        book_time.forEach { book ->
            val start = getTime(book[0]) // 시작 시간을 분으로 변환
            val end = getTime(book[1]) + 10 // 종료 시간을 분으로 변환하고, 여분의 시간 10분 추가

            // 우선순위 큐가 비어있거나 현재 예약의 시작 시간이 큐의 가장 작은 종료 시간보다 작은 경우
            if (pq.isEmpty() || pq.peek() > start) {
                pq.add(end) // 새로운 회의실이 필요하므로 종료 시간을 큐에 추가
            } else {
                pq.poll() // 가장 먼저 끝나는 회의실을 재사용하므로 큐에서 제거
                pq.add(end) // 현재 회의의 종료 시간을 큐에 추가
            }
            // 현재 필요한 회의실의 수와 최대 필요했던 회의실의 수 중 더 큰 값을 answer에 저장
            answer = answer.coerceAtLeast(pq.size)
        }
        // 필요한 회의실의 최소 개수 반환
        return answer
    }

    // 시간 문자열을 받아 분으로 변환하는 함수
    private fun getTime(s: String) = s.split(":").let { it[0].toInt() * 60 + it[1].toInt() }
}
