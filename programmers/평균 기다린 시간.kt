/**
 * Average Waiting Time
 * There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:
 *
 * arrivali is the arrival time of the ith customer. The arrival times are sorted in non-decreasing order.
 * timei is the time needed to prepare the order of the ith customer.
 * When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle. The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one customer at a time. The chef prepares food for customers in the order they were given in the input.
 *
 * Return the average waiting time of all customers. Solutions within 10-5 from the actual answer are considered accepted.
 *
 */

class Solution {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var totalTime = 0
        var totalWaitingTime = 0L

        // 고객이 도착한 시간과 요리하는 시간을 순회하며 계산합니다.
        for ((arrival, processing) in customers) {
            // 요리 시작 시간을 계산합니다.
            totalTime = maxOf(totalTime, arrival)
            // 요리가 끝나는 시간을 계산합니다.
            totalTime += processing
            // 고객이 기다린 시간을 더합니다.
            totalWaitingTime += totalTime - arrival
        }

        // 모든 고객의 평균 대기 시간을 반환합니다.
        return totalWaitingTime.toDouble() / customers.size
    }
}
