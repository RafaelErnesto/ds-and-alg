package dataStructures.stack

enum class Symbols {
    OPEN_PARENTHESIS {
        override fun value() = "("
        override fun matchWith(symbol: String): Boolean = symbol == CLOSED_PARENTHESIS.value()
    },
    CLOSED_PARENTHESIS {
        override fun value() = ")"
        override fun matchWith(symbol: String): Boolean  = symbol == OPEN_PARENTHESIS.value()
    };

    abstract fun value(): String
    abstract fun matchWith(symbol: String):Boolean
}

class ParenthesisMatching {

    companion object {
        fun isValid(expression: String): Boolean {
            val stack = Stack<String>()
            for (letter in expression.split("")) {
                if (letter == Symbols.OPEN_PARENTHESIS.value()) {
                    stack.push(letter)
                }
                if (letter == Symbols.CLOSED_PARENTHESIS.value() && !Symbols.CLOSED_PARENTHESIS.matchWith(stack.pop())) {
                    return false
                }
            }
            return stack.size() == 0
        }
    }
}