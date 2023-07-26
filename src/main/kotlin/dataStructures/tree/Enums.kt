package dataStructures.tree

import dataStructures.tree.binary.RecursiveBinaryTreeTraversal

enum class Traversals {
    PRE_ORDER {
        override fun exec(tree: List<*>) {
            RecursiveBinaryTreeTraversal.preOrderTraversal(tree)
        }
    },
    IN_ORDER {
        override fun exec(tree: List<*>) {
            RecursiveBinaryTreeTraversal.inOrderTraversal(tree)
        }
    },
    POST_ORDER {
        override fun exec(tree: List<*>) {
            RecursiveBinaryTreeTraversal.postOrderTraversal(tree)
        }
    };

    abstract fun exec(tree: List<*>)
}