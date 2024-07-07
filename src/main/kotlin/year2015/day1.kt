package year2015
import Question

private fun part1(input: String): Int {
    val ans = input.map { it.toString().replace("(", "1").replace(")", "-1").toInt() }.sum()
    return ans
}


private fun part2(input: String): Int {
    val accumulatedSums = input.map { it.toString().replace("(", "1").replace(")", "-1").toInt() }
        .runningFold(0) { acc, value -> acc + value }
        .drop(1)
    return accumulatedSums.indexOf(-1) + 1
}


fun main() {

    val input = Question(2015, 1).questionInput.trimEnd()
//    println(input)
    println(part1(input))
    println(part2(input))

}