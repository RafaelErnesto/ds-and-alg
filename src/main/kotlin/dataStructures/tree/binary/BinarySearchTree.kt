package dataStructures.tree.binary

import dataStructures.tree.Traversals

class BinarySearchTree<T>(val tree: T): BinaryTree<T>() where T : BinaryTree<T> {
    override fun add(element: T) {
        tree.add(element)
    }

    override fun remove(element: T) {
        tree.remove(element)
    }

    override fun traverse(traverse: Traversals) {
        tree.traverse(traverse)
    }
}