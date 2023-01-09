package dataStructures.tree

import dataStructures.tree.binary.BinaryTreeArray

fun main() {
    val intBinaryTree = BinaryTreeArray<Int>()
    for (i: Int in 1..7) {
        intBinaryTree.add(i)
    }
    val aux: Int = 0

    println("######## PRE ORDER ####################")
    intBinaryTree.traverse(Traversals.PRE_ORDER)
    println("######## IN ORDER ####################")
    intBinaryTree.traverse(Traversals.IN_ORDER)
    println("######## POST ORDER ####################")
    intBinaryTree.traverse(Traversals.POST_ORDER)
}