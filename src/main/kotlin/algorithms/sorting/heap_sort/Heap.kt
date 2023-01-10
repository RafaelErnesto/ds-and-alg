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
        var i = data.size
        while (i > 1) {
            if (i % 2 == 0) {
                val parentIndex = (i / 2)
                if (data[i - 1] > data[parentIndex - 1]) {
                    val aux = data[parentIndex - 1]
                    data[parentIndex - 1] = data[i - 1]
                    data[i - 1] = aux
                    i = parentIndex
                } else {
                    return
                }
            } else {
                val parentIndex = ((i - 1) / 2)
                if (data[i - 1] > data[parentIndex - 1]) {
                    val aux = data[parentIndex - 1]
                    data[parentIndex - 1] = data[i - 1]
                    data[i - 1] = aux
                    i = parentIndex
                } else {
                    return
                }
            }
        }
    }
}

// 0,1,2,3,4
//[0,2,3,4,12]
