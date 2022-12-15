package recursion

// tail recursion that can use tail call optimization
tailrec fun sumOfNumbers(n: Int, total: Int = 0): Int {
    if(n <= 0) {
        return total
    }
    return sumOfNumbers(n-1, total + n)
}


fun main(){
    println(sumOfNumbers(50000000))// does not throw StackOverFlow exception
}