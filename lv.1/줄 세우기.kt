/**
 * N명의 학생들을 키 순서대로 줄을 세우려고 한다. 각 학생의 키를 직접 재서 정렬하면 간단하겠지만, 마땅한 방법이 없어서 두 학생의 키를 비교하는 방법을 사용하기로 하였다. 그나마도 모든 학생들을 다 비교해 본 것이 아니고, 일부 학생들의 키만을 비교해 보았다.
 * 일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램을 작성하시오.
 */

fun main() = System.`in`.bufferedReader().run {
    // N과 M을 입력받음. N은 정점의 개수, M은 간선의 개수.
    val (N, M) = readLine().split(' ').map { it.toInt() }
    // 방향 그래프를 나타내는 인접 리스트
    val graph = List(N + 1) { mutableListOf<Int>() }
    // 각 정점의 진입 차수를 저장하는 배열
    val indegree = IntArray(N + 1)
    
    // M번 반복하여 간선 정보를 입력받고 그래프 및 진입 차수 배열을 갱신
    repeat(M) {
        readLine().split(' ').map { it.toInt() }.also { (S, E) ->
            graph[S].add(E) // S에서 E로 가는 간선 추가
            indegree[E]++ // E의 진입 차수 증가
        }
    }
    
    // 진입 차수가 0인 정점들을 찾아 큐에 추가
    val queue = ArrayDeque<Int>().apply {
        indegree.indices
            .filter { indegree[it] == 0 && it != 0  // 진입 차수가 0인 정점을 필터링
            .forEach { this.addLast(it) } // 해당 정점을 큐에 추가
    }
    
    // 위상 정렬의 결과를 저장할 리스트
    val result = mutableListOf<Int>()
    // 큐가 빌 때까지 반복
    while(queue.isNotEmpty()) {
        val current = queue.removeFirst() // 큐에서 정점을 하나 꺼냄
        result.add(current) // 결과 리스트에 추가
        
        // 현재 정점에서 나가는 간선을 제거하며 진입 차수 갱신
        graph[current].forEach { next ->
            if (--indegree[next] == 0) { // 진입 차수가 0이 되면
                queue.addLast(next) // 해당 정점을 큐에 추가
            }
        }
    }
    
    // 결과 리스트의 크기가 N과 같다면 모든 정점을 방문한 것이므로 결과 출력
    // 그렇지 않다면 사이클이 존재하는 것으로 간주하고 메시지 출력
    if (result.size == N) println(result.joinToString(" "))
    else println("사이클이 존재하여 위상 정렬을 완료할 수 없습니다.")
}
