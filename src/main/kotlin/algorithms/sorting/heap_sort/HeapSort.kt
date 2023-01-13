package algorithms.sorting.heap_sort

class HeapSort {

    companion object {
        private fun heapify(data: Array<Int>): Array<Int> {
            for (index in data.lastIndex downTo 0) {
                var leftChildIndex = 2 * index + 1
                var rightChildIndex = 2 * index + 2

                if (leftChildIndex <= data.lastIndex && rightChildIndex <= data.lastIndex) {
                    var biggestChild = getBiggestChild(data, leftChildIndex, rightChildIndex)
                    if (data[index] < data[biggestChild]) {
                        swapValues(data, index, biggestChild)
                        balance(data, biggestChild)
                    }
                } else if (leftChildIndex <= data.lastIndex) {
                    if (data[index] < data[leftChildIndex]) {
                        swapValues(data, index, leftChildIndex)
                        balance(data, leftChildIndex)
                    }
                }
            }
            return data
        }

        fun execute(data: Array<Int>): Array<Int> {
            var heap = heapify(data)
            val root = 0
            for (index in heap.lastIndex downTo 0) {
                var temp = heap[index]
                heap[index] = heap[root]
                heap[root] = temp
                balance(heap, root, index - 1)
            }
            return data
        }

        private fun getBiggestChild(data: Array<Int>, leftChild: Int, rightChild: Int): Int =
            if (data[leftChild] > data[rightChild]) leftChild else rightChild

        private fun swapValues(data: Array<Int>, index: Int, child: Int) {
            var aux = data[index]
            data[index] = data[child]
            data[child] = aux
        }

        private fun balance(data: Array<Int>, index: Int, arrayLastIndex: Int = data.lastIndex) {
            if (data.size <= 1) return

            var currentIndex = index
            while (currentIndex <= arrayLastIndex) {

                var leftChildIndex = 2 * currentIndex + 1
                var rightChildIndex = 2 * currentIndex + 2
                if(leftChildIndex <= arrayLastIndex && rightChildIndex <= arrayLastIndex) {
                    var childToCompareIndex: Int = getBiggestChild(data, leftChildIndex, rightChildIndex)

                    if (data[currentIndex] < data[childToCompareIndex]) {
                        swapValues(data, currentIndex, childToCompareIndex)
                        currentIndex = childToCompareIndex
                    } else {
                        return
                    }
                } else if(leftChildIndex <= arrayLastIndex && data[currentIndex] < data[leftChildIndex]) {
                    swapValues(data, currentIndex, leftChildIndex)
                    currentIndex = leftChildIndex
                } else {
                    return
                }

            }
        }
    }
}