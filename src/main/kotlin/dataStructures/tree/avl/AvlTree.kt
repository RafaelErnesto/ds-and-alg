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
            } else {
                add(element, node.left)
            }
        }

        if(element > node!!.value) {
            if(node.right == null){
                node.right = Node(element)
            } else {
                add(element, node.right)
            }
        }
        node.height = calculateHeight(node)

        if (balanceFactor(node) == 2 && balanceFactor(node.left) == 1){
            return LLRotation(node)
        } else if (balanceFactor(node) == 2 && balanceFactor(node.left) == -1){
            return LRRotation(node)
        } else if (balanceFactor(node) == -2 && balanceFactor(node.right) == -1){
            return RRRotation(node)
        } else if (balanceFactor(node) == -2 && balanceFactor(node.right) == 1){
            return RLRotation(node)
        }
    }

    private fun calculateHeight(node: Node): Int{
        val leftSubTreeHeight: Int = if(node.left != null) node.left!!.height else 0
        val rightSubTreeHeight: Int = if(node.right != null) node.right!!.height else 0
        return if (leftSubTreeHeight > rightSubTreeHeight) leftSubTreeHeight + 1 else rightSubTreeHeight + 1
    }

    private fun balanceFactor(node: Node?): Int{
        val leftSubTreeHeight: Int = if(node?.left != null) node.left!!.height else 0
        val rightSubTreeHeight: Int = if(node?.right != null) node.right!!.height else 0
        return leftSubTreeHeight - rightSubTreeHeight
    }

    fun remove(element: Int) {

    }

    fun printPreOrderTree(node: Node? = root){
        if(node == null) return
        println("Node: " + node.value +" height: "+node.height)
        printPreOrderTree(node.left)
        printPreOrderTree(node.right)
    }
}