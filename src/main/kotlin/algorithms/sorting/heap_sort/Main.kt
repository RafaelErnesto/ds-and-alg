package algorithms.sorting.heap_sort

fun main() {
    var originalArray = (1..100).toList().shuffled().toTypedArray()
    println("### ORIGINAL ARRAY ###")
    for (i in originalArray) println(i)
    println("### SORTING ARRAY ###")
    var sortedArray = HeapUtils.heapSort(originalArray)
    for (i in sortedArray) println(i)
}