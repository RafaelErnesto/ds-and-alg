package dataStructures.tree

import dataStructures.tree.binary.BinaryTree
import dataStructures.tree.binary.Node
import dataStructures.tree.binary.TraverseMode

fun main() {
    val binaryTree = BinaryTree()
    binaryTree.add(Node(value = 5))
    binaryTree.add(Node(value = 3))
    binaryTree.add(Node(value = 2))
    binaryTree.add(Node(value = 4))
    binaryTree.add(Node(value = 7))
    binaryTree.add(Node(value = 6))
    binaryTree.add(Node(value = 8))

   // binaryTree.traverse(TraverseMode.IN_ORDER)
    binaryTree.traverse(TraverseMode.PRE_ORDER)
}