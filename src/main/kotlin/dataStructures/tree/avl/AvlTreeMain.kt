package dataStructures.tree.avl

fun main(){
    val avl = AvlTree()
    for (i in 10 downTo 1){
        avl.add(i)
    }

    avl.printTree()
}