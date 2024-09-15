package year2016
import Question
import kotlin.math.abs

private class turtle(val startdirection: String, val startx: Int, val starty: Int){

    var enddirection = startdirection
    var x = startx
    var y = starty
    var visited: Array<Pair<Int, Int>> = arrayOf(Pair(startx, starty))

    fun move(direction:String, steps:Int) {
        if (enddirection == "U") {
            if (direction == "R"){
                enddirection = "R"
                for (step in 1..steps){
                    x += 1
                    visited += Pair(x, y)
                }
            } else if (direction == "L"){
                enddirection = "L"
                for (step in 1..steps){
                    x -= 1
                    visited += Pair(x, y)
                }
            }
        } else if (enddirection == "R") {
            if (direction == "R"){
                enddirection = "D"
                for (step in 1..steps){
                    y -= 1
                    visited += Pair(x, y)
                }
            } else if (direction == "L"){
                enddirection = "U"
                for (step in 1..steps){
                    y += 1
                    visited += Pair(x, y)
                }
            }
        } else if (enddirection == "D") {
            if (direction == "R"){
                enddirection = "L"
                for (step in 1..steps){
                    x -= 1
                    visited += Pair(x, y)
                }
            } else if (direction == "L"){
                enddirection = "R"
                for (step in 1..steps){
                    x += 1
                    visited += Pair(x, y)
                }
            }
        } else if (enddirection == "L") {
            if (direction == "R") {
                enddirection = "U"
                for (step in 1..steps){
                    y += 1
                    visited += Pair(x, y)
                }
            } else if (direction == "L") {
                enddirection = "D"
                for (step in 1..steps){
                    y -= 1
                    visited += Pair(x, y)
                }
            }
        }
    }

    fun taxidistance():Int {
        return abs((y - starty) + (x - startx))
    }

}

private fun part1(input: CharSequence) :Int {
    var t = turtle("U", 0, 0)
    for (a in input.split(",")) {
        t.move(a.filter { it.isLetter() }, a.filter { it.isDigit() }.toInt())
    }

    return t.taxidistance()
}

private fun part2(input: CharSequence) :Int {
    var t = turtle("U", 0, 0)
    var factory = Pair(0, 0)
    for (a in input.split(",")) {
        t.move(a.filter { it.isLetter() }, a.filter { it.isDigit() }.toInt())
    }
    for (place in t.visited) {
        if (t.visited.indexOfFirst { it == place } != t.visited.indexOfLast { it == place }) {
            factory = place
            break
        }
    }
    return abs(factory.first) + abs(factory.second)
}


fun main() {

    val input = Question(2016, 1).questionInput.trimEnd()
//    println(input)
    println(part1(input))
    println(part2(input))

}
