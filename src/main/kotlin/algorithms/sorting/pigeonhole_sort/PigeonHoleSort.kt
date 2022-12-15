package algorithms.sorting.pigeonhole_sort

val INPUT_DATA = arrayOf(29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0)

class PigeonHoleSort {

    companion object{
        fun sort(){
            var min = INPUT_DATA[0]
            var max = INPUT_DATA[0]

            for(value in INPUT_DATA){
                if(value < min){
                    min = value
                }
                if(value > max) {
                    max = value
                }
            }

            val range = max - min + 1
            val holes = IntArray(range)

            for ((index, _) in holes.withIndex()){
                holes[index] = -1
            }

            for (value in INPUT_DATA){
                holes[value - min] = value
            }
            var j = 0
            while(j < range) {
                if(holes[j] >= 0) {
                    INPUT_DATA[j] = holes[j]
                }
                j++
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
    PigeonHoleSort.sort()
    PigeonHoleSort.print()
}