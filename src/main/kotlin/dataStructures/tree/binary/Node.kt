package dataStructures.tree.binary

data class Node (
    var value: Int,
    var left: Node? = null,
    var right: Node? = null
)