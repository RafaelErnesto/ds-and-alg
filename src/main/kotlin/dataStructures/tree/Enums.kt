package dataStructures.tree

import dataStructures.tree.binary.BinaryTreeTraversal

enum class Traversals {
    PRE_ORDER {
        override fun exec(tree: List<*>) {
            BinaryTreeTraversal.preOrderTraversal(tree)
        }
    },
    IN_ORDER {
        override fun exec(tree: List<*>) {
            BinaryTreeTraversal.inOrderTraversal(tree)
        }
    },
    POST_ORDER {
        override fun exec(tree: List<*>) {
            BinaryTreeTraversal.postOrderTraversal(tree)
        }
    };

    abstract fun exec(tree: List<*>)
}