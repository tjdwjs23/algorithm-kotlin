/**
 * head연결된 목록이 주어지면 목록 끝에서 노드를 제거하고 해당 노드의 헤드를 반환합니다.
 */

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var first = head
        var second = head

        // 첫 번째 포인터를 n번째 노드까지 이동
        for (i in 0 until n) {
            first = first?.next
        }

        // 두 번째 포인터가 마지막 노드를 가리키도록 이동
        if (first == null) {
            // 리스트의 길이가 n이고, 삭제할 노드가 첫 번째 노드인 경우
            return head?.next
        }
        while (first?.next != null) {
            first = first.next
            second = second?.next
        }

        // 두 번째 포인터가 삭제할 노드를 가리키므로, 해당 노드를 삭제
        second?.next = second?.next?.next

        return head
    }

}
