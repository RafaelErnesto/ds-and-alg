package dataStructures.tree.binary

import dataStructures.tree.Traversals

open class BinaryTreeArray<T> : BinaryTree<T>() {
    protected val tree = mutableListOf<T>()
    override fun add(element: T) {
        tree.add(element)
    }

    override fun remove(element: T) {
        TODO("Not yet implemented")
    }

    override fun traverse(traverse: Traversals) {
        traverse.exec(tree)
    }

}