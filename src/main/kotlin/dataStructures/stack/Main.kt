package dataStructures.stack

fun main(){
    val integerStack = Stack<Int>()
    for (i in 1..100){
        integerStack.push(i)
    }

    println("#### STACK SIZE #####")
    println(integerStack.size())
}