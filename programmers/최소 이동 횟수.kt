/**
 * 모든 사람이 앉을 수 있는 최소 이동 횟수
 * 방에는 n좌석과 학생이 있습니다 . 좌석 의 위치 가 길이인 n배열이 제공됩니다 . 또한 학생 의 위치 인 length 배열이 제공됩니다 .seatsnseats[i]ithstudentsnstudents[j]jth
 *
 * 다음 동작은 횟수 제한 없이 수행할 수 있습니다.
 *
 * 학생 의 위치를 높이거나 낮춥니다 (예: 학생을 위치에서   또는 으로 이동 합니다 ).
 * 두 명의 학생이 같은 자리에 앉지 않도록 각 학생을 한 자리로 이동하는 데 필요한 최소 이동 횟수를 반환합니다 .
 *
 * 처음에는 같은 위치에 여러 좌석이나 학생이 있을 수 있다는 점에 유의하세요 .
 *
 */

class Solution {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort()
        var answer = 0
        // 의자수를 반복하면서 학생수를 빼준 값을 절대값으로 더해준다.
        seats.forEachIndexed { index, i ->
            answer += (students[index] - i).absoluteValue
        }
        return answer
    }
}
