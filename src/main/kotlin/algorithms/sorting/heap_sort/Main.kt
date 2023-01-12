package algorithms.sorting.heap_sort

fun main() {
    var sortedArray = HeapUtils.heapSort(arrayOf(1,2,3,5,5,4,6,11,20,10,10,8,9,7))
    for (i in sortedArray) println(i)
}