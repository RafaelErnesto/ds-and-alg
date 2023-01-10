package algorithms.sorting.heap_sort

fun main() {
    val heap = Heap()
    for (i in 1..10){
        heap.add(i)
    }

    println("#### PRINT ORIGINAL HEAP ######")
    heap.print()
    println("#### REMOVE ELEMENT FROM HEAP ######")
    heap.remove()
    println("#### PRINT HEAP AFTER REMOVAL ######")
    heap.print()
}