package dataStructures.tree

enum class Traversals {
    PRE_ORDER {
        override fun exec() {
            BinaryTreeTraversal.preOrderTraversal()
        }

    },
    IN_ORDER {
        override fun exec() {
            BinaryTreeTraversal.inOrderTraversal()
        }

    },
    POST_ORDER {
        override fun exec() {
            BinaryTreeTraversal.postOrderTraversal()
        }

    };

    abstract fun exec()
}


class BinaryTree : Tree<Int>() {

    fun add(element: Int) {
        tree.add(element)
    }

    fun traverse(traverse: Traversals) {
        traverse.exec(tree)
    }

}