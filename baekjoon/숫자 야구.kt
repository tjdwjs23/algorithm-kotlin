/**
 * 정보문화진흥원 정보 영재 동아리에서 동아리 활동을 하던 영수와 민혁이는 쉬는 시간을 틈타 숫자야구 게임을 하기로 했다.
 *
 * 영수는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세 자리 수를 마음속으로 생각한다. (예: 324)
 * 민혁이는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세 자리 수를 영수에게 묻는다. (예: 123)
 * 민혁이가 말한 세 자리 수에 있는 숫자들 중 하나가 영수의 세 자리 수의 동일한 자리에 위치하면 스트라이크 한 번으로 센다. 숫자가 영수의 세 자리 수에 있긴 하나 다른 자리에 위치하면 볼 한 번으로 센다.
 *
 * 영수는 민혁이가 말한 수가 몇 스트라이크 몇 볼인지를 답해준다.
 * 민혁이가 영수의 세 자리 수를 정확하게 맞추어 3 스트라이크가 되면 게임이 끝난다. 아니라면 민혁이는 새로운 수를 생각해 다시 영수에게 묻는다.
 * 현재 민혁이와 영수는 게임을 하고 있는 도중에 있다. 민혁이가 영수에게 어떤 수들을 물어보았는지, 그리고 각각의 물음에 영수가 어떤 대답을 했는지가 입력으로 주어진다. 이 입력을 바탕으로 여러분은 영수가 생각하고 있을 가능성이 있는 수가 총 몇 개인지를 알아맞혀야 한다.
 *
 * 영수는 동아리의 규율을 잘 따르는 착한 아이라 민혁이의 물음에 곧이곧대로 정직하게 답한다. 그러므로 영수의 답들에는 모순이 없다.
 *
 * 민혁이의 물음들과 각각의 물음에 대한 영수의 답이 입력으로 주어질 때 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력하는 프로그램을 작성하시오.
 */

// Baseball 데이터 클래스 정의: 숫자(num), 스트라이크 수(strike), 볼 수(ball)를 포함합니다.
data class Baseball(val num: String, val strike: Int, val ball: Int)

fun main() = System.`in`.bufferedReader().run {
    // 입력 받은 야구 게임 결과 리스트 생성
    val baseballs = List(readLine()!!.toInt()) {
        readLine()!!.split(" ").let { (num, strike, ball) ->
            Baseball(num, strike.toInt(), ball.toInt())
        }
    }

    // 가능한 숫자 조합 필터링 (123부터 987까지, 각 자리 숫자가 모두 다르고 0을 포함하지 않는 경우)
    val validNumbers = (123..987).map { it.toString() }
        .filter { it.toSet().size == 3 && !it.contains('0') }

    // 주어진 야구 게임 결과와 일치하는 숫자 조합의 개수 계산
    val count = validNumbers.count { num ->
        baseballs.all { baseball ->
            val (strike, ball) = calculateStrikeAndBall(num, baseball.num)
            strike == baseball.strike && ball == baseball.ball
        }
    }

    // 계산된 숫자 조합의 개수 출력
    println(count)
}

// 주어진 두 숫자 사이의 스트라이크와 볼 개수 계산 함수
private fun calculateStrikeAndBall(number: String, guess: String): Pair<Int, Int> {
    // init
    var strike = 0
    var ball = 0
    // 각 자리별로 스트라이크와 볼 여부를 판단하여 개수를 계산
    for (i in number.indices) {
        if (number[i] == guess[i]) {
            strike++ // 같은 위치의 숫자가 같으면 스트라이크
        } else if (number.contains(guess[i])) {
            ball++ // 다른 위치에 같은 숫자가 있으면 볼
        }
    }
    return Pair(strike, ball) // 계산된 스트라이크와 볼 개수를 반환
}
