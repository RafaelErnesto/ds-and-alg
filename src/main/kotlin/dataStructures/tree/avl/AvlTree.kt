package dataStructures.tree.avl

data class Node(
    var value: Int,
    var height: Int = 0,
    var left: Node? = null,
    var right: Node? = null
)
class AvlTree {
    private var root: Node? = null

    fun add(element: Int) {
        if(root == null) {
            root = Node(element)
            return
        }

        var currentNode = root
        while(currentNode != null) {
            if(element < currentNode.value) {
                if(currentNode.left != null) {
                    currentNode = currentNode.left
                } else {
                    currentNode.left  = Node(element)
                    return
                }
            } else  if(currentNode.right != null) {
                currentNode = currentNode.right
            } else {
                currentNode.right  = Node(element)
                return
            }
        }
    }

    fun remove(element: Int) {

    }

    fun printPreOrderTree(node: Node? = root){
        if(node == null) return
        println(node.value)
        printPreOrderTree(node.left)
        printPreOrderTree(node.right)
    }
}