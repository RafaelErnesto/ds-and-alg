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

        if (data.size == 1) {
            data.removeAt(0)
            return
        }

        data[0] = data.last()
        data.removeLast()
        balanceAfterRemoval()
    }

    private fun balanceAfterRemoval() {
        if (data.size <= 1) return

        var currentIndex = 0
        while ((2 * currentIndex + 2) < data.size) {

            var leftChildIndex = 2 * currentIndex + 1
            var rightChildIndex = 2 * currentIndex + 2
            var childToCompareIndex = 0

            childToCompareIndex = if (data[leftChildIndex] > data[rightChildIndex]) {
                leftChildIndex
            } else {
                rightChildIndex
            }

            if (data[currentIndex] < data[childToCompareIndex]) {
                var aux = data[childToCompareIndex]
                data[childToCompareIndex] = data[currentIndex]
                data[currentIndex] = aux
                currentIndex = childToCompareIndex
            } else {
                return
            }
        }
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

    private fun processLeftNode(currentIndex: Int): Int? {
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

    private fun swapValues(currentIndex: Int, parentIndex: Int): Int {
        val aux = data[parentIndex - 1]
        data[parentIndex - 1] = data[currentIndex - 1]
        data[currentIndex - 1] = aux
        return parentIndex
    }
}
