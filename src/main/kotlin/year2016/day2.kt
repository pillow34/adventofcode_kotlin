package year2016
import Question

private class keypad(val keypad: Array<Array<Char>>, val input: List<String>, start: Pair<Int, Int>, val restricted: Array<Pair<Int, Int>>){

    var index = start
    var pincode: String = ""

    fun moveup(){
        index = Pair(index.first - 1, index.second)
        if ((index.first < 0) or restricted.contains(index)) {
            index = Pair(index.first + 1, index.second)
        }
    }
    fun movedown(){
        index = Pair(index.first + 1, index.second)
        if ((index.first > keypad.size - 1) or restricted.contains(index)){
            index = Pair(index.first - 1, index.second)
        }
    }
    fun moveleft(){
        index = Pair(index.first, index.second - 1)
        if ((index.second < 0) or restricted.contains(index)){
            index = Pair(index.first, index.second + 1)
        }
    }
    fun moveright(){
        index = Pair(index.first, index.second + 1)
        if ((index.second > keypad.size - 1) or restricted.contains(index)){
            index = Pair(index.first, index.second - 1)
        }
    }

    fun moves(): String{
        for (move in this.input){
//            println(move)
            for (dir in move.toCharArray()){
//                println(index)
                if (dir == 'U'){
                    moveup()
                } else if (dir == 'D'){
                    movedown()
                } else if (dir == 'R'){
                    moveright()
                } else if (dir == 'L'){
                    moveleft()
                }
//                println(keypad[index.first][index.second])
            }
            pincode += keypad[index.first][index.second]
        }
        return pincode
    }
}

private fun part1(input: CharSequence) : String {
    val keys = arrayOf(arrayOf('1','2','3'), arrayOf('4','5','6'), arrayOf('7','8','9'))
    var start = Pair(1, 1)
    var restricted: Array<Pair<Int, Int>> = arrayOf(Pair(-1,-1))
    var k = keypad(keys, input.split("\n"), start, restricted)
    return k.moves().toString()
}

private fun part2(input: CharSequence) : String {
    val keys = arrayOf(arrayOf('0','0','1','0','0'), arrayOf('0','2','3','4','0'), arrayOf('5','6','7','8','9'), arrayOf('0','A','B','C','0'),arrayOf('0','0','D','0','0'))
    var start = Pair(2, 0)
    var restricted: Array<Pair<Int, Int>> = arrayOf(Pair(0,0),Pair(0,1),Pair(0,3),Pair(0,4),Pair(1,0),Pair(1,4),Pair(3,0),Pair(3,4),Pair(4,0),Pair(4,1),Pair(4,3),Pair(4,4))
    var k = keypad(keys, input.split("\n"), start, restricted)
    return k.moves().toString()
}


fun main() {

    val input = Question(2016, 2).questionInput.trimEnd()
//    println(input)
    println(part1(input))
    println(part2(input))

}
