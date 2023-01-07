package dataStructures.tree

class BinaryTreeTraversal {

    companion object {
        fun preOrderTraversal(tree: List<*>, index: Int = 1) {
            if (tree.size < index) return
            println(tree[index - 1])
            preOrderTraversal(tree, 2 * index)
            preOrderTraversal(tree, 2 * index + 1)
        }

        fun inOrderTraversal(tree: List<*>, index: Int = 1) {
            if (tree.size < index) return
            inOrderTraversal(tree, 2 * index)
            println(tree[index - 1])
            inOrderTraversal(tree, 2 * index + 1)
        }

        fun postOrderTraversal(tree: List<*>, index: Int = 1) {
            if (tree.size < index) return
            postOrderTraversal(tree, 2 * index)
            postOrderTraversal(tree, 2 * index + 1)
            println(tree[index - 1])
        }
    }
}