package algorithms.sorting.bubble_sort

val INPUT_DATA = arrayOf(2,3,6,2,8,9,0,5,4,3,1,3,4,6,98,6,5,3,2,4,556,6,4,3,45,6,7,3,3,4,6,87,4,3,4)

class BubbleSort {

    companion object{
        fun sort(){
            var swaped = true
            var i = 0;
            while(swaped && i < INPUT_DATA.size){
                swaped = false
                var j = 0

                while (j < INPUT_DATA.size){
                    if(INPUT_DATA[i] < INPUT_DATA[j]){
                        swaped = true
                        val temp = INPUT_DATA[i]
                        INPUT_DATA[i] = INPUT_DATA[j]
                        INPUT_DATA[j] = temp
                    }
                    j++
                }
                i++
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
    BubbleSort.sort()
    BubbleSort.print()
}