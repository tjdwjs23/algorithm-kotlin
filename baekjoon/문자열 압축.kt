/**
 * 설명
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단 반복횟수가 1인 경우 생략합니다.

 * 입력
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

 * 출력
 * 첫 줄에 압축된 문자열을 출력한다.
 */

fun main() = System.`in`.bufferedReader().run {
    val input = readLine()!! // 문자열 입력 받기
    val result = input.foldIndexed(StringBuilder()) { index, acc, current ->
        // 마지막 문자 또는 현재 문자가 다음 문자와 다를 때 처리
        if (index == input.length - 1 || current != input[index + 1]) {
            acc.append(current) // 현재 문자를 누적
            // 연속된 문자열의 길이 계산 (현재 인덱스에서 이전에 같은 문자가 마지막으로 나타난 위치를 뺌)
            val length = index - acc.lastIndexOf(current.toString()) + 1
            if (length > 1) acc.append(length) // 연속 길이가 1보다 크면 길이도 누적
        }
        acc // 누적된 결과 반환
    }
    
    println(result.toString()) // 결과 출력
}
