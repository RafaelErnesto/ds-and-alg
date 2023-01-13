package algorithms.sorting.heap_sort

fun main() {
    var originalArray = (1..10).toList().shuffled().toTypedArray()
    println("### ORIGINAL ARRAY ###")
    for (i in originalArray) println(i)

    var sortedArray = HeapSort.heapSort(originalArray)
    println("### SORTED ARRAY ###")
    for (i in sortedArray) println(i)
}