/**
 * 단어 바꾸기
 * 해결됨
 * 중간
 * 주제
 * 회사
 * 영어에는 루트 라는 개념이 있는데 , 루트 뒤에는 다른 단어가 따라와서 또 다른 긴 단어를 형성할 수 있습니다. 이 단어를 파생어 라고 부르겠습니다 . 예를 들어, 어근 "help" 뒤에 단어 가 오면 "ful"파생어를 만들 수 있습니다 "helpful".
 *
 * dictionarya 가 많은 어근 으로 구성되고 a 가 공백으로 구분된 단어로 구성된 경우 sentence문장의 모든 파생어를 문장 을 구성하는 어근 으로 바꾸세요 . 도함수를 둘 이상의 근 으로 대체할 수 있는 경우 가장 짧은 길이를 갖는 근 으로 대체합니다 .
 *
 * 교체 후 반품sentence 하세요 .
 *
 *
 */
class Solution {
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        // 어근을 길이 순으로 정렬합니다.
        val sortedDict = dictionary.sortedBy { it.length }
        // 문장을 공백으로 나누어 각 단어를 어근으로 바꿉니다.
        return sentence.split(" ").joinToString(" ") { word ->
            // 어근을 찾아 반환합니다. 없다면 원래 단어를 반환합니다.
            sortedDict.find { word.startsWith(it) } ?: word
        }
    }
}
