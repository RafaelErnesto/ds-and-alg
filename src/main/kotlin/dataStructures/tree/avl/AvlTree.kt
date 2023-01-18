package dataStructures.tree.avl

data class Node(
    var value: Int,
    var height: Int = 0,
    var left: Node? = null,
    var right: Node? = null
)
class AvlTree {
    private var root: Node? = null

    fun add(element: Int, node: Node? = root) {
        if(root == null) {
            root = Node(element)
            return
        }

        if(element <= node!!.value){
            if(node.left == null){
                node.left = Node(element)
                return
            } else {
                add(element, node.left)
            }
        }

        if(element > node!!.value) {
            if(node.right == null){
                node.right = Node(element)
                return
            } else {
                add(element, node.right)
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