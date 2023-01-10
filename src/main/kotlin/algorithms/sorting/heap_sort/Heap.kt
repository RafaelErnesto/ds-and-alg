package algorithms.sorting.heap_sort

class Heap {
    var data = mutableListOf<Int>()

    fun add(element: Int) {
        data.add(element)
        balance()
    }

    fun print() {
        data.forEach { element -> println(element) }
    }

    fun remove() {
        if (data.size == 0) return

        if (data.size == 1) data.removeAt(0)

        data[0] = data.last()
        data.removeLast()
        balance()
    }

    private fun balance() {
        var currentIndex = data.size
        while (currentIndex > 1) {
            if (currentIndex % 2 == 0) {
                currentIndex = processRightNode(currentIndex) ?: return
            } else {
               currentIndex = processLeftNode(currentIndex) ?: return
            }
        }
    }

    private fun processLeftNode(currentIndex: Int): Int?{
        val parentIndex = ((currentIndex - 1) / 2)
        return if (data[currentIndex - 1] > data[parentIndex - 1]) {
            swapValues(currentIndex, parentIndex)
        } else {
            null
        }
    }

    private fun processRightNode(currentIndex: Int): Int? {
        val parentIndex = (currentIndex / 2)
        return if (data[currentIndex - 1] > data[parentIndex - 1]) {
            swapValues(currentIndex, parentIndex)
        } else {
            null
        }
    }

    private fun swapValues(currentIndex:Int, parentIndex: Int): Int {
        val aux = data[parentIndex - 1]
        data[parentIndex - 1] = data[currentIndex - 1]
        data[currentIndex - 1] = aux
        return parentIndex
    }
}
