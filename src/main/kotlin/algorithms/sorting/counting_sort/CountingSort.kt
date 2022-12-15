package algorithms.sorting.counting_sort

val INPUT_DATA = arrayOf(2,3,6,2,8,9,0,5,14,3,10,3,4,6,28,6,5,3,2,4,16,6,4,3,15,6,7,3,3,4,6,27,4,3,4)
class CountingSort {

    companion object{
        fun sort(){
            val keys = IntArray(30)
            for (value in INPUT_DATA){
                keys[value]++
            }

            var pointer = 0
            for ((index, value) in keys.withIndex()){
                var i = 0
                while (i < value){
                    INPUT_DATA[pointer] = index
                    pointer++
                    i++
                }
            }
        }

        fun print(){
            for (i in INPUT_DATA){
                println(i)
            }
        }
    }
}

fun main(){
    CountingSort.sort()
    CountingSort.print()
}