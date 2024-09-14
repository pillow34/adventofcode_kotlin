package year2023
import Question
import kotlin.math.max

private fun parsegame(gamestring:String): List<Map<String, Int>> {
    var gamelist:MutableList<Map<String, Int>> = mutableListOf()
    for (game in gamestring.trim().split("; ")) {
        var g = game.split(", ").map { it.split(" ")[1] to it.split(" ")[0].toInt() }.associate { it }
        gamelist.add(g)
    }
    return gamelist
}

private fun checkvalidity(check: Map<String, Int>, input: Map<String, Int?>): Boolean {
    val valid:Boolean = false
    return if ((input.get("red") ?: 0) > (check.get("red") ?: 0)) {
        valid
    } else if ((input.get("green") ?: 0) > (check.get("green") ?: 0)) {
        valid
    } else if ((input.get("blue") ?: 0) > (check.get("blue") ?: 0)) {
        valid
    } else {
        true
    }

}

private fun idealreq(input: List<Map<String, Int?>>): Map<String, Int> {
    var idealgame: MutableMap<String, Int> = mutableMapOf("red" to 0, "blue" to 0, "green" to 0)
    for (game in input){
        idealgame["red"] = max(idealgame["red"]!!, game.get("red")?:0)
        idealgame["green"] = max(idealgame["green"]!!, game.get("green")?:0)
        idealgame["blue"] = max(idealgame["blue"]!!, game.get("blue")?:0)
    }
    return idealgame
}

private fun part1(validity:Map<String, Int>, input: String): Int {
    var sum = 0
    val itr = input.split("\n")
    for(line in itr) {
        var gameid = line.split(": ")[0].replace("Game ","").toInt()
//        println(line)
        val gamelist = parsegame(line.split(": ")[1])
//        println(gamelist)
        var gamevalidity:Array<Boolean> = arrayOf()
        for(game in gamelist){
            gamevalidity += checkvalidity(validity, game)
        }
        if (gamevalidity.all { it.equals(true) }){
            sum += gameid
        }
    }

    return sum
}

private fun part2(input: String): Int {
    var product = 1
    var sum = 0
    val itr = input.split("\n")
    for(line in itr) {
        var gameid = line.split(": ")[0].replace("Game ","").toInt()
//        println(line)
        val gamelist = parsegame(line.split(": ")[1])
//        println(gamelist)
        var gamevalidity:Array<Boolean> = arrayOf()
        var idealgame = idealreq(gamelist)
//        println(idealgame)
        sum += idealgame.values.fold(1) { acc, num -> acc * num }
    }
    return sum
}

fun main() {

    val input = Question(2023, 2).questionInput.trimEnd()
//    println(input)
    val valididity:Map<String, Int> = mapOf("red" to 12, "green" to 13, "blue" to 14)
    println(part1(valididity, input))
    println(part2(input))

}