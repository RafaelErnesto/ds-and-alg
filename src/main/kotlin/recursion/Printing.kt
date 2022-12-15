package recursion

fun printFromNToZero(n: Int) {
    println(n)
    if(n == 0) {
        return
    }
    printFromNToZero(n-1)
}

fun printFromZeroToN(n: Int) {
    if(n < 0) {
        return
    }
    printFromZeroToN(n-1)
    println(n)
}

fun main(){
    printFromNToZero(100)
    printFromZeroToN(100)
}