/**
* 설명
* 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
* 
* 입력
* 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
* 문자열의 길이는 100을 넘지 않는다.
* 
* 출력
* 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
*/

fun main() = System.`in`.bufferedReader().run {
    // 입력 받은 두 문자열 s와 t를 공백을 기준으로 분리해서 저장
    val (s, t) = readLine().split(' ')
    // 각 문자와 타겟 문자 사이의 거리를 저장할 배열 초기화
    val answer = IntArray(s.length) { 0 }

    // 왼쪽에서 오른쪽으로 거리 계산
    var distance = Int.MAX_VALUE
    // 문자열 s의 각 문자를 순회하며 거리 계산
    s.forEachIndexed { index, c ->
        if (c == t[0]) distance = 0 // 현재 문자가 타겟 문자와 같으면 거리는 0
        else if (distance != Int.MAX_VALUE) distance++ // 그렇지 않고 이전에 타겟 문자를 찾았다면 거리 1 증가
        
        answer[index] = distance // 계산된 거리를 결과 배열에 저장
    }

    // 오른쪽에서 왼쪽으로 거리 계산 및 업데이트
    distance = Int.MAX_VALUE
    // 문자열 s를 뒤에서부터 순회하며 거리 계산
    s.indices.reversed().forEach { index ->
        if (s[index] == t[0]) distance = 0 // 현재 문자가 타겟 문자와 같으면 거리는 0
        else if (distance != Int.MAX_VALUE) distance++ // 그렇지 않고 이전에 타겟 문자를 찾았다면 거리 1 증가
        
        // 왼쪽에서 계산한 값과 비교하여 더 작은 값으로 업데이트
        answer[index] = minOf(answer[index], distance)
    }

    // 계산된 거리를 공백으로 구분하여 출력
    println(answer.joinToString(" "))
}
