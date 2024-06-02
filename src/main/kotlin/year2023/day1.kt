package year2023
import Question
import java.util.Dictionary

fun part1(input: String): Int {
    var sum = 0
    for (line in input.split("\n")) {
//        println("$line")
        var firstDigit = line.first { it.isDigit() }
        var lastDigit = line.last { it.isDigit() }
//        println(firstDigit)
//        println(lastDigit)
        sum += "$firstDigit$lastDigit".toInt()
    }
    return sum
}

fun part2(input: String): Int {

    val nums = mapOf(
        "one" to "one1one",
        "two" to "two2two",
        "three" to "three3three",
        "four" to "four4four",
        "five" to "five5five",
        "six" to "six6six",
        "seven" to "seven7seven",
        "eight" to "eight8eight",
        "nine" to "nine9nine"
    )
    var newpinut = input
    for (number in nums){
//        println(number)
        newpinut = newpinut.replace(oldValue = number.key, newValue = number.value)
    }
    var sum = 0
    for (line in newpinut.split("\n")) {
//        println("$line")
        var firstDigit = line.first { it.isDigit() }
        var lastDigit = line.last { it.isDigit() }
//        println(firstDigit)
//        println(lastDigit)
        sum += "$firstDigit$lastDigit".toInt()
    }
    return sum
}

fun main() {

    val input = Question(2023, 1).questionInput.trimEnd()
//    println(input)
    println(part1(input))
    println(part2(input))

}