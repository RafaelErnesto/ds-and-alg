package algorithms.sorting.heap_sort

class HeapUtils {

    companion object {
        private fun heapify(data: Array<Int>): Array<Int> {
            for (index in data.lastIndex downTo 0) {
                var leftChild = 2 * index + 1
                var rightChild = 2 * index + 2

                if (leftChild <= data.lastIndex && rightChild <= data.lastIndex) {
                    var biggestChild = getBiggestChild(data, leftChild, rightChild)
                    if (data[index] < data[biggestChild]) {
                        swapValues(data, index, biggestChild)
                        balance(data, biggestChild)
                    }
                } else if (leftChild <= data.lastIndex) {
                    if (data[index] < data[leftChild]) {
                        swapValues(data, index, leftChild)
                        balance(data, leftChild)
                    }
                }
            }
            return data
        }

        fun heapSort(data: Array<Int>): Array<Int> {
            var data = heapify(data)
            for (index in data.size -1 downTo 0) {
                var temp = data[index]
                data[index] = data[0]
                data[0] = temp
                balance(data, 0, index)
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

        private fun balance(data: Array<Int>, index: Int, arrayLastIndex: Int = data.size) {
            if (data.size <= 1) return

            var currentIndex = index
            while ((2 * currentIndex + 2) < arrayLastIndex) {

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

    }
}