package algorithms.sorting.heap_sort


fun main() {
    val numberOfElements = 100
    var originalArray = (0..numberOfElements).toList().shuffled().toTypedArray()


    println("#### SORTING THE ARRAY #####")
    var sortedArray = HeapSort.execute(originalArray)
    println("### SORTING FINISHED ###")
    println("#### VALIDATING #####")
    for (i in 0..numberOfElements) {
        if (sortedArray[i] != i) {
            println("NOT VALID")
            return
        }
    }
    println("#### VALIDATION FINISHED #####")
}