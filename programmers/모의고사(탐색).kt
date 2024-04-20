/**
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */

fun solution(answers: IntArray): IntArray {
    // 각 수포자의 찍기 패턴을 배열로 정의
    val firstPattern = intArrayOf(1, 2, 3, 4, 5)
    val secondPattern = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val thirdPattern = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    // 수포자들의 패턴을 리스트에 저장
    val patterns = listOf(firstPattern, secondPattern, thirdPattern)

    // 각 수포자가 몇 개의 문제를 맞혔는지 저장할 리스트
    // mapIndexed 함수를 사용하여 answers 배열의 각 원소와 패턴을 비교
    val scores = patterns.map { pattern ->
        // answers 배열의 각 원소에 대해 정답여부를 확인하고 맞힌 개수를 계산
        answers.filterIndexed { index, answer ->
            answer == pattern[index % pattern.size]
        }.size
    }

    // 가장 많이 맞힌 문제 수를 찾음
    val maxScore = scores.maxOrNull()

    // 가장 많이 맞힌 문제 수와 같은 점수를 받은 수포자의 인덱스(1부터 시작)를 찾아서 반환
    return scores.mapIndexedNotNull { index, score ->
        if (score == maxScore) index + 1 else null
    }.toIntArray()
}
