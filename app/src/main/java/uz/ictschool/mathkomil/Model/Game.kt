package uz.ictschool.mathkomil.Model

class Game {
    fun getRandom(mode: String): Pair<String, String> {
        var first = 0
        var second = 0
        var correct_answer = 0
        when (mode) {
            "+" -> {
                first = (1..10).random()
                second = (1..10).random()
                correct_answer = first + second
            }

            "-" -> {
                first = (1..50).random()
                second = (1..50).random()
                correct_answer = first - second
            }

            "*" -> {
                first = (1..100).random()
                second = (1..100).random()
                correct_answer = first * second
            }
            "/" -> {
                first = (1..100).random()
                second = (1..100).random()
                correct_answer = first / second
            }
        }
    
        if (mode == "/") {
            while (first % second != 0) {
                when (mode) {
                    "/" -> {
                        first = (1..100).random()
                        second = (1..100).random()
                    }
                }
            }
        }
        return Pair("$first $mode $second = ${solve(first, second, mode)}", "$correct_answer")
    }

    private fun solve(first: Int, second: Int, mode: String): String {
        return when (mode) {
            "*" -> "${first * second}"
            "/" -> "${first / second}"
            "+" -> "${first + second}"
            "-" -> "${first - second}"
            else -> {
                "Error"
            }
        }
    }
}
