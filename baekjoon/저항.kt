/**
 * 전자 제품에는 저항이 들어간다. 저항은 색 3개를 이용해서 그 저항이 몇 옴인지 나타낸다. 처음 색 2개는 저항의 값이고, 마지막 색은 곱해야 하는 값이다.
 * 저항의 값은 다음 표를 이용해서 구한다.
 * 색	값	곱
 * black	0	1
 * brown	1	10
 * red	2	100
 * orange	3	1,000
 * yellow	4	10,000
 * green	5	100,000
 * blue	6	1,000,000
 * violet	7	10,000,000
 * grey	8	100,000,000
 * white	9	1,000,000,000
 *
 * 입력
 * 첫째 줄에 첫 번째 색, 둘째 줄에 두 번째 색, 셋째 줄에 세 번째 색이 주어진다. 위의 표에 있는 색만 입력으로 주어진다.
 *
 * 출력
 * 입력으로 주어진 저항의 저항값을 계산하여 첫째 줄에 출력한다.
 */
fun main() = System.`in`.bufferedReader().run {
    // 사용자로부터 3개의 색깔 이름을 입력받아 처리
    Array(3) { readLine()!! }.mapIndexed { index, color ->
        when (color) {
            "black" -> 0
            "brown" -> 1
            "red" -> 2
            "orange" -> 3
            "yellow" -> 4
            "green" -> 5
            "blue" -> 6
            "violet" -> 7
            "grey" -> 8
            "white" -> 9
        }.let { value ->
            // 첫 번째 색깔은 10을 곱하여, 두 번째 색깔은 그대로 사용하여, 세 번째 색깔은 10의 value 제곱을 계산
            if (index == 0) value * 10L
            else if (index == 1) value.toLong()
            else Math.pow(10.0, value.toDouble()).toLong()
        }
    }.let { (firstValue, secondValue, multiplier) ->
        // 계산된 값들을 사용하여 최종 저항값을 계산하고 출력
        println((firstValue + secondValue) * multiplier)
    }
}
