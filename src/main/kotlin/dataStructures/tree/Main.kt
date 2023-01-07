package dataStructures.tree

fun main() {
    val intBinaryTree = BinaryTree()
    for (i: Int in 1..7) {
        intBinaryTree.add(i)
    }
    println("######## PRE ORDER ####################")
    intBinaryTree.traverse(Traversals.PRE_ORDER)
    println("######## IN ORDER ####################")
    intBinaryTree.traverse(Traversals.IN_ORDER)
    println("######## POST ORDER ####################")
    intBinaryTree.traverse(Traversals.POST_ORDER)
}