package year2024
import Question
import kotlin.math.abs

private fun common(input: String): Pair<MutableList<Int>, MutableList<Int>> {
    var firstlist = mutableListOf<Int>()
    var secondlist = mutableListOf<Int>()
    for (line in input.split("\n")) {
//        println("$line")
        var firstDigit = line.split("   ")[0]
        firstlist.add(firstDigit.toInt())
        var lastDigit = line.split("   ")[1]
        secondlist.add(lastDigit.toInt())
//        sum = sum + abs(firstDigit.toInt() - lastDigit.toInt())
//        println(firstDigit)
//        println(lastDigit)
    }
    firstlist.sort()
    secondlist.sort()
    return Pair(firstlist, secondlist)
}

private fun part1(input: String): Int {
    var sum = 0
    val lists = common(input)
    var firstlist = lists.first
    var secondlist = lists.second
    if (firstlist.size == secondlist.size) {
        for (i in 0..(firstlist.size-1)) {
            sum += abs(firstlist[i] - secondlist[i])
        }
    }
    return sum
}

private fun part2(input: String): Int {
    var sum = 0
    val lists = common(input)
    var firstlist = lists.first
    var secondlist = lists.second
    if (firstlist.size == secondlist.size) {
        val frequencies = secondlist.groupingBy { it }.eachCount()
        for (i in 0..(firstlist.size-1)) {
            sum += (frequencies[firstlist[i]]?.let { firstlist[i] * it } ?: 0)
//            sum += abs(firstlist[i] - secondlist[i])
        }
    }
    return sum
}

fun main() {

    val input = Question(2024, 1).questionInput.trimEnd()
//    println(input)
    println(part1(input))
    println(part2(input))

}