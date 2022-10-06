package sorting.insertion_sort

import sorting.bubble_sort.BubbleSort

val INPUT_DATA = arrayOf(2,3,6,2,8,9,0,5,4,3,1,3,4,6,98,6,5,3,2,4,556,6,4,3,45,6,7,3,3,4,6,87,4,3,4)

class InsertionSort {

    companion object{
        fun sort(){
            for ((index, _) in INPUT_DATA.withIndex()){
                var j = index + 1;
                if (j < INPUT_DATA.size && INPUT_DATA[index] > INPUT_DATA[j]){
                    var valueToSort = INPUT_DATA[j]
                    var secondIndex = j - 1
                    while (secondIndex >= 0 && valueToSort < INPUT_DATA[secondIndex]){
                        var aux = INPUT_DATA[secondIndex]
                        INPUT_DATA[secondIndex] = valueToSort
                        INPUT_DATA[secondIndex+1] = aux
                        secondIndex--
                    }
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
    InsertionSort.sort()
    InsertionSort.print()
}