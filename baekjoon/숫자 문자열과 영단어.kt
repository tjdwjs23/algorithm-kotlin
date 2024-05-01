/**
 * 숫자 문자열과 영단어
 * 네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
 *
 * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
 *
 * 1478 → "one4seveneight"
 * 234567 → "23four5six7"
 * 10203 → "1zerotwozero3"
 * 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
 */
fun solution(s: String): Int {
    var answer = s
    // 숫자와 영단어 매핑
    val dict = mapOf(
        "zero" to 0,
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )
    // 매핑된 숫자로 변환
    for ((k, v) in dict) {
        // replace 함수는 문자열을 변경한 새로운 문자열을 반환하므로 answer에 다시 할당해야 합니다.
        answer = answer.replace(k, v.toString())
    }
    // 문자열을 숫자로 변환
    return answer.toInt()
}