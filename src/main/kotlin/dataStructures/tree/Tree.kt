package dataStructures.tree

abstract class Tree<T> {
    protected val tree = mutableListOf<T>()

    abstract fun add(element: T)

    abstract fun remove(element: T)

    abstract fun traverse(traverse: Traversals)
}