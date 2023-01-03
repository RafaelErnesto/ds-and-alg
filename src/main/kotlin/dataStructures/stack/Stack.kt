package dataStructures.stack

class Stack<E> {
    private val stack: MutableList<E> = mutableListOf<E>()

    fun push(element: E) {
        stack.add(element)
    }

    fun pop(): E {
        if(stack.size == 0) throw RuntimeException("The stack is empty")
        return stack.removeAt(stack.lastIndex)
    }

    fun contains(element: E): Boolean {
        return stack.contains(element)
    }

    fun size(): Int {
        return stack.size
    }
}