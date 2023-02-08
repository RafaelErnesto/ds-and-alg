package dataStructures.tree.avl

data class Node(
    var value: Int,
    var height: Int = 0,
    var left: Node? = null,
    var right: Node? = null
)

class AvlTree {
    private var root: Node? = null

    fun add(element: Int, node: Node? = root): Node? {
        var currentNode = node

        if (root == null) {
            root = Node(element, 1)
            return root
        }

        if (currentNode == null) {
            currentNode = Node(element, 1)
            return currentNode
        }

        if (element <= currentNode!!.value) {
            currentNode.left = add(element, currentNode.left)
        } else {
            currentNode.right = add(element, currentNode.right)
        }

        currentNode.height = calculateHeight(currentNode)

        if (balanceFactor(currentNode) == 2 && balanceFactor(currentNode.left) == 1) {
            currentNode = LLRotation(currentNode)
        } else if (balanceFactor(currentNode) == 2 && balanceFactor(currentNode.left) == -1) {
            currentNode = LRRotation(currentNode)
        } else if (balanceFactor(currentNode) == -2 && balanceFactor(currentNode.right) == -1) {
            currentNode = RRRotation(currentNode)
        } else if (balanceFactor(currentNode) == -2 && balanceFactor(currentNode.right) == 1) {
            currentNode = RLRotation(currentNode)
        }


        if (node == root) {
            root = currentNode
        }

        return currentNode
    }

    private fun LLRotation(node: Node): Node? {
        var unbalancedNode = node
        var leftChild = unbalancedNode.left
        var leftRightChild = leftChild?.right

        leftChild!!.right = unbalancedNode
        unbalancedNode.left = leftRightChild
        return leftChild
    }

    private fun LRRotation(node: Node): Node? {
        return null
    }

    private fun RRRotation(node: Node): Node? {
        var unbalancedNode = node
        var rightChild = unbalancedNode.right
        var rightLeft = rightChild?.left

        rightChild!!.left = unbalancedNode
        unbalancedNode.right = rightLeft

        unbalancedNode.height = calculateHeight(unbalancedNode)
        rightChild.height = calculateHeight(rightChild)
        return rightChild
    }

    private fun RLRotation(node: Node): Node? {
        return null
    }

    private fun calculateHeight(node: Node): Int {

        val leftSubTreeHeight: Int = if (node.left != null) node.left!!.height else 0
        val rightSubTreeHeight: Int = if (node.right != null) node.right!!.height else 0
        return if (leftSubTreeHeight > rightSubTreeHeight) leftSubTreeHeight + 1 else rightSubTreeHeight + 1
    }

    private fun balanceFactor(node: Node?): Int {
        val leftSubTreeHeight: Int = if (node?.left != null) node.left!!.height else 0
        val rightSubTreeHeight: Int = if (node?.right != null) node.right!!.height else 0
        return leftSubTreeHeight - rightSubTreeHeight
    }

    fun remove(element: Int) {

    }

    fun printPreOrderTree(node: Node? = root) {
        if (node == null) return
        println("Node: " + node.value + " height: " + node.height)
        printPreOrderTree(node.left)
        printPreOrderTree(node.right)
    }

    fun printInOrderTree(node: Node? = root) {
        if (node == null) return
        printPreOrderTree(node.left)
        println("Node: " + node.value + " height: " + node.height)
        printPreOrderTree(node.right)
    }
}